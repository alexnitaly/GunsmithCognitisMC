
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class GunsmithCognitisModTabs {
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_TAB;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_MELEE;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_WHEELLOCK_TAB;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_FLINTLOCK_TAB;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_PERCUSSIONCAP_TAB;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_MISC_TAB;
	public static CreativeModeTab TAB_GUNSMITH_COGNITIS_RESEARCH_TAB;

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
		TAB_GUNSMITH_COGNITIS_MELEE = new CreativeModeTab("tabgunsmith_cognitis_melee") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.CAVALRY_SABRE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GUNSMITH_COGNITIS_WHEELLOCK_TAB = new CreativeModeTab("tabgunsmith_cognitis_wheellock_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.WHEELLOCK_PISTOL.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GUNSMITH_COGNITIS_FLINTLOCK_TAB = new CreativeModeTab("tabgunsmith_cognitis_flintlock_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.FLINTLOCKMUSKET.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GUNSMITH_COGNITIS_PERCUSSIONCAP_TAB = new CreativeModeTab("tabgunsmith_cognitis_percussioncap_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.FUSIL_1866_CHASSEPOT.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GUNSMITH_COGNITIS_MISC_TAB = new CreativeModeTab("tabgunsmith_cognitis_misc_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GunsmithCognitisModItems.FULMINATEPOWDER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GUNSMITH_COGNITIS_RESEARCH_TAB = new CreativeModeTab("tabgunsmith_cognitis_research_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.PAPER);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
