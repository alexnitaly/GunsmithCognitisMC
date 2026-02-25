package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class PorterTurretRifleItemUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemstack) != 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, (y + 1.5), z, 8, 0, 0, 0, 0.015);
			itemstack.getOrCreateTag().putBoolean("cocked", (false));
			itemstack.getOrCreateTag().putDouble("cooldown", 30);
		} else {
			if (!(itemstack.getOrCreateTag().getDouble("ammo") < 1)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 1.5), z, 6, 0, 0, 0, 0.0025);
				itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
				itemstack.getOrCreateTag().putDouble("cooldown", 8);
				itemstack.getOrCreateTag().putBoolean("cocked", (false));
			}
		}
	}
}
