package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.item.ItemStack;

public class FirearmItemUsedProcedure {
	public static void execute(ItemStack itemstack) {
		if (!(itemstack.getOrCreateTag().getDouble("ammo") < 1)) {
			itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
		}
	}
}
