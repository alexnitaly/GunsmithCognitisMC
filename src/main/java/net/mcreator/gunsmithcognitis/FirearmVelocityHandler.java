package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class FirearmVelocityHandler {

    public static float getModifiedVelocity(ItemStack stack, float baseVelocity) {
        TagKey<Item> MATCHLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"));
        TagKey<Item> PISTOL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "pistol"));
        TagKey<Item> RIFLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "rifle"));
        TagKey<Item> LONG_RIFLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "long_rifle"));
        TagKey<Item> RIFLED = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "rifled_firearm"));

        float multiplier = 1.0F; // Default multiplier


        if (stack.is(LONG_RIFLE)) {
            multiplier = 2.5F;
        } else if (stack.is(RIFLE)) {
            multiplier = 2.0F;
        } else if (stack.is(PISTOL)) {
            multiplier = 1.5F;
        }

        if (stack.is(RIFLED)) {
            multiplier = 1.5F;
        } 

        if (stack.is(MATCHLOCK)) {
           multiplier = 0.75F;
        }
         
        return baseVelocity * multiplier;
    }
}
