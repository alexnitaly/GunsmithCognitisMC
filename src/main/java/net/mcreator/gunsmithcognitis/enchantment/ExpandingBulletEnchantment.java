
package net.mcreator.gunsmithcognitis.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEnchantments;

import java.util.List;

public class ExpandingBulletEnchantment extends Enchantment {
	public ExpandingBulletEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(GunsmithCognitisModEnchantments.EXPLOSIVEROUND.get(), GunsmithCognitisModEnchantments.GUN_INFINITY.get(), GunsmithCognitisModEnchantments.POISONED_BULLETS.get(), Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS,
				Enchantments.FLAMING_ARROWS, Enchantments.MULTISHOT, Enchantments.QUICK_CHARGE, Enchantments.PIERCING, Enchantments.MENDING).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get(), GunsmithCognitisModItems.HANDGUNNE.get(), GunsmithCognitisModItems.THREEEYEGUN.get(), GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get(),
				GunsmithCognitisModItems.FLINTLOCKMUSKET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get(), GunsmithCognitisModItems.FLINTLOCK_PISTOL.get(),
				GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get(), GunsmithCognitisModItems.WHEELLOCK_PISTOL.get(), GunsmithCognitisModItems.WHEELLOCK_MUSKET.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get(),
				GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get()).contains(item);
	}
}
