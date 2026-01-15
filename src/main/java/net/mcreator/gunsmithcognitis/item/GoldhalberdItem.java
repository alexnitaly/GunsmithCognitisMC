
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class GoldhalberdItem extends AxeItem {
	public GoldhalberdItem() {
		super(new Tier() {
			public int getUses() {
				return 59;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 4.5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.GOLD_INGOT));
			}
		}, 1, -3f, new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_MELEE));
	}
}
