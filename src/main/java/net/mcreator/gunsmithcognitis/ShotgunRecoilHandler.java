package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.world.InteractionHand;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModGameRules;

@Mod.EventBusSubscriber
public class ShotgunRecoilHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        
        if (event.phase == TickEvent.Phase.END && !player.level.isClientSide()) {
            for (InteractionHand hand : InteractionHand.values()) {
                ItemStack stack = player.getItemInHand(hand);
                
                if (stack.hasTag() && stack.getOrCreateTag().getBoolean("backblast")) {
                    stack.getOrCreateTag().putBoolean("backblast", false);

                    TagKey<net.minecraft.world.item.Item> SHOTGUN_TAG = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "shotgun"));
                    
                    if (stack.is(SHOTGUN_TAG) && player.level.getGameRules().getBoolean(GunsmithCognitisModGameRules.SHOTGUNBACKBLAST)) {
                        
                        if (player.isInWater()) return;

                        //Get Gamerule Multiplier (10 = 1.0x)
                        double gameruleValue = (double) player.level.getGameRules().getInt(GunsmithCognitisModGameRules.SHOTGUNBACKBLASTMULTIPLIER);
                        double multiplier = gameruleValue / 10.0;

                        //Base Physics Variables
                        Vec3 look = player.getLookAngle();
                        Vec3 currentMotion = player.getDeltaMovement();
                        
                        double strength = 0.8 * multiplier; 
                        double upForce = 0.35 * multiplier; 

                        // AIR-BORNE / FALLING LOGIC (SHOTGUN COP STEVE IT IS I, JUSTICE OR DIE.)
                        if (!player.isOnGround()) {
                               //If the player is falling (currentMotion.y < 0) AND looking significantly downward (look.y < -0.7)
                            if (currentMotion.y < 0 && look.y < -0.7) {
                                // We invert the falling speed and add the base upForce.
                                // Math.abs(currentMotion.y) ensures we get a positive number.
                                upForce = (Math.abs(currentMotion.y) * multiplier) + (0.2 * multiplier);
                                
                                // We also boost horizontal kick slightly for "Air-strafing"
                                strength *= 1.2;
                            } else {
                                // Standard air-recoil if not falling/looking down
                                strength *= 2.5;
                                upForce *= 0.5;
                            }
                        }

                        // Apply Final Motion
                        player.setDeltaMovement(new Vec3(-look.x * strength, upForce, -look.z * strength));

                        // Network Sync & Impulse
                        player.hasImpulse = true;
                        player.hurtMarked = true; 
                        
                        if (player instanceof ServerPlayer serverPlayer) {
                            serverPlayer.connection.send(new ClientboundSetEntityMotionPacket(serverPlayer));
                        }
                    }
                }
            }
        }
    }
}