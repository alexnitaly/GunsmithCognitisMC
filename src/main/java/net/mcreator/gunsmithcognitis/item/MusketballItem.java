
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class MusketballItem extends Item {
	public MusketballItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
