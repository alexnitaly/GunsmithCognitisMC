
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.entity.WheellockSportingRifleEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockPistolEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockMusketEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockKalthoffRepeaterEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockCarbineEntity;
import net.mcreator.gunsmithcognitis.entity.ThreeeyegunEntity;
import net.mcreator.gunsmithcognitis.entity.TanegashimaEntity;
import net.mcreator.gunsmithcognitis.entity.RockEntity;
import net.mcreator.gunsmithcognitis.entity.Pattern1851minierifleEntity;
import net.mcreator.gunsmithcognitis.entity.NockVolleyGunEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockWallGunEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockSnaphanceMusketEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockBlunderbussEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockAxePistolEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockArquebusEntity;
import net.mcreator.gunsmithcognitis.entity.LorenzPistolEntity;
import net.mcreator.gunsmithcognitis.entity.KentuckyPistolEntity;
import net.mcreator.gunsmithcognitis.entity.JezailmusketEntity;
import net.mcreator.gunsmithcognitis.entity.HandgunneEntity;
import net.mcreator.gunsmithcognitis.entity.HandBombEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketgoldEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketbayonetEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockRifledCarbineEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPistolGoldEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPistolEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPepperboxEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPepperboxCarbineEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockLorenzoniRepeaterEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockHeavyDragoonPistolEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockHandMortarEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockDoubleBarrelPistolEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockDoubleBarrelMusketEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockCollierRevolvingCarbineEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockCollierRevolverEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockAsumetteRifledWallGunEntity;
import net.mcreator.gunsmithcognitis.entity.FergusonRifleEntity;
import net.mcreator.gunsmithcognitis.entity.DynamitePackEntity;
import net.mcreator.gunsmithcognitis.entity.DynamiteEntity;
import net.mcreator.gunsmithcognitis.entity.DivineFiveThunderMachineEntity;
import net.mcreator.gunsmithcognitis.GunsmithCognitisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunsmithCognitisModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GunsmithCognitisMod.MODID);
	public static final RegistryObject<EntityType<HandgunneEntity>> HANDGUNNE = register("projectile_handgunne",
			EntityType.Builder.<HandgunneEntity>of(HandgunneEntity::new, MobCategory.MISC).setCustomClientFactory(HandgunneEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThreeeyegunEntity>> THREEEYEGUN = register("projectile_threeeyegun",
			EntityType.Builder.<ThreeeyegunEntity>of(ThreeeyegunEntity::new, MobCategory.MISC).setCustomClientFactory(ThreeeyegunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HandBombEntity>> HAND_BOMB = register("projectile_hand_bomb",
			EntityType.Builder.<HandBombEntity>of(HandBombEntity::new, MobCategory.MISC).setCustomClientFactory(HandBombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockBlunderbussEntity>> MATCHLOCK_BLUNDERBUSS = register("projectile_matchlock_blunderbuss", EntityType.Builder.<MatchlockBlunderbussEntity>of(MatchlockBlunderbussEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockBlunderbussEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockWallGunEntity>> MATCHLOCK_WALL_GUN = register("projectile_matchlock_wall_gun", EntityType.Builder.<MatchlockWallGunEntity>of(MatchlockWallGunEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockWallGunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockAxePistolEntity>> MATCHLOCK_AXE_PISTOL = register("projectile_matchlock_axe_pistol", EntityType.Builder.<MatchlockAxePistolEntity>of(MatchlockAxePistolEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockAxePistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TanegashimaEntity>> TANEGASHIMA = register("projectile_tanegashima",
			EntityType.Builder.<TanegashimaEntity>of(TanegashimaEntity::new, MobCategory.MISC).setCustomClientFactory(TanegashimaEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockSnaphanceMusketEntity>> MATCHLOCK_SNAPHANCE_MUSKET = register("projectile_matchlock_snaphance_musket",
			EntityType.Builder.<MatchlockSnaphanceMusketEntity>of(MatchlockSnaphanceMusketEntity::new, MobCategory.MISC).setCustomClientFactory(MatchlockSnaphanceMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockArquebusEntity>> MATCHLOCK_ARQUEBUS = register("projectile_matchlock_arquebus", EntityType.Builder.<MatchlockArquebusEntity>of(MatchlockArquebusEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockArquebusEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockPistolEntity>> WHEELLOCK_PISTOL = register("projectile_wheellock_pistol", EntityType.Builder.<WheellockPistolEntity>of(WheellockPistolEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WheellockPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockCarbineEntity>> WHEELLOCK_CARBINE = register("projectile_wheellock_carbine", EntityType.Builder.<WheellockCarbineEntity>of(WheellockCarbineEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WheellockCarbineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockMusketEntity>> WHEELLOCK_MUSKET = register("projectile_wheellock_musket", EntityType.Builder.<WheellockMusketEntity>of(WheellockMusketEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WheellockMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockSportingRifleEntity>> WHEELLOCK_SPORTING_RIFLE = register("projectile_wheellock_sporting_rifle",
			EntityType.Builder.<WheellockSportingRifleEntity>of(WheellockSportingRifleEntity::new, MobCategory.MISC).setCustomClientFactory(WheellockSportingRifleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockKalthoffRepeaterEntity>> WHEELLOCK_KALTHOFF_REPEATER = register("projectile_wheellock_kalthoff_repeater",
			EntityType.Builder.<WheellockKalthoffRepeaterEntity>of(WheellockKalthoffRepeaterEntity::new, MobCategory.MISC).setCustomClientFactory(WheellockKalthoffRepeaterEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPistolEntity>> FLINTLOCK_PISTOL = register("projectile_flintlock_pistol", EntityType.Builder.<FlintlockPistolEntity>of(FlintlockPistolEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPistolGoldEntity>> FLINTLOCK_PISTOL_GOLD = register("projectile_flintlock_pistol_gold", EntityType.Builder.<FlintlockPistolGoldEntity>of(FlintlockPistolGoldEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPistolGoldEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockHeavyDragoonPistolEntity>> FLINTLOCK_HEAVY_DRAGOON_PISTOL = register("projectile_flintlock_heavy_dragoon_pistol",
			EntityType.Builder.<FlintlockHeavyDragoonPistolEntity>of(FlintlockHeavyDragoonPistolEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockHeavyDragoonPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketEntity>> FLINTLOCKMUSKET = register("projectile_flintlockmusket", EntityType.Builder.<FlintlockmusketEntity>of(FlintlockmusketEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockmusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketbayonetEntity>> FLINTLOCKMUSKETBAYONET = register("projectile_flintlockmusketbayonet",
			EntityType.Builder.<FlintlockmusketbayonetEntity>of(FlintlockmusketbayonetEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockmusketbayonetEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketgoldEntity>> FLINTLOCKMUSKETGOLD = register("projectile_flintlockmusketgold", EntityType.Builder.<FlintlockmusketgoldEntity>of(FlintlockmusketgoldEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockmusketgoldEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DivineFiveThunderMachineEntity>> DIVINE_FIVE_THUNDER_MACHINE = register("projectile_divine_five_thunder_machine",
			EntityType.Builder.<DivineFiveThunderMachineEntity>of(DivineFiveThunderMachineEntity::new, MobCategory.MISC).setCustomClientFactory(DivineFiveThunderMachineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockHandMortarEntity>> FLINTLOCK_HAND_MORTAR = register("projectile_flintlock_hand_mortar", EntityType.Builder.<FlintlockHandMortarEntity>of(FlintlockHandMortarEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockHandMortarEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockDoubleBarrelPistolEntity>> FLINTLOCK_DOUBLE_BARREL_PISTOL = register("projectile_flintlock_double_barrel_pistol",
			EntityType.Builder.<FlintlockDoubleBarrelPistolEntity>of(FlintlockDoubleBarrelPistolEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockDoubleBarrelPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockDoubleBarrelMusketEntity>> FLINTLOCK_DOUBLE_BARREL_MUSKET = register("projectile_flintlock_double_barrel_musket",
			EntityType.Builder.<FlintlockDoubleBarrelMusketEntity>of(FlintlockDoubleBarrelMusketEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockDoubleBarrelMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NockVolleyGunEntity>> NOCK_VOLLEY_GUN = register("projectile_nock_volley_gun",
			EntityType.Builder.<NockVolleyGunEntity>of(NockVolleyGunEntity::new, MobCategory.MISC).setCustomClientFactory(NockVolleyGunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JezailmusketEntity>> JEZAILMUSKET = register("projectile_jezailmusket",
			EntityType.Builder.<JezailmusketEntity>of(JezailmusketEntity::new, MobCategory.MISC).setCustomClientFactory(JezailmusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockRifledCarbineEntity>> FLINTLOCK_RIFLED_CARBINE = register("projectile_flintlock_rifled_carbine",
			EntityType.Builder.<FlintlockRifledCarbineEntity>of(FlintlockRifledCarbineEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockRifledCarbineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockAsumetteRifledWallGunEntity>> FLINTLOCK_ASUMETTE_RIFLED_WALL_GUN = register("projectile_flintlock_asumette_rifled_wall_gun",
			EntityType.Builder.<FlintlockAsumetteRifledWallGunEntity>of(FlintlockAsumetteRifledWallGunEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockAsumetteRifledWallGunEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockLorenzoniRepeaterEntity>> FLINTLOCK_LORENZONI_REPEATER = register("projectile_flintlock_lorenzoni_repeater",
			EntityType.Builder.<FlintlockLorenzoniRepeaterEntity>of(FlintlockLorenzoniRepeaterEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockLorenzoniRepeaterEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FergusonRifleEntity>> FERGUSON_RIFLE = register("projectile_ferguson_rifle",
			EntityType.Builder.<FergusonRifleEntity>of(FergusonRifleEntity::new, MobCategory.MISC).setCustomClientFactory(FergusonRifleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPepperboxEntity>> FLINTLOCK_PEPPERBOX = register("projectile_flintlock_pepperbox", EntityType.Builder.<FlintlockPepperboxEntity>of(FlintlockPepperboxEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPepperboxEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPepperboxCarbineEntity>> FLINTLOCK_PEPPERBOX_CARBINE = register("projectile_flintlock_pepperbox_carbine",
			EntityType.Builder.<FlintlockPepperboxCarbineEntity>of(FlintlockPepperboxCarbineEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockPepperboxCarbineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockCollierRevolverEntity>> FLINTLOCK_COLLIER_REVOLVER = register("projectile_flintlock_collier_revolver",
			EntityType.Builder.<FlintlockCollierRevolverEntity>of(FlintlockCollierRevolverEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockCollierRevolverEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockCollierRevolvingCarbineEntity>> FLINTLOCK_COLLIER_REVOLVING_CARBINE = register("projectile_flintlock_collier_revolving_carbine",
			EntityType.Builder.<FlintlockCollierRevolvingCarbineEntity>of(FlintlockCollierRevolvingCarbineEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockCollierRevolvingCarbineEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RockEntity>> ROCK = register("projectile_rock",
			EntityType.Builder.<RockEntity>of(RockEntity::new, MobCategory.MISC).setCustomClientFactory(RockEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DynamiteEntity>> DYNAMITE = register("projectile_dynamite",
			EntityType.Builder.<DynamiteEntity>of(DynamiteEntity::new, MobCategory.MISC).setCustomClientFactory(DynamiteEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DynamitePackEntity>> DYNAMITE_PACK = register("projectile_dynamite_pack",
			EntityType.Builder.<DynamitePackEntity>of(DynamitePackEntity::new, MobCategory.MISC).setCustomClientFactory(DynamitePackEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Pattern1851minierifleEntity>> PATTERN_1851MINIERIFLE = register("projectile_pattern_1851minierifle",
			EntityType.Builder.<Pattern1851minierifleEntity>of(Pattern1851minierifleEntity::new, MobCategory.MISC).setCustomClientFactory(Pattern1851minierifleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LorenzPistolEntity>> LORENZ_PISTOL = register("projectile_lorenz_pistol",
			EntityType.Builder.<LorenzPistolEntity>of(LorenzPistolEntity::new, MobCategory.MISC).setCustomClientFactory(LorenzPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KentuckyPistolEntity>> KENTUCKY_PISTOL = register("projectile_kentucky_pistol",
			EntityType.Builder.<KentuckyPistolEntity>of(KentuckyPistolEntity::new, MobCategory.MISC).setCustomClientFactory(KentuckyPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
	}
}
