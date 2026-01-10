/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.gunsmithcognitis as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

@Mod.EventBusSubscriber
public class FirearmRepairHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();   // The Firearm
        ItemStack right = event.getRight(); // The Repair Kit

        TagKey<Item> MATCHLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"));
        TagKey<Item> WHEELLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "wheellock_firearm"));
        TagKey<Item> FLINTLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "flintlock_firearm"));

        Item matchlockKit = GunsmithCognitisModItems.MATCHLOCKGUNKIT.get();
        Item wheellockKit = GunsmithCognitisModItems.WHEELLOCKGUNKIT.get();
        Item flintlockKit = GunsmithCognitisModItems.FLINTLOCKGUNKIT.get();

        boolean isValidRepair = false;

        if (left.is(MATCHLOCK) && right.getItem() == matchlockKit) {
            isValidRepair = true;
        } else if (left.is(WHEELLOCK) && right.getItem() == wheellockKit) {
            isValidRepair = true;
        } else if (left.is(FLINTLOCK) && right.getItem() == flintlockKit) {
            isValidRepair = true;
        }

        if (isValidRepair && left.isDamaged()) {
            ItemStack result = left.copy();
            int currentDamage = left.getDamageValue();
            int maxDamage = left.getMaxDamage();

            
            int repairAmount = maxDamage / 2; 
            int kitsNeeded = 0;
            int damageToRepair = currentDamage;

            while (damageToRepair > 0 && kitsNeeded < right.getCount()) {
                damageToRepair -= repairAmount;
                kitsNeeded++;
            }

            result.setDamageValue(Math.max(0, damageToRepair));
            
            event.setOutput(result);
            event.setCost(kitsNeeded);
            event.setMaterialCost(kitsNeeded);
        }
    }
}

