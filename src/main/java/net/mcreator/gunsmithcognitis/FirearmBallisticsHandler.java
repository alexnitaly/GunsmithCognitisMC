package net.mcreator.gunsmithcognitis.events;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

@Mod.EventBusSubscriber(modid = "gunsmith_cognitis")
public class FirearmBallisticsHandler {

    private static final ResourceLocation FIREARM = new ResourceLocation("gunsmith_cognitis", "firearm");
    private static final ResourceLocation PISTOL = new ResourceLocation("gunsmith_cognitis", "pistol");
    private static final ResourceLocation AP = new ResourceLocation("gunsmith_cognitis", "armor_piercing");
    private static final ResourceLocation BULLETPROOF = new ResourceLocation("gunsmith_cognitis", "bulletproof_standard");

    private static ItemStack getFiringWeapon(LivingEntity shooter) {
        ItemStack mainHand = shooter.getMainHandItem();
        if (mainHand.is(ItemTags.create(FIREARM))) {
            return mainHand;
        }
        
        ItemStack offHand = shooter.getOffhandItem();
        if (offHand.is(ItemTags.create(FIREARM))) {
            return offHand;
        }
        
        return ItemStack.EMPTY;
    }

    @SubscribeEvent
    public static void onFirearmHitShield(LivingAttackEvent event) {
        LivingEntity target = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (source.getDirectEntity() instanceof Projectile projectile && target.isBlocking()) {
            if (source.getEntity() instanceof LivingEntity shooter) {
                
                ItemStack firingWeapon = getFiringWeapon(shooter);

                if (!firingWeapon.isEmpty()) {
                    
                    // Determine stun duration
                    int stunDuration = 100;
                    if (firingWeapon.is(ItemTags.create(PISTOL))) {
                        stunDuration = 40;
                    }
                    if (firingWeapon.is(ItemTags.create(PISTOL))) {
                        stunDuration = stunDuration * 2;
                    }

                    target.stopUsingItem();
                    
                    // Play the shield break sound and particle effect globally
                    target.level.broadcastEntityEvent(target, (byte) 30);

                    if (target instanceof Player playerTarget) {
                        // For Players: use the hotbar cooldown system
                        playerTarget.getCooldowns().addCooldown(playerTarget.getUseItem().getItem(), stunDuration);
                    } else {
                        // Mobs are staggered with slowness and weakness as well for half the time of the shield break.
                        int staggerTicks = stunDuration / 2;
                        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, staggerTicks, 2, false, false));
                        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, staggerTicks, 0, false, false));
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onFirearmDamage(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        LivingEntity target = event.getEntityLiving();

        if (source.getDirectEntity() instanceof Projectile && !source.isBypassArmor()) {
            if (source.getEntity() instanceof LivingEntity shooter) {
                
                ItemStack firingWeapon = getFiringWeapon(shooter);

                if (!firingWeapon.isEmpty()) {
                    
                    float apPercentage = 0.25f;

                    if (firingWeapon.is(ItemTags.create(AP))) {
                        boolean hasBulletproof = false;
                        for (ItemStack armorPiece : target.getArmorSlots()) {
                            if (armorPiece.is(ItemTags.create(BULLETPROOF))) {
                                hasBulletproof = true;
                                break; 
                            }
                        }
                        if (!hasBulletproof) {
                            apPercentage = 0.95f;
                        }
                    }

                    float originalDamage = event.getAmount();
                    float standardDamage = originalDamage * (1.0f - apPercentage);
                    float armorPiercingDamage = originalDamage * apPercentage;

                    event.setAmount(standardDamage);

                    int oldInvuln = target.invulnerableTime;
                    target.invulnerableTime = 0; 
                    
                    DamageSource apSource = DamageSource.indirectMagic(source.getDirectEntity(), shooter).bypassArmor();
                    target.hurt(apSource, armorPiercingDamage);
                    
                    target.invulnerableTime = oldInvuln;
                }
            }
        }
    }
}