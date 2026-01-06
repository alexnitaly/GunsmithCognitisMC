
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class GunsmithCognitisModTabs {
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_TAB;

	public static void load() {
		TAB_GUNSMITH_COGNITIS_TAB = new CreativeModeTab("tabgunsmith_cognitis_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
