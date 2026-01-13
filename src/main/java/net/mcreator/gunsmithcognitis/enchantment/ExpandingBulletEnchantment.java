
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
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.CROSSBOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(GunsmithCognitisModEnchantments.GUN_INFINITY.get(), GunsmithCognitisModEnchantments.POISONED_BULLETS.get(), Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.FLAMING_ARROWS, Enchantments.MULTISHOT,
				Enchantments.QUICK_CHARGE, Enchantments.PIERCING, Enchantments.MENDING).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get(), GunsmithCognitisModItems.HANDGUNNE.get(), GunsmithCognitisModItems.THREEEYEGUN.get(), GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get(),
				GunsmithCognitisModItems.FLINTLOCKMUSKET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get(), GunsmithCognitisModItems.FLINTLOCK_PISTOL.get(),
				GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get(), GunsmithCognitisModItems.WHEELLOCK_PISTOL.get(), GunsmithCognitisModItems.WHEELLOCK_MUSKET.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get(),
				GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get(), GunsmithCognitisModItems.TANEGASHIMA.get(), GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get(), GunsmithCognitisModItems.JEZAILMUSKET.get(),
				GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get(), GunsmithCognitisModItems.MATCHLOCK_WALL_GUN.get(), GunsmithCognitisModItems.WHEELLOCK_CARBINE.get(), GunsmithCognitisModItems.WHEELLOCK_SPORTING_RIFLE.get(),
				GunsmithCognitisModItems.FLINTLOCK_RIFLED_CARBINE.get(), GunsmithCognitisModItems.FLINTLOCK_ASUMETTE_RIFLED_WALL_GUN.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get(),
				GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get(), GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX_CARBINE.get(), GunsmithCognitisModItems.WHEELLOCK_KALTHOFF_REPEATER.get(),
				GunsmithCognitisModItems.DIVINE_FIVE_THUNDER_MACHINE.get(), GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get(), GunsmithCognitisModItems.NOCK_VOLLEY_GUN.get(), GunsmithCognitisModItems.FERGUSON_RIFLE.get(),
				GunsmithCognitisModItems.FLINTLOCK_HAND_MORTAR.get(), GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get(), GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVING_CARBINE.get()).contains(item);
	}
}
