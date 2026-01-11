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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

@Mod.EventBusSubscriber
public class LootInjectionHandler {

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();
        
        // Define our custom Tags
        TagKey<Item> MATCHLOCKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "matchlock_firearm"));
        TagKey<Item> WHEELLOCKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "wheellock_firearm"));
        TagKey<Item> FLINTLOCKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "flintlock_firearm"));

        // VILLAGES & DUNGEONS
        if (name.toString().equals("minecraft:chests/village/village_weaponsmith") || 
            name.toString().equals("minecraft:chests/village/village_fletcher") || 
            name.toString().equals("minecraft:chests/simple_dungeon")) {
            
            // Matchlock Tag
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(MATCHLOCKS).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(9)).build());

            // Gunpowder
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(Items.GUNPOWDER).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(3)).build());
        }

        // MANSIONS, OUTPOSTS
        if (name.toString().equals("minecraft:chests/woodland_mansion") || 
            name.toString().equals("minecraft:chests/pillager_outpost") || 
            name.toString().equals("minecraft:chests/stronghold_corridor")) {
            
            // Wheellock Tag
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(WHEELLOCKS).setWeight(2))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(7)).build());

            // Flintlock Blueprint
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(11)).build());
        }

		//STRONGHOLD
        if (name.toString().equals("minecraft:chests/stronghold_corridor")) {
            
            // Wheellock Tag
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(WHEELLOCKS).setWeight(2))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(5)).build());
            
            // Flintlocks
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(FLINTLOCKS).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(5)).build());

            // Cartridges
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_SMALL_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(3)) 
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).build());

            // Flintlock Blueprint
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(7)).build());
        }

        
        // DESERT PYRAMID
        if (name.toString().equals("minecraft:chests/desert_pyramid")) {
            // Jezail
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.JEZAILMUSKET.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(2)).build());

            // Blueprint
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(7)).build());
        }

        // JUNGLE TEMPLE
        if (name.toString().equals("minecraft:chests/jungle_temple")) {
            // Tanegashima
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.TANEGASHIMA.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(2)).build());

            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.DIVINE_FIVE_THUNDER_MACHINE.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(5)).build());
        }

        // SHIPWRECKS
        if (name.toString().equals("minecraft:chests/shipwreck_treasure")) {
            // Matchlocks
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(MATCHLOCKS).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(4)).build());

            // Flintlocks
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(FLINTLOCKS).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(6)).build());

            // Cartridges
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_SMALL_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(4)) 
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).build());

            // Flintlock Blueprint
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(5)).build());
        }

        // BASTIONS & FORTRESSES
        if (name.toString().equals("minecraft:chests/bastion_treasure") || 
            name.toString().equals("minecraft:chests/nether_bridge_fortress")) {
            
            // Flintlocks
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(TagEntry.expandTag(FLINTLOCKS).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(3)).build());

            // Cartridges
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.PAPER_CARTIDGE_SMALL_AMMO.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(2)) 
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).build());

            // Flintlock Blueprint
            event.getTable().addPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 1))
                .add(LootItem.lootTableItem(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get()).setWeight(1))
                .add(LootItem.lootTableItem(Items.AIR).setWeight(3)).build());
        }
    }
}
