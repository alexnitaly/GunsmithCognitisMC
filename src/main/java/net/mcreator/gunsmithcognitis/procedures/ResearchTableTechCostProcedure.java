package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;

public class ResearchTableTechCostProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("gui_tech_page") == 0) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock <= 0) {
				return "3 Gunpowder, 4XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 1) {
				return "5 Gunpowder, Crude Barrel, 3 Copper, 6XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 2) {
				return "3 Matchlock Gunkits, 5 Iron, 1 Flint n' Steel, 9XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock >= 3) {
				return "None, Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 1) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock <= 0) {
				return "5 Iron, 1 Clock, 10XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 1) {
				return "6 Gunpowder, 5 Gold, 9 Redstone, 15XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 2) {
				return "5 Wheellock Gunkit, 1 Rifled Barrel, 3 Clocks, 25XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock >= 3) {
				return "None, Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 2) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock <= 0) {
				return "3 Matchlock & Wheellock Gunkit, 5 Iron, 1 Flint n' Steel, 25XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 1) {
				return "5 Barrels, 1 Rifled Barrel, 3 Flintlock Mechanisms, 25XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 2) {
				return "5 Flintlock Gunkits, 9 Gold and Iron Ingots, 40XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock >= 3) {
				return "None, Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 3) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap <= 0) {
				return "1 Flintlock Blueprint (2>), 12 Fulminate, 3 Gold, 32XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap == 1) {
				return "6 Percussion Mechanisms, 6 Rifled Barrels, 12 Caps, 48XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap == 2) {
				return "6 Percussion Gunkits, 32 Fulminate, 24 Iron, 64XP";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap >= 3) {
				return "None, Research Complete";
			}
		}
		return "NONE";
	}
}
