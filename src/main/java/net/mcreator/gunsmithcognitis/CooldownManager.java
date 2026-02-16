package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

@Mod.EventBusSubscriber
public class CooldownManager {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.level.isClientSide()) {
            Player player = event.player;
            processStack(player.getMainHandItem(), player);
            processStack(player.getOffhandItem(), player);
        }
    }

    private static void processStack(ItemStack stack, Player player) {
        if (stack.isEmpty() || !stack.hasTag()) return;

        CompoundTag nbt = stack.getOrCreateTag();
        
        if (nbt.contains("cooldown") && nbt.getInt("cooldown") > 0) {
            int current = nbt.getInt("cooldown");
            nbt.putInt("cooldown", current - 1);
        }
    }
}
