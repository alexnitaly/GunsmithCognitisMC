package net.mcreator.gunsmithcognitis.villager;

import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.BasicItemListing;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import java.util.List;
import net.minecraft.world.entity.npc.VillagerTrades;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GunsmithTrades {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
    	
        if (event.getType() == GunsmithVillager.PROFESSION.get()) {
            
            // LEVEL 1: Novice (Basic resources and entry-level gear)
            List<VillagerTrades.ItemListing> level1 = event.getTrades().get(1);
            level1.add(new BasicItemListing(new ItemStack(Items.GUNPOWDER, 12), new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(Items.STRING, 20), new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(GunsmithCognitisModItems.HANDGUNNE.get(), 1), 9, 10, 0.08f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(GunsmithCognitisModItems.HANDCANNON.get(), 1), 9, 10, 0.08f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(GunsmithCognitisModItems.MATCHLOCK_PISTOL.get(), 1), 9, 8, 0.08f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), new ItemStack(GunsmithCognitisModItems.MUSKETBALL.get(), 3), 16, 2, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(GunsmithCognitisModItems.HEAVY_MUSKETBALL.get(), 4), 16, 2, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(GunsmithCognitisModItems.MATCHLOCKGUNKIT.get(), 1), 12, 5, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.CRUDE_SMOOTHBOREBARREL.get(), 13), new ItemStack(Items.EMERALD, 2), 12, 3, 0.05f));
            level1.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.CRUDE_BIGBOREBARREL.get(), 9), new ItemStack(Items.EMERALD, 2), 10, 3, 0.05f));

            // LEVEL 2: Apprentice (Slightly more advanced components)
            List<VillagerTrades.ItemListing> level2 = event.getTrades().get(2);
            level2.add(new BasicItemListing(new ItemStack(Items.IRON_INGOT, 10), new ItemStack(Items.EMERALD, 1), 16, 10, 0.05f));
            level2.add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get(), 1), 9, 15, 0.08f));
            level2.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get(), 1), 9, 10, 0.08f));
            level2.add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(GunsmithCognitisModItems.MATCHLOCK_HEAVY_ARQUEBUS.get(), 1), 9, 15, 0.08f));
            level2.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.SMOOTHBOREBARREL.get(), 9), new ItemStack(Items.EMERALD, 3), 12, 5, 0.05f));
            level2.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.BIGBOREBARREL.get(), 9), new ItemStack(Items.EMERALD, 4), 12, 5, 0.05f));
            level2.add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(GunsmithCognitisModItems.PAPER_CARTIDGE_SMALL_AMMO.get(), 8), 16, 5, 0.08f));

            // LEVEL 3: Journeyman (Wheellock era)
            List<VillagerTrades.ItemListing> level3 = event.getTrades().get(3);
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(GunsmithCognitisModItems.WHEELLOCKGUNKIT.get(), 1), 12, 12, 0.1f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(GunsmithCognitisModItems.RIFLEDBARREL.get(), 2), 10, 10, 0.08f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(GunsmithCognitisModItems.RIFLINGTOOL.get(), 1), 15, 5, 0.05f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(GunsmithCognitisModItems.WHEELLOCK_PISTOL.get(), 1), 9, 15, 0.08f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(GunsmithCognitisModItems.WHEELLOCK_CARBINE.get(), 1), 9, 20, 0.08f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(GunsmithCognitisModItems.FLINTLOCK_PISTOL.get(), 1), 9, 20, 0.08f));
            level3.add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(GunsmithCognitisModItems.PAPER_CARTIDGE_AMMO.get(), 5), 16, 5, 0.06f));

            // LEVEL 4: Expert (Flintlock/Early Percussion, Blueprints)
            List<VillagerTrades.ItemListing> level4 = event.getTrades().get(4);
            level4.add(new BasicItemListing(new ItemStack(Items.EMERALD, 21), new ItemStack(GunsmithCognitisModItems.WHEELLOCKGUNKIT.get(), 4), new ItemStack(GunsmithCognitisModItems.WHEELLOCK_KALTHOFF_REPEATER.get(), 1), 3, 30, 0.25f));
            level4.add(new BasicItemListing(new ItemStack(Items.EMERALD, 14), new ItemStack(GunsmithCognitisModItems.FLINTLOCK_RIFLED_CARBINE.get(), 1), 9, 24, 0.08f));
            level4.add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(GunsmithCognitisModItems.FLINTLOCKMUSKET.get(), 1), 9, 16, 0.08f));
            level4.add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(GunsmithCognitisModItems.FLINTLOCK_BLUNDERBUSS.get(), 1), 7, 16, 0.08f));
            level4.add(new BasicItemListing(new ItemStack(Items.EMERALD, 24), new ItemStack(GunsmithCognitisModItems.FLINTLOCK_BLUEPRINT.get(), 1), 2, 30, 0.5f));
            level4.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.FLINTLOCK_MECHANISM.get(), 4), new ItemStack(Items.EMERALD, 1), 9, 8, 0.05f));
            level4.add(new BasicItemListing(new ItemStack(GunsmithCognitisModItems.FULMINATEPOWDER.get(), 9), new ItemStack(Items.EMERALD, 1), 10, 5, 0.06f));

            // LEVEL 5: Master (High-end components)
            List<VillagerTrades.ItemListing> level5 = event.getTrades().get(5);
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(GunsmithCognitisModItems.PERCUSSIONCAP_BLUEPRINT.get(), 1), 2, 40, 0.5f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(GunsmithCognitisModItems.PERCUSSIONNIPPLE.get(), 16), 16, 15, 0.05f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(GunsmithCognitisModItems.REVOLVER_DRUM.get(), 3), 8, 30, 0.1f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(GunsmithCognitisModItems.SHOTGUN_SHELL.get(), 8), 20, 15, 0.05f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 18), new ItemStack(GunsmithCognitisModItems.FERGUSON_RIFLE.get(), 1), 5, 35, 0.12f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get(), 1), 4, 35, 0.16f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 24), new ItemStack(GunsmithCognitisModItems.DOUBLE_BARREL_SHOTGUN.get(), 1), 6, 30, 0.12f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(GunsmithCognitisModItems.KENTUCKY_PISTOL.get(), 1), 9, 15, 0.12f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(GunsmithCognitisModItems.LORENZ_PISTOL.get(), 1), 9, 15, 0.12f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(GunsmithCognitisModItems.PATTERN_1851MINIERIFLE.get(), 1), 7, 25, 0.15f));
            level5.add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), new ItemStack(GunsmithCognitisModItems.MINIE_BALL.get(), 4), 12, 5, 0.05f));
        }
	}
}
