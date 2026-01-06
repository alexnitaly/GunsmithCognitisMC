package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.item.ItemStack;

public class FirearmCanFireProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("ammo") > 0;
	}
}
