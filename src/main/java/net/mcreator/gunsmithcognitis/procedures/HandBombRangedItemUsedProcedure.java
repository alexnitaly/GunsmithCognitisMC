package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.item.ItemStack;

public class HandBombRangedItemUsedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("cooldown", 56);
	}
}
