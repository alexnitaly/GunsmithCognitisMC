package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEntities;
import net.mcreator.gunsmithcognitis.item.MatchlockAxePistolItem;
import net.mcreator.gunsmithcognitis.entity.MatchlockArquebusEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockBlunderbussEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockHeavyArquebusEntity;
import net.mcreator.gunsmithcognitis.entity.HandcannonEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockPistolEntity;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModGameRules;

import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber
public class GunnerSkeletonHandler {

    private static final Random RANDOM = new Random();

   @SubscribeEvent
    public static void onSkeletonSpawn(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof Skeleton skeleton && skeleton.level.getGameRules().getBoolean(GunsmithCognitisModGameRules.CANSKELETONHAVEFIREARMS) && !event.getWorld().isClientSide()) {
            if (!skeleton.getPersistentData().getBoolean("gunsmith_checked")) {
                skeleton.getPersistentData().putBoolean("gunsmith_checked", true);

                // --- CALCULATE GUN CHANCE BASED ON DIFFICULTY ---
                double gunChance = 0.0;
                Difficulty difficulty = skeleton.level.getDifficulty();

                if (difficulty == Difficulty.HARD) {
                    gunChance = 0.50; 
                } else if (difficulty == Difficulty.NORMAL) {
                    gunChance = 0.25;  
                } else if (difficulty == Difficulty.EASY) {
                    gunChance = 0.10;
                }

                // --- ROLL FOR FIREARM ---
                if (RANDOM.nextDouble() < gunChance) { 
                    ItemStack gun = selectRandomFirearm();
                    if (!gun.isEmpty()) {
                        skeleton.setItemInHand(InteractionHand.MAIN_HAND, gun);
                        skeleton.getPersistentData().putInt("gun_cooldown", 40 + RANDOM.nextInt(40));
                        
                        if (skeleton.getAttribute(Attributes.FOLLOW_RANGE) != null) {
                            skeleton.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(45.0D);
                        }

                        applyGunnerArmor(skeleton, difficulty);
                    }
                } else {
                    // If no gun, roll for  melee weapons (Saber/Pike/Halberd)
                    applyRareMeleeWeapon(skeleton, difficulty);
                }
            }
        }

        // --- ZOMBIE MELEE WEAPONS ---
        if (event.getEntity() instanceof Zombie zombie) {
            if (!zombie.getPersistentData().getBoolean("gunsmith_checked")) {
                zombie.getPersistentData().putBoolean("gunsmith_checked", true);
                applyRareMeleeWeapon(zombie, zombie.level.getDifficulty());
            }
        }
    }

    private static void applyGunnerArmor(Skeleton skeleton, Difficulty difficulty) {
        if (difficulty == Difficulty.PEACEFUL || difficulty == Difficulty.EASY) return;

        double armorChance = (difficulty == Difficulty.HARD) ? 0.45 : 0.15;

        if (RANDOM.nextDouble() < armorChance) {
            double roll = RANDOM.nextDouble();
            
            if (roll < 0.30) {
                skeleton.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
            } else if (roll < 0.25) {
                skeleton.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_HELMET));
            } else if (roll < 0.50) {
                skeleton.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
            } 
            
            
            if (roll < 0.25) {
                skeleton.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
            } else if (roll < 0.25) {
                skeleton.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
            } else if (roll < 0.40) {
                skeleton.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
            } else {
                skeleton.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GunsmithCognitisModItems.CUIRASS_CHESTPLATE.get()));
            } 
            
            
            if (roll < 0.25) {
                skeleton.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
            } else if (roll < 0.75) {
                skeleton.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
            } else if (roll < 0.25) {
                skeleton.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
            } 
            
            skeleton.setDropChance(EquipmentSlot.CHEST, 0.08F);
            skeleton.setDropChance(EquipmentSlot.HEAD, 0.08F);
            skeleton.setDropChance(EquipmentSlot.LEGS, 0.08F);
        }
    }

    private static void applyRareMeleeWeapon(LivingEntity entity, Difficulty difficulty) {
        if (difficulty == Difficulty.PEACEFUL || difficulty == Difficulty.EASY) return;

        double meleeChance = (difficulty == Difficulty.HARD) ? 0.1 : 0.025;

        if (RANDOM.nextDouble() < meleeChance) {
            double weaponRoll = RANDOM.nextDouble();
            ItemStack meleeWeapon;

            if (weaponRoll < 0.40) {
                meleeWeapon = new ItemStack(GunsmithCognitisModItems.CAVALRY_SABRE.get());
            } else if (weaponRoll < 0.70) {
                meleeWeapon = new ItemStack(GunsmithCognitisModItems.IRONPIKE.get());
            } else {
                meleeWeapon = new ItemStack(GunsmithCognitisModItems.IRONHALBERD.get());
            }

            entity.setItemInHand(InteractionHand.MAIN_HAND, meleeWeapon);
            entity.setItemSlot(EquipmentSlot.MAINHAND, meleeWeapon);
            
            if (entity instanceof Mob mob) {
                mob.setDropChance(EquipmentSlot.MAINHAND, 0.1F);
            }
        }
    }

    @SubscribeEvent
    public static void onSkeletonUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof Skeleton skeleton && !skeleton.level.isClientSide()) {
            ItemStack gun = skeleton.getMainHandItem();
            TagKey<Item> MATCHLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"));
            TagKey<Item> WHEELLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "wheellock_firearm"));

            if (gun.is(MATCHLOCK) || gun.is(WHEELLOCK)) {
                handleGunnerAI(skeleton, gun);
            }
        }
    }

    private static void handleGunnerAI(Skeleton skeleton, ItemStack gun) {
        LivingEntity target = skeleton.getTarget();
        if (target == null) return;

        double dist = skeleton.distanceTo(target);
        TagKey<Item> BAYONET = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "has_bayonet"));
        TagKey<Item> PISTOL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "pistol"));
        boolean isMeleeCapable = (gun.getItem() instanceof MatchlockAxePistolItem || gun.is(BAYONET));

        // --- REPOSITIONING & MOVEMENT LOGIC ---
        int retreatTicks = skeleton.getPersistentData().getInt("retreat_ticks");
        double optimalMin = isMeleeCapable ? 0.0 : (gun.is(PISTOL) ? 5.0 : 8.0);
        double optimalMax = gun.is(PISTOL) ? 12.0 : 35.0;

        if (dist < 3.0 && isMeleeCapable) {
            // Melee State
            if (skeleton.attackAnim == 0) {
                skeleton.doHurtTarget(target);
                skeleton.swing(InteractionHand.MAIN_HAND);
            }
            skeleton.getNavigation().moveTo(target, 1.2D);
        } else if (retreatTicks > 0) {
            // Forced Retreat State (Bug-fix for back-and-forth jitter)
            skeleton.getNavigation().moveTo(skeleton.getX() + (skeleton.getX() - target.getX()), 
                                           skeleton.getY(), 
                                           skeleton.getZ() + (skeleton.getZ() - target.getZ()), 1.1D);
            skeleton.getPersistentData().putInt("retreat_ticks", retreatTicks - 1);
        } else if (dist < optimalMin && !isMeleeCapable) {
            // Start a random retreat delay (Dynamic Retreat Fix)
            if (RANDOM.nextDouble() < 0.15) { // 15% chance per tick to decide to run
                skeleton.getPersistentData().putInt("retreat_ticks", 40 + RANDOM.nextInt(40));
            }
        } else if (dist > optimalMax) {
            // Chase State
            skeleton.getNavigation().moveTo(target, 1.0D);
        } else {
            // Focus State (The Sweet Spot)
            skeleton.getNavigation().stop();
        }

        // --- 2. AIMING & FIRING LOGIC (Twitch Fix) ---
        int cooldown = skeleton.getPersistentData().getInt("gun_cooldown");
        int priming = skeleton.getPersistentData().getInt("priming_ticks");

        // Force looking at target whenever they are not running away
        if (retreatTicks <= 0) {
            skeleton.getLookControl().setLookAt(target, 60.0F, 60.0F);
        }

        if (cooldown > 0) {
            skeleton.getPersistentData().putInt("gun_cooldown", cooldown - 1);
            // Only lower arms if we aren't about to prime
            if (cooldown > 20) skeleton.setAggressive(false); 
        } else if (priming > 0) {
            // PRIMING PHASE
            skeleton.setAggressive(true); // Consistent Aiming
            skeleton.getPersistentData().putInt("priming_ticks", priming - 1);
            
            if (priming == 20 && gun.is(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm")))) {
                skeleton.level.playSound(null, skeleton.getX(), skeleton.getY(), skeleton.getZ(), SoundEvents.TNT_PRIMED, SoundSource.HOSTILE, 1.0F, 1.2F);
            }
            
            if (priming == 1) {
                fireGunForSkeleton(skeleton, gun);
                int baseReload = skeleton.level.getDifficulty() == Difficulty.HARD ? 70 : (skeleton.level.getDifficulty() == Difficulty.EASY ? 160 : 110);
                skeleton.getPersistentData().putInt("gun_cooldown", baseReload + RANDOM.nextInt(20));
            }
        } else if (skeleton.hasLineOfSight(target) && dist > 3.0 && retreatTicks <= 0) {
            // START FIRING SEQUENCE
            skeleton.getPersistentData().putInt("priming_ticks", gun.is(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"))) ? 25 : 5);
        }
    }

    private static void fireGunForSkeleton(Skeleton skeleton, ItemStack gun) {
        Level world = skeleton.level;
        if (!(world instanceof ServerLevel _level)) return;

        float spread = world.getDifficulty() == Difficulty.EASY ? 5.0F : (world.getDifficulty() == Difficulty.HARD ? 0.5F : 2.0F);
        TagKey<Item> SHOTGUN = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "shotgun"));
        int pellets = gun.is(SHOTGUN) ? 8 : 1;
        Item item = gun.getItem();

        for (int i = 0; i < pellets; i++) {
            if (item == GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get()) {
                spawnBullet(new MatchlockArquebusEntity(GunsmithCognitisModEntities.MATCHLOCK_ARQUEBUS.get(), skeleton, world), skeleton, 2.5F, spread, 5.0);
            } 
            else if (item == GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get() || pellets > 1) {
                spawnBullet(new MatchlockBlunderbussEntity(GunsmithCognitisModEntities.MATCHLOCK_BLUNDERBUSS.get(), skeleton, world), skeleton, 1.5F, spread * 2.5F, 3.0);
            }
            else if (item == GunsmithCognitisModItems.MATCHLOCK_HEAVY_ARQUEBUS.get()) {
                spawnBullet(new MatchlockHeavyArquebusEntity(GunsmithCognitisModEntities.MATCHLOCK_HEAVY_ARQUEBUS.get(), skeleton, world), skeleton, 3.0F, spread * 0.75F, 7.0);
            }
            else if (item == GunsmithCognitisModItems.HANDCANNON.get()) {
                spawnBullet(new HandcannonEntity(GunsmithCognitisModEntities.HANDCANNON.get(), skeleton, world), skeleton, 2.2F, spread, 6.0);
            }
            else if (item == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get() || item == GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get()) {
                spawnBullet(new WheellockPistolEntity(GunsmithCognitisModEntities.WHEELLOCK_PISTOL.get(), skeleton, world), skeleton, 1.5F, spread * 1.5F, 4.0);
            }
            else {
                // Fallback for generic guns
                spawnBullet(new MatchlockArquebusEntity(GunsmithCognitisModEntities.MATCHLOCK_ARQUEBUS.get(), skeleton, world), skeleton, 2.0F, spread, 4.0);
            }
        }

        _level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, skeleton.getX(), skeleton.getY() + 1.5, skeleton.getZ(), 12, 0.01, 0.01, 0.01, 0.01);
        world.playSound(null, skeleton.getX(), skeleton.getY(), skeleton.getZ(), 
            ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gunsmith_cognitis", "musket_shot")), SoundSource.HOSTILE, 1.0F, 1.0F);
    }

    private static void spawnBullet(net.minecraft.world.entity.projectile.AbstractArrow bullet, Skeleton skeleton, float power, float spread, double damage) {
        double px = skeleton.getX() + skeleton.getLookAngle().x * 0.5;
        double py = skeleton.getEyeY() - 0.1;
        double pz = skeleton.getZ() + skeleton.getLookAngle().z * 0.5;
        
        bullet.setPos(px, py, pz);
        bullet.setOwner(skeleton);
        bullet.shoot(skeleton.getLookAngle().x, skeleton.getLookAngle().y, skeleton.getLookAngle().z, power, spread);
        bullet.setBaseDamage(damage);
        
        if (!skeleton.level.isClientSide()) {
            skeleton.level.addFreshEntity(bullet);
        }
    }

    private static ItemStack selectRandomFirearm() {
        double roll = RANDOM.nextDouble();
        ResourceLocation tagLoc = (RANDOM.nextDouble() < 0.25) ? 
            new ResourceLocation("gunsmith_cognitis", "wheellock_firearm") : 
            new ResourceLocation("gunsmith_cognitis", "matchlock_firearm");
        
        if (roll < 0.40) return new ItemStack(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get());
        if (roll < 0.55) return new ItemStack(GunsmithCognitisModItems.WHEELLOCK_PISTOL.get());
        if (roll < 0.65) return new ItemStack(GunsmithCognitisModItems.MATCHLOCK_HEAVY_ARQUEBUS.get());
        if (roll < 0.70) return new ItemStack(GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get());

        TagKey<Item> tag = TagKey.create(Registry.ITEM_REGISTRY, tagLoc);
        List<Item> tagItems = ForgeRegistries.ITEMS.tags().getTag(tag).stream().collect(Collectors.toList());
        return tagItems.isEmpty() ? new ItemStack(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get()) : new ItemStack(tagItems.get(RANDOM.nextInt(tagItems.size())));
    }

    @SubscribeEvent
    public static void onSkeletonDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Skeleton skeleton) {
            ItemStack gun = skeleton.getMainHandItem();
            TagKey<Item> FIREARM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "firearm"));
            if (gun.is(FIREARM)) {
                event.getDrops().removeIf(item -> item.getItem().getItem() == Items.BOW || item.getItem().getItem() == Items.ARROW);
                if (RANDOM.nextDouble() < 0.15) {
                    ItemStack dropGun = gun.copy();
                    dropGun.setDamageValue(RANDOM.nextInt(dropGun.getMaxDamage()));
                    addDrop(event, dropGun);
                }
                if (RANDOM.nextDouble() < 0.2) addDrop(event, new ItemStack(Items.IRON_INGOT, RANDOM.nextInt(2) + 1));
                if (RANDOM.nextDouble() < 0.1) addDrop(event, new ItemStack(Items.FLINT_AND_STEEL, 1));
                if (RANDOM.nextDouble() < 0.4) addDrop(event, new ItemStack(GunsmithCognitisModItems.MUSKETBALL.get(), RANDOM.nextInt(4) + 1));
                if (RANDOM.nextDouble() < 0.5) addDrop(event, new ItemStack(Items.GUNPOWDER, RANDOM.nextInt(4) + 1));
            }
        }
    }

    private static void addDrop(LivingDropsEvent event, ItemStack stack) {
        event.getDrops().add(new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), stack));
    }
}