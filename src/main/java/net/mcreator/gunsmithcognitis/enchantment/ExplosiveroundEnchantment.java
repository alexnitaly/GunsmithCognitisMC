
package net.mcreator.gunsmithcognitis.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

import java.util.List;

public class ExplosiveroundEnchantment extends Enchantment {
	public ExplosiveroundEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(Enchantments.BINDING_CURSE, Enchantments.SHARPNESS, Enchantments.MOB_LOOTING, Enchantments.UNBREAKING, Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.INFINITY_ARROWS, Enchantments.MULTISHOT,
				Enchantments.QUICK_CHARGE, Enchantments.PIERCING, Enchantments.MENDING, Enchantments.VANISHING_CURSE).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get(), GunsmithCognitisModItems.HANDGUNNE.get(), GunsmithCognitisModItems.THREEEYEGUN.get(), GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get(),
				GunsmithCognitisModItems.FLINTLOCKMUSKET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get(), GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get(), GunsmithCognitisModItems.FLINTLOCK_PISTOL.get(),
				GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get(), GunsmithCognitisModItems.WHEELLOCK_PISTOL.get(), GunsmithCognitisModItems.WHEELLOCK_MUSKET.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get(),
				GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get(), Items.BOW, Items.CROSSBOW, GunsmithCognitisModItems.TANEGASHIMA.get(), GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get(), GunsmithCognitisModItems.JEZAILMUSKET.get(),
				GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get(), GunsmithCognitisModItems.MATCHLOCK_WALL_GUN.get(), GunsmithCognitisModItems.WHEELLOCK_CARBINE.get(), GunsmithCognitisModItems.WHEELLOCK_SPORTING_RIFLE.get(),
				GunsmithCognitisModItems.FLINTLOCK_RIFLED_CARBINE.get(), GunsmithCognitisModItems.FLINTLOCK_ASUMETTE_RIFLED_WALL_GUN.get(), GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get(),
				GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get(), GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX_CARBINE.get(), GunsmithCognitisModItems.WHEELLOCK_KALTHOFF_REPEATER.get(),
				GunsmithCognitisModItems.DIVINE_FIVE_THUNDER_MACHINE.get(), GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get(), GunsmithCognitisModItems.NOCK_VOLLEY_GUN.get(), GunsmithCognitisModItems.FERGUSON_RIFLE.get(),
				GunsmithCognitisModItems.FLINTLOCK_HAND_MORTAR.get(), GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get(), GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVING_CARBINE.get()).contains(item);
	}
}
