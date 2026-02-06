package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEntities;
import net.mcreator.gunsmithcognitis.entity.WheellockPistolEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockHandMortarEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketEntity; // Used as fallback for Musket logic

import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.item.FlintAndSteelItem;

@Mod.EventBusSubscriber
public class GunnerPillagerHandler {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onPillagerSpawn(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof Pillager pillager && !event.getWorld().isClientSide()) {
            if (!pillager.getPersistentData().getBoolean("gunsmith_checked")) {
                pillager.getPersistentData().putBoolean("gunsmith_checked", true);

                // --- 1. DIFFICULTY-BASED SPAWN CHANCE ---
                double gunChance = 0.0;
                Difficulty diff = pillager.level.getDifficulty();
                if (diff == Difficulty.HARD) gunChance = 0.66;
                else if (diff == Difficulty.NORMAL) gunChance = 0.33;
                else if (diff == Difficulty.EASY) gunChance = 0.10;

                if (RANDOM.nextDouble() < gunChance) { 
                    ItemStack gun = selectPillagerFirearm();
                    if (!gun.isEmpty()) {
                        pillager.setItemInHand(InteractionHand.MAIN_HAND, gun);
                        pillager.getPersistentData().putInt("gun_cooldown", 30 + RANDOM.nextInt(30));
                        
                        // Increase detection range for these "Marksmen"
                        if (pillager.getAttribute(Attributes.FOLLOW_RANGE) != null) {
                            pillager.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(45.0D);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPillagerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof Pillager pillager && !pillager.level.isClientSide()) {
            ItemStack gun = pillager.getMainHandItem();
            TagKey<Item> WHEELLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "wheellock_firearm"));
            TagKey<Item> FLINTLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "flintlock_firearm"));

            if (gun.is(WHEELLOCK) || gun.is(FLINTLOCK)) {
                handlePillagerGunAI(pillager, gun);
            }
        }
    }

    private static void handlePillagerGunAI(Pillager pillager, ItemStack gun) {
        LivingEntity target = pillager.getTarget();
        if (target == null || !target.isAlive()) {
            pillager.setAggressive(false);
            pillager.setChargingCrossbow(false);
            return;
        }

        double dist = pillager.distanceTo(target);
        TagKey<Item> PISTOL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "pistol"));
        
        // --- REPOSITIONING ---
        int retreatTicks = pillager.getPersistentData().getInt("retreat_ticks");
        double optimalMin = gun.is(PISTOL) ? 3.0 : 6.0;
        double optimalMax = gun.is(PISTOL) ? 12.0 : 35.0;

        if (retreatTicks > 0) {
            pillager.getNavigation().moveTo(pillager.getX() + (pillager.getX() - target.getX()), pillager.getY(), pillager.getZ() + (pillager.getZ() - target.getZ()), 1.1D);
            pillager.getPersistentData().putInt("retreat_ticks", retreatTicks - 1);
            pillager.setAggressive(false);
            pillager.setChargingCrossbow(false);
        } else if (dist < optimalMin) {
            if (RANDOM.nextDouble() < 0.10) pillager.getPersistentData().putInt("retreat_ticks", 50 + RANDOM.nextInt(30));
        } else if (dist > optimalMax) {
            pillager.getNavigation().moveTo(target, 1.0D);
        } else {
            pillager.getNavigation().stop();
        }

        // --- ANIMATION & COMBAT STATE MACHINE ---
        int cooldown = pillager.getPersistentData().getInt("gun_cooldown");
        int priming = pillager.getPersistentData().getInt("priming_ticks");

        if (retreatTicks <= 0) {
            pillager.getLookControl().setLookAt(target, 100.0F, 100.0F);
            pillager.yBodyRot = pillager.yHeadRot; 
        }

        if (cooldown > 0) {
            pillager.getPersistentData().putInt("gun_cooldown", cooldown - 1);
            
            // PHASE: RELOADING (Two-Handed Crossbow Charge Animation)
            if (cooldown < 35 && retreatTicks <= 0) {
                pillager.setChargingCrossbow(true);
                pillager.setAggressive(false);
            } else {
                pillager.setChargingCrossbow(false);
                pillager.setAggressive(false);
            }
        } else if (priming > 0) {
            // PHASE: AIMING (Aggressive Animation)
            pillager.setChargingCrossbow(false);
            pillager.setAggressive(true);
            
            pillager.getPersistentData().putInt("priming_ticks", priming - 1);
            pillager.getLookControl().setLookAt(target, 100.0F, 100.0F);

            if (priming == 1) {
                fireGunForPillager(pillager, gun);
                int baseReload = pillager.level.getDifficulty() == Difficulty.HARD ? 60 : 100;
                pillager.getPersistentData().putInt("gun_cooldown", baseReload + RANDOM.nextInt(20));
           
        } else if (pillager.hasLineOfSight(target) && retreatTicks <= 0) {
            pillager.getPersistentData().putInt("priming_ticks", 12); 
        }
    }

    private static ItemStack selectPillagerFirearm() {
        double roll = RANDOM.nextDouble();
        // 75% Wheellock / 25% Flintlock
        ResourceLocation tagLoc = (RANDOM.nextDouble() < 0.25) ? 
            new ResourceLocation("gunsmith_cognitis", "flintlock_firearm") : 
            new ResourceLocation("gunsmith_cognitis", "wheellock_firearm");

        // Specific Weights
        if (roll < 0.40) return new ItemStack(GunsmithCognitisModItems.WHEELLOCK_PISTOL.get());
        if (roll < 0.70) return new ItemStack(GunsmithCognitisModItems.WHEELLOCK_MUSKET.get());
        if (roll < 0.35) return new ItemStack(GunsmithCognitisModItems.FLINTLOCKMUSKET.get());
        if (roll < 0.45) return new ItemStack(GunsmithCognitisModItems.FLINTLOCK_PISTOL.get());

        TagKey<Item> tag = TagKey.create(Registry.ITEM_REGISTRY, tagLoc);
        List<Item> tagItems = ForgeRegistries.ITEMS.tags().getTag(tag).stream().collect(Collectors.toList());
        return tagItems.isEmpty() ? new ItemStack(GunsmithCognitisModItems.WHEELLOCK_MUSKET.get()) : new ItemStack(tagItems.get(RANDOM.nextInt(tagItems.size())));
    }

    private static void fireGunForPillager(Pillager pillager, ItemStack gun) {
        Level world = pillager.level;
        if (!(world instanceof ServerLevel _level)) return;

        float spread = world.getDifficulty() == Difficulty.EASY ? 2.5F : (world.getDifficulty() == Difficulty.HARD ? 0.5F : 1.25F);
        Item item = gun.getItem();
        // SPWNANING PROJECTILE

        if (item == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get() || item == GunsmithCognitisModItems.FLINTLOCK_PISTOL.get()) {
            spawnBullet(new WheellockPistolEntity(GunsmithCognitisModEntities.WHEELLOCK_PISTOL.get(), pillager, world), pillager, 1.5F, spread * 1.25F, 5.0);
        } else if (item == GunsmithCognitisModItems.FLINTLOCK_HAND_MORTAR.get()) {
            spawnBullet(new FlintlockHandMortarEntity(GunsmithCognitisModEntities.FLINTLOCK_HAND_MORTAR.get(), pillager, world), pillager, 2.5F, spread, 7.0);
        } else {
            spawnBullet(new FlintlockmusketEntity(GunsmithCognitisModEntities.FLINTLOCKMUSKET.get(), pillager, world), pillager, 2.5F, spread, 7.0);
        }

        // VISUALS
        _level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pillager.getX(), pillager.getY() + 1.5, pillager.getZ(), 10, 0.1, 0.1, 0.1, 0.01);
        world.playSound(null, pillager.getX(), pillager.getY(), pillager.getZ(), 
            ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gunsmith_cognitis", "musket_shot")), SoundSource.HOSTILE, 1.0F, 1.1F);
    }

    private static void spawnBullet(net.minecraft.world.entity.projectile.AbstractArrow bullet, Pillager pillager, float power, float spread, double damage) {
        bullet.setPos(pillager.getX() + pillager.getLookAngle().x * 0.5, pillager.getEyeY() - 0.1, pillager.getZ() + pillager.getLookAngle().z * 0.5);
        bullet.setOwner(pillager);
        bullet.shoot(pillager.getLookAngle().x, pillager.getLookAngle().y, pillager.getLookAngle().z, power, spread);
        bullet.setBaseDamage(damage);
        if (!pillager.level.isClientSide()) pillager.level.addFreshEntity(bullet);
    }

    @SubscribeEvent
    public static void onPillagerDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Pillager pillager) {
            ItemStack gun = pillager.getMainHandItem();
            if (gun.is(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "firearm")))) {
                event.getDrops().removeIf(item -> item.getItem().getItem() == Items.CROSSBOW);
                
                if (RANDOM.nextDouble() < 0.15) {
                    ItemStack dropGun = gun.copy();
                    dropGun.setDamageValue(RANDOM.nextInt(dropGun.getMaxDamage()));
                    addDrop(event, dropGun);
                }

                if (RANDOM.nextDouble() < 0.3) addDrop(event, new ItemStack(Items.IRON_INGOT, RANDOM.nextInt(2) + 1));
                if (RANDOM.nextDouble() < 0.3) addDrop(event, new ItemStack(Items.GUNPOWDER, RANDOM.nextInt(4) + 1));
                if (RANDOM.nextDouble() < 0.4) addDrop(event, new ItemStack(GunsmithCognitisModItems.MUSKETBALL.get(), RANDOM.nextInt(6) + 1));
                if (RANDOM.nextDouble() < 0.2) addDrop(event, new ItemStack(GunsmithCognitisModItems.RAMROD.get(), 1));
                
                // Tier-Specific Kits
                if (gun.is(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "wheellock_firearm"))) && RANDOM.nextDouble() < 0.1)
                    addDrop(event, new ItemStack(GunsmithCognitisModItems.WHEELLOCKGUNKIT.get()));
                if (gun.is(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "flintlock_firearm"))) && RANDOM.nextDouble() < 0.05)
                	if (RANDOM.nextDouble() < 0.5) 
                	{
                		addDrop(event, new ItemStack(GunsmithCognitisModItems.FLINTLOCK_MECHANISM.get(), RANDOM.nextInt(1) + 1));
                	} else {
                		addDrop(event, new ItemStack(GunsmithCognitisModItems.FLINTLOCKGUNKIT.get(), 1));
                	}
            }
        }
    }

    private static void addDrop(LivingDropsEvent event, ItemStack stack) {
        event.getDrops().add(new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), stack));
    }
}