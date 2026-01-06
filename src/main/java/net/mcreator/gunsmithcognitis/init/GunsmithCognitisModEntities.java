
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

import net.mcreator.gunsmithcognitis.entity.WheellockPistolEntity;
import net.mcreator.gunsmithcognitis.entity.WheellockMusketEntity;
import net.mcreator.gunsmithcognitis.entity.ThreeeyegunEntity;
import net.mcreator.gunsmithcognitis.entity.TanegashimaEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockSnaphanceMusketEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockBlunderbussEntity;
import net.mcreator.gunsmithcognitis.entity.MatchlockArquebusEntity;
import net.mcreator.gunsmithcognitis.entity.JezailmusketEntity;
import net.mcreator.gunsmithcognitis.entity.HandgunneEntity;
import net.mcreator.gunsmithcognitis.entity.HandBombEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketgoldEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketbayonetEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockmusketEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPistolGoldEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPistolEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockPepperboxEntity;
import net.mcreator.gunsmithcognitis.entity.FlintlockDoubleBarrelMusketEntity;
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
	public static final RegistryObject<EntityType<MatchlockArquebusEntity>> MATCHLOCK_ARQUEBUS = register("projectile_matchlock_arquebus", EntityType.Builder.<MatchlockArquebusEntity>of(MatchlockArquebusEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockArquebusEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockBlunderbussEntity>> MATCHLOCK_BLUNDERBUSS = register("projectile_matchlock_blunderbuss", EntityType.Builder.<MatchlockBlunderbussEntity>of(MatchlockBlunderbussEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MatchlockBlunderbussEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TanegashimaEntity>> TANEGASHIMA = register("projectile_tanegashima",
			EntityType.Builder.<TanegashimaEntity>of(TanegashimaEntity::new, MobCategory.MISC).setCustomClientFactory(TanegashimaEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MatchlockSnaphanceMusketEntity>> MATCHLOCK_SNAPHANCE_MUSKET = register("projectile_matchlock_snaphance_musket",
			EntityType.Builder.<MatchlockSnaphanceMusketEntity>of(MatchlockSnaphanceMusketEntity::new, MobCategory.MISC).setCustomClientFactory(MatchlockSnaphanceMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockPistolEntity>> WHEELLOCK_PISTOL = register("projectile_wheellock_pistol", EntityType.Builder.<WheellockPistolEntity>of(WheellockPistolEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WheellockPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WheellockMusketEntity>> WHEELLOCK_MUSKET = register("projectile_wheellock_musket", EntityType.Builder.<WheellockMusketEntity>of(WheellockMusketEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WheellockMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketEntity>> FLINTLOCKMUSKET = register("projectile_flintlockmusket", EntityType.Builder.<FlintlockmusketEntity>of(FlintlockmusketEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockmusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketbayonetEntity>> FLINTLOCKMUSKETBAYONET = register("projectile_flintlockmusketbayonet",
			EntityType.Builder.<FlintlockmusketbayonetEntity>of(FlintlockmusketbayonetEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockmusketbayonetEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockmusketgoldEntity>> FLINTLOCKMUSKETGOLD = register("projectile_flintlockmusketgold", EntityType.Builder.<FlintlockmusketgoldEntity>of(FlintlockmusketgoldEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockmusketgoldEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPistolEntity>> FLINTLOCK_PISTOL = register("projectile_flintlock_pistol", EntityType.Builder.<FlintlockPistolEntity>of(FlintlockPistolEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPistolGoldEntity>> FLINTLOCK_PISTOL_GOLD = register("projectile_flintlock_pistol_gold", EntityType.Builder.<FlintlockPistolGoldEntity>of(FlintlockPistolGoldEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPistolGoldEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockDoubleBarrelMusketEntity>> FLINTLOCK_DOUBLE_BARREL_MUSKET = register("projectile_flintlock_double_barrel_musket",
			EntityType.Builder.<FlintlockDoubleBarrelMusketEntity>of(FlintlockDoubleBarrelMusketEntity::new, MobCategory.MISC).setCustomClientFactory(FlintlockDoubleBarrelMusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlintlockPepperboxEntity>> FLINTLOCK_PEPPERBOX = register("projectile_flintlock_pepperbox", EntityType.Builder.<FlintlockPepperboxEntity>of(FlintlockPepperboxEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlintlockPepperboxEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JezailmusketEntity>> JEZAILMUSKET = register("projectile_jezailmusket",
			EntityType.Builder.<JezailmusketEntity>of(JezailmusketEntity::new, MobCategory.MISC).setCustomClientFactory(JezailmusketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

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
