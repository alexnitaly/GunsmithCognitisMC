
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GunsmithCognitisModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(GunsmithCognitisModItems.IRONPIKE.get()), 10, 8, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(GunsmithCognitisModItems.IRONHALBERD.get()), 10, 8, 0.09999999999999999f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

					new ItemStack(GunsmithCognitisModItems.DIAMONDPIKE.get()), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

					new ItemStack(GunsmithCognitisModItems.DIAMONDHALBERD.get()), 10, 15, 0.09999999999999999f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 24),

					new ItemStack(GunsmithCognitisModItems.CAVALRY_SABRE.get()), 10, 30, 0.15000000000000002f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14),

					new ItemStack(GunsmithCognitisModItems.CUIRASS_CHESTPLATE.get()), 10, 20, 0.15f));
		}
		if (event.getType() == VillagerProfession.FLETCHER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

					new ItemStack(GunsmithCognitisModItems.ROCK.get(), 8), 20, 3, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(GunsmithCognitisModItems.HANDGUNNE.get()), 8, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 24),

					new ItemStack(GunsmithCognitisModItems.HANDCANNON.get()), 8, 20, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 40),

					new ItemStack(GunsmithCognitisModItems.MATCHLOCK_HEAVY_ARQUEBUS.get()), 6, 35, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32),

					new ItemStack(GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get()), 6, 35, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 40), new ItemStack(Items.CLOCK), new ItemStack(GunsmithCognitisModItems.WHEELLOCK_SPORTING_RIFLE.get()), 4, 50, 0.2f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),

					new ItemStack(GunsmithCognitisModItems.HEAVY_MUSKETBALL.get(), 4), 16, 5, 0.05f));
		}
	}
}
