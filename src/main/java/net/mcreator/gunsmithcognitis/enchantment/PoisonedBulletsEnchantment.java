
package net.mcreator.gunsmithcognitis.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEnchantments;

import java.util.List;

public class PoisonedBulletsEnchantment extends Enchantment {
	public PoisonedBulletsEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return level * 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(GunsmithCognitisModEnchantments.EXPLOSIVEROUND.get(), GunsmithCognitisModEnchantments.GUN_INFINITY.get(), Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.FLAMING_ARROWS, Enchantments.INFINITY_ARROWS,
				Enchantments.QUICK_CHARGE, Enchantments.PIERCING, Enchantments.MENDING, Enchantments.VANISHING_CURSE, Enchantments.MULTISHOT).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(GunsmithCognitisModItems.HANDGUNNE.get(), GunsmithCognitisModItems.THREEEYEGUN.get(), GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get(), GunsmithCognitisModItems.FLINTLOCKMUSKET.get(),
				GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get(), GunsmithCognitisModItems.FLINTLOCK_PISTOL.get(), GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get(),
				GunsmithCognitisModItems.WHEELLOCK_PISTOL.get(), GunsmithCognitisModItems.WHEELLOCK_MUSKET.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get(), GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get(),
				GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get()).contains(item);
	}
}
