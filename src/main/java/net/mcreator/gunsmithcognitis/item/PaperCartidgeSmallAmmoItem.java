
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class PaperCartidgeSmallAmmoItem extends Item {
	public PaperCartidgeSmallAmmoItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_MISC_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
