
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.gunsmithcognitis.item.WheellockgunkitItem;
import net.mcreator.gunsmithcognitis.item.WheellockPistolItem;
import net.mcreator.gunsmithcognitis.item.WheellockMusketItem;
import net.mcreator.gunsmithcognitis.item.ThreeeyegunItem;
import net.mcreator.gunsmithcognitis.item.TanegashimaItem;
import net.mcreator.gunsmithcognitis.item.RamrodItem;
import net.mcreator.gunsmithcognitis.item.PaperCartidgeSmallAmmoItem;
import net.mcreator.gunsmithcognitis.item.PaperCartidgeAmmoItem;
import net.mcreator.gunsmithcognitis.item.MusketballItem;
import net.mcreator.gunsmithcognitis.item.MusketBallProjectileItem;
import net.mcreator.gunsmithcognitis.item.MatchlockrepairItem;
import net.mcreator.gunsmithcognitis.item.MatchlockSnaphanceMusketItem;
import net.mcreator.gunsmithcognitis.item.MatchlockBlunderbussItem;
import net.mcreator.gunsmithcognitis.item.MatchlockArquebusItem;
import net.mcreator.gunsmithcognitis.item.JezailmusketItem;
import net.mcreator.gunsmithcognitis.item.HandgunneItem;
import net.mcreator.gunsmithcognitis.item.HandBombItem;
import net.mcreator.gunsmithcognitis.item.FlintlockmusketgoldItem;
import net.mcreator.gunsmithcognitis.item.FlintlockmusketbayonetItem;
import net.mcreator.gunsmithcognitis.item.FlintlockmusketItem;
import net.mcreator.gunsmithcognitis.item.FlintlockgunkitItem;
import net.mcreator.gunsmithcognitis.item.FlintlockPistolItem;
import net.mcreator.gunsmithcognitis.item.FlintlockPistolGoldItem;
import net.mcreator.gunsmithcognitis.item.FlintlockPepperboxItem;
import net.mcreator.gunsmithcognitis.item.FlintlockDoubleBarrelMusketItem;
import net.mcreator.gunsmithcognitis.item.FlintlockBlueprintItem;
import net.mcreator.gunsmithcognitis.GunsmithCognitisMod;

public class GunsmithCognitisModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GunsmithCognitisMod.MODID);
	public static final RegistryObject<Item> MUSKETBALL = REGISTRY.register("musketball", () -> new MusketballItem());
	public static final RegistryObject<Item> PAPER_CARTIDGE_SMALL_AMMO = REGISTRY.register("paper_cartidge_small_ammo", () -> new PaperCartidgeSmallAmmoItem());
	public static final RegistryObject<Item> PAPER_CARTIDGE_AMMO = REGISTRY.register("paper_cartidge_ammo", () -> new PaperCartidgeAmmoItem());
	public static final RegistryObject<Item> RAMROD = REGISTRY.register("ramrod", () -> new RamrodItem());
	public static final RegistryObject<Item> MATCHLOCKGUNKIT = REGISTRY.register("matchlockgunkit", () -> new MatchlockrepairItem());
	public static final RegistryObject<Item> WHEELLOCKGUNKIT = REGISTRY.register("wheellockgunkit", () -> new WheellockgunkitItem());
	public static final RegistryObject<Item> FLINTLOCKGUNKIT = REGISTRY.register("flintlockgunkit", () -> new FlintlockgunkitItem());
	public static final RegistryObject<Item> HANDGUNNE = REGISTRY.register("handgunne", () -> new HandgunneItem());
	public static final RegistryObject<Item> THREEEYEGUN = REGISTRY.register("threeeyegun", () -> new ThreeeyegunItem());
	public static final RegistryObject<Item> HAND_BOMB = REGISTRY.register("hand_bomb", () -> new HandBombItem());
	public static final RegistryObject<Item> MATCHLOCK_ARQUEBUS = REGISTRY.register("matchlock_arquebus", () -> new MatchlockArquebusItem());
	public static final RegistryObject<Item> MATCHLOCK_BLUNDERBUSS = REGISTRY.register("matchlock_blunderbuss", () -> new MatchlockBlunderbussItem());
	public static final RegistryObject<Item> TANEGASHIMA = REGISTRY.register("tanegashima", () -> new TanegashimaItem());
	public static final RegistryObject<Item> MATCHLOCK_SNAPHANCE_MUSKET = REGISTRY.register("matchlock_snaphance_musket", () -> new MatchlockSnaphanceMusketItem());
	public static final RegistryObject<Item> WHEELLOCK_PISTOL = REGISTRY.register("wheellock_pistol", () -> new WheellockPistolItem());
	public static final RegistryObject<Item> WHEELLOCK_MUSKET = REGISTRY.register("wheellock_musket", () -> new WheellockMusketItem());
	public static final RegistryObject<Item> FLINTLOCK_BLUEPRINT = REGISTRY.register("flintlock_blueprint", () -> new FlintlockBlueprintItem());
	public static final RegistryObject<Item> FLINTLOCKMUSKET = REGISTRY.register("flintlockmusket", () -> new FlintlockmusketItem());
	public static final RegistryObject<Item> FLINTLOCKMUSKETBAYONET = REGISTRY.register("flintlockmusketbayonet", () -> new FlintlockmusketbayonetItem());
	public static final RegistryObject<Item> FLINTLOCKMUSKETGOLD = REGISTRY.register("flintlockmusketgold", () -> new FlintlockmusketgoldItem());
	public static final RegistryObject<Item> FLINTLOCK_PISTOL = REGISTRY.register("flintlock_pistol", () -> new FlintlockPistolItem());
	public static final RegistryObject<Item> FLINTLOCK_PISTOL_GOLD = REGISTRY.register("flintlock_pistol_gold", () -> new FlintlockPistolGoldItem());
	public static final RegistryObject<Item> FLINTLOCK_DOUBLE_BARREL_MUSKET = REGISTRY.register("flintlock_double_barrel_musket", () -> new FlintlockDoubleBarrelMusketItem());
	public static final RegistryObject<Item> FLINTLOCK_PEPPERBOX = REGISTRY.register("flintlock_pepperbox", () -> new FlintlockPepperboxItem());
	public static final RegistryObject<Item> JEZAILMUSKET = REGISTRY.register("jezailmusket", () -> new JezailmusketItem());
	public static final RegistryObject<Item> MUSKET_BALL_PROJECTILE = REGISTRY.register("musket_ball_projectile", () -> new MusketBallProjectileItem());
}
