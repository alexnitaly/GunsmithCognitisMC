package net.mcreator.gunsmithcognitis.events;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = "gunsmith_cognitis")
public class MatchlockFireDelaySafetyHandler {

    // THIS IS TO FIX MATCHLOCKFIREDELAY: if you try to fire again during a fire delay, it would break the gun, this is a FIX! DON'T REMOVE IT.
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onGunRightClick(PlayerInteractEvent.RightClickItem event) {
        ItemStack item = event.getItemStack();
        
        if (item.hasTag()) {
            boolean isFiring = item.getTag().getBoolean("IsFiring");
            
            if (isFiring) {
                // BY GOD IF THIS DOESN'T WORK I WILL CRY.
                event.setCanceled(true);
                // IT WORKED YIPPIE.
            }
        }
    }
}
