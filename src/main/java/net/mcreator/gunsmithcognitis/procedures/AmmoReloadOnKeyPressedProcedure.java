package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

public class AmmoReloadOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_ARQUEBUS.get()) {
			MatchlockArquebusReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_HEAVY_ARQUEBUS.get()) {
			MatchlockHeavyArquebusReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.LANDSKNECHT_HARKEBUS.get()) {
			LandsknechtHarkebusReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.TANEGASHIMA.get()) {
			TanegashimaReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_WALL_GUN.get()) {
			MatchlockWallGunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_PISTOL.get()) {
			MatchlockPistolReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_AXE_PISTOL.get()) {
			MatchlockAxePistolReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_SNAPHANCE_MUSKET.get()) {
			MatchlockSnaphanceMusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MATCHLOCK_BLUNDERBUSS.get()) {
			BlunderbussReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.HANDCANNON.get()) {
			HandcannonReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.HANDGUNNE.get()) {
			HandgunneReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.THREEEYEGUN.get()) {
			ThreeEyeGunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.DIVINE_FIVE_THUNDER_MACHINE.get()) {
			DivineFiveThunderMachineReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get()) {
			WheellockPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_PISTOL.get()) {
			WheellockPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_PETRONEL.get()) {
			WheellockPetronelReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_CARBINE.get()) {
			WheellockCarbineReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_MUSKET.get()) {
			WheellockMusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_SPORTING_RIFLE.get()) {
			WheellockSportingRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.WHEELLOCK_KALTHOFF_REPEATER.get()) {
			WheellockKalthoffRepeaterReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKETBAYONET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCKMUSKETGOLD.get()) {
			FlintlockMusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_RIFLED_CARBINE.get()) {
			FlintlockRifledCarbineReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.MIQUOLET_MUSKET.get()) {
			FlintlockMusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_BLUNDERBUSS.get()) {
			FlintlockBlunderbussReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FERGUSON_RIFLE.get()) {
			FergusonRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_ASUMETTE_RIFLED_WALL_GUN.get()) {
			FlintlockAsumetteReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.JEZAILMUSKET.get()) {
			JezailmusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HAND_MORTAR.get()) {
			FlintlockHandMortarReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get()) {
			FlintlockPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PISTOL_GOLD.get()) {
			FlintlockPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get()) {
			FlintlockHeavyDragoonPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_HEAVY_DRAGOON_PISTOL.get()) {
			FlintlockHeavyDragoonPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_MUSKET.get()) {
			FlintlockDoubleBarrelMusketReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get()) {
			FlintlockDoubleBarrelPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_DOUBLE_BARREL_PISTOL.get()) {
			FlintlockDoubleBarrelPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get()) {
			FlintlockLorenzoniRepeaterReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_LORENZONI_REPEATER.get()) {
			FlintlockLorenzoniRepeaterOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get()) {
			FlintlockPepperboxReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX.get()) {
			FlintlockPepperboxOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_PEPPERBOX_CARBINE.get()) {
			FlintlockPepperboxCarbineReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.NOCK_VOLLEY_GUN.get()) {
			NockVolleyGunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get()) {
			FlintlockCollierRevolverReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVER.get()) {
			FlintlockCollierRevolverOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FLINTLOCK_COLLIER_REVOLVING_CARBINE.get()) {
			FlintlockCollierRevolvingCarbineReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.PATTERN_1851MINIERIFLE.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.PATTERN_1851_MINIE_RIFLE_BAYONET.get()) {
			Pattern1851MinieRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.ENFIELD_1853_MUSKET_RIFLE.get()) {
			Enfield1853MusketRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.LORENZ_PISTOL.get()) {
			LorenzPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.LORENZ_PISTOL.get()) {
			LorenzPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.KENTUCKY_PISTOL.get()) {
			KentuckyPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.KENTUCKY_PISTOL.get()) {
			KentuckyPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.BROWNING_HARMONICA_CLIP.get()) {
			BrowningHarmonicaClipReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.BROWNING_HARMONICA_RIFLE.get()) {
			BrowningHarmonicaRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.DREYSE_NEEDLE_GUN.get()) {
			DreyseNeedleGunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FUSIL_1866_CHASSEPOT.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FUSIL_1866_CHASSEPOT_BAYONET.get()) {
			Fusil1866ChassepotReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.DOUBLE_BARREL_SHOTGUN.get()) {
			DoubleBarrelShotgunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_OFF_DOUBLE_BARREL_SHOTGUN.get()) {
			SawnOffDoubleShotgunReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_OFF_DOUBLE_BARREL_SHOTGUN.get()) {
			SawnOffDoubleShotgunOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_DRAGOON_1848.get()) {
			ColtDragoon1848ReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_DRAGOON_1848.get()) {
			ColtDragoon1848OffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_WALKER_1847.get()) {
			ColtWalker1847ReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_REVOLVING_RIFLE_1855.get()) {
			ColtRevolvingRifle1855ReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_REVOLVING_SHOTGUN_1855.get()) {
			ColtRevolvingShotgunReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_OFF_COLT_REVOLVER_1855.get()) {
			SawnColtRevolver1855ReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_OFF_COLT_REVOLVER_1855.get()) {
			SawnColtRevolver1855OffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_COLT_REVOLVING_SHOTGUN_1855.get()) {
			SawnColtRevolvingShotgun1855ReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SAWN_COLT_REVOLVING_SHOTGUN_1855.get()) {
			SawnColtRevolvingShotgun1855OffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_ARMY_1860.get()) {
			ColtArmy1860ReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.COLT_ARMY_1860.get()) {
			ColtArmy1860OffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.ADAMS_1856_REVOLVER.get()) {
			Adams1856RevolverReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.ADAMS_1856_REVOLVER.get()) {
			Adams1856RevolverOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.JOSEPH_EGG_PISTOL.get()) {
			JosephEggPistolReloadProcedure.execute(entity);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.JOSEPH_EGG_PISTOL.get()) {
			JosephEggPistolOffhandReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SPRINGFIELD_MODEL_1861_RIFLED_MUSKET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.SPRINGFIELD_MODEL_1861_RIFLED_MUSKET_BAYONET.get()) {
			SpringfieldModel1861ReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FUSIL_1866_CHASSEPOT.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.FUSIL_1866_CHASSEPOT_BAYONET.get()) {
			Fusil1866ChassepotReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.BIG_GAME_4_BORE_PERCUSSION_RIFLE.get()) {
			BigGame4BorePercussionRifleReloadProcedure.execute(entity);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.PORTER_TURRET_RIFLE.get()) {
			PorterTurretRifleReloadProcedure.execute(entity);
		}
	}
}
