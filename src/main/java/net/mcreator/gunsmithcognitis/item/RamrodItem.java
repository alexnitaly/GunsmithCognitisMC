
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class RamrodItem extends Item {
	public RamrodItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_MISC_TAB).durability(59).rarity(Rarity.COMMON));
	}
}
