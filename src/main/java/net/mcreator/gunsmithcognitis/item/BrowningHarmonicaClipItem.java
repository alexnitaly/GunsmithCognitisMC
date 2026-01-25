
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class BrowningHarmonicaClipItem extends Item {
	public BrowningHarmonicaClipItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_PERCUSSIONCAP_TAB).stacksTo(1).rarity(Rarity.COMMON));
	}
}
