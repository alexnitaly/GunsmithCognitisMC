
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;

public class DiamondhalberdItem extends AxeItem {
	public DiamondhalberdItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 5.5f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.DIAMOND));
			}
		}, 1, -3.4f, new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_MELEE));
	}
}
