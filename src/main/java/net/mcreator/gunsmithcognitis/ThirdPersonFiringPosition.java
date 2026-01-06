package net.mcreator.gunsmithcognitis; // Matches your package

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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ThirdPersonFiringPosition {

    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Pre event) {
        Player player = event.getPlayer();
        if (player == null) return;

        ItemStack mainHand = player.getMainHandItem();

        // Is it from my mod?
        if (!mainHand.isEmpty() && mainHand.getItem().getRegistryName().getNamespace().equals("gunsmith_cognitis")) {
            
            // Access the Item's NBT Tag
            CompoundTag nbt = mainHand.getTag();
            
            // Check if the "ammo" tag exists and is greater than 0
            if (nbt != null && nbt.contains("ammo") && nbt.getInt("ammo") > 0) {
                
                PlayerModel<AbstractClientPlayer> model = event.getRenderer().getModel();
                
                model.rightArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
            }
        }
    }
}
