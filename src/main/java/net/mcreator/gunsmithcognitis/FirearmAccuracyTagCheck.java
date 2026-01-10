
package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class FirearmAccuracyTagCheck 
{
	public static float getSpread(ItemStack stack)  
	{
        TagKey<Item> MATCHLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"));
        
        TagKey<Item> RIFLED = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "rifled_firearm"));
        TagKey<Item> SMOOTHBORE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "smoothbore_firearm"));

        TagKey<Item> PISTOL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "pistol"));
        TagKey<Item> LONG_RIFLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "long_rifle"));

        // Default spread
        float spread = 1.0F; 

        // Check tags and adjust spread
        if (stack.is(RIFLED)) {
            spread = 0.1F;
        } else if (stack.is(SMOOTHBORE)) {
            spread = 4.5F;
        }
        
        if (stack.is(MATCHLOCK)) {
            spread *= 1.5F;
        }

        if (stack.is(PISTOL)) {
            spread *= 1.5F;
        } else if (stack.is(LONG_RIFLE)) {
            spread *= 0.5F;
        }

        return spread;
	}
}