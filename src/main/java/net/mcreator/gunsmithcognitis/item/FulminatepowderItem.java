
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class FulminatepowderItem extends Item {
	public FulminatepowderItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_MISC_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
