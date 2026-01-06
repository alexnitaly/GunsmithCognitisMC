
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.gunsmithcognitis.enchantment.PoisonedBulletsEnchantment;
import net.mcreator.gunsmithcognitis.enchantment.GunInfinityEnchantment;
import net.mcreator.gunsmithcognitis.enchantment.ExplosiveroundEnchantment;
import net.mcreator.gunsmithcognitis.enchantment.ExpandingBulletEnchantment;
import net.mcreator.gunsmithcognitis.GunsmithCognitisMod;

public class GunsmithCognitisModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, GunsmithCognitisMod.MODID);
	public static final RegistryObject<Enchantment> EXPLOSIVEROUND = REGISTRY.register("explosiveround", () -> new ExplosiveroundEnchantment());
	public static final RegistryObject<Enchantment> GUN_INFINITY = REGISTRY.register("gun_infinity", () -> new GunInfinityEnchantment());
	public static final RegistryObject<Enchantment> POISONED_BULLETS = REGISTRY.register("poisoned_bullets", () -> new PoisonedBulletsEnchantment());
	public static final RegistryObject<Enchantment> EXPANDING_BULLET = REGISTRY.register("expanding_bullet", () -> new ExpandingBulletEnchantment());
}
