package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ThirdPersonFiringPosition {

    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Pre event) {
        Player player = event.getPlayer();
        if (player == null) return;

        updateArmPose(player, InteractionHand.MAIN_HAND, event);
        updateArmPose(player, InteractionHand.OFF_HAND, event);
    }

    private static void updateArmPose(Player player, InteractionHand hand, RenderPlayerEvent.Pre event) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!stack.isEmpty() && stack.getItem().getRegistryName().getNamespace().equals("gunsmith_cognitis")) {
            CompoundTag nbt = stack.getTag();
            if (nbt == null) return;

            PlayerModel<AbstractClientPlayer> model = event.getRenderer().getModel();
            
            // Check for "Jammed" or "Cooldown" (Reloading/Maintenance Phase)
            if (nbt.getBoolean("jammed") || nbt.getBoolean("cooldown") || (nbt.contains("cooldown") && nbt.getInt("cooldown") > 1)) {
                
                if (hand == InteractionHand.MAIN_HAND) {
                    model.rightArmPose = HumanoidModel.ArmPose.CROSSBOW_CHARGE;
                } else {
                    model.leftArmPose = HumanoidModel.ArmPose.CROSSBOW_CHARGE;
                }
                
            } 
            
            // Aiming Phase
            else if (nbt.contains("ammo") && nbt.getInt("ammo") > 0) {
                
                if (hand == InteractionHand.MAIN_HAND) {
                    model.rightArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
                } else {
                    model.leftArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
                }
            }
        }
    }
}