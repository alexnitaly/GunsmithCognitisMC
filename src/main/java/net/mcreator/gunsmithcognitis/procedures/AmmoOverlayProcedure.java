package net.mcreator.gunsmithcognitis.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AmmoOverlayProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get()) {
			MatchlockammooverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.TANEGASHIMA.get()) {
			TanegashimaAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get()) {
			MatchlockAxePistolOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get()) {
			MatchlockSnaphanceMusketAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get()) {
			BlunderbussammooverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.HANDGUNNE.get()) {
			HandgunneammooverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.THREEEYEGUN.get()) {
			ThreeEyeGunAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.DIVINE_FIVE_THUNDER_MACHINE.get()) {
			DivineFiveThunderMachineOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_WALL_GUN.get()) {
			MatchlockWallGunOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get()) {
			WheellockPistolAmmoOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_MUSKET.get()) {
			WheellockmusketammooverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_SPORTING_RIFLE.get()) {
			WheellockSportingRifleOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_CARBINE.get()) {
			WheellockCarbineOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_KALTHOFF_REPEATER.get()) {
			WheellockKalthoffRepeaterOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get()) {
			FlintlockmusketammooverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_RIFLED_CARBINE.get()) {
			FlintlockRifledCarbineOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FERGUSON_RIFLE.get()) {
			FergusonRifleOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HAND_MORTAR.get()) {
			FlintlockHandMortarOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get()) {
			FlintlockPistolAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get()) {
			FlintlockHeavyDragoonPistolOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get()) {
			FlintlockDoubleBarrelMusketAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get()) {
			FlintlockDoubleBarrelPistolOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get()) {
			FlintlockLorenzoniRepeaterOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get()) {
			FlintlockCollierRevolverOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVING_CARBINE.get()) {
			FlintlockCollierRevolvingCarbineOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_ASUMETTE_RIFLED_WALL_GUN.get()) {
			FlintlockAsumetteOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get()) {
			FlintlockPepperboxAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX_CARBINE.get()) {
			FlintlockPepperboxCarbineOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.JEZAILMUSKET.get()) {
			JezailMusketAmmoOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.NOCK_VOLLEY_GUN.get()) {
			NockVolleyGunOverlayProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.PATTERN_1851MINIERIFLE.get()) {
			Pattern1851MinieRifleOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.LORENZ_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.LORENZ_PISTOL.get()) {
			LorenzPistolOverlayProcedure.execute(world, entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.KENTUCKY_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.KENTUCKY_PISTOL.get()) {
			KentuckyPistolOverlayProcedure.execute(world, entity);
		}
	}
}
