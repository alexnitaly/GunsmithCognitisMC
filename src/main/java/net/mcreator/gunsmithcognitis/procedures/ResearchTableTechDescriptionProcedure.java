package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;

public class ResearchTableTechDescriptionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("gui_tech_page") == 0) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock <= 0) {
				return "Description here";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 1) {
				return "Matchlock - Intermediate Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 2) {
				return "Matchlock - Mastery Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock >= 3) {
				return "Matchlock - Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 1) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock <= 0) {
				return "Wheellock - Entry Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 1) {
				return "Wheellock - Intermediate Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 2) {
				return "Wheellock - Mastery Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock >= 3) {
				return "Wheellock - Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 2) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock <= 0) {
				return "Flintlock - Entry Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 1) {
				return "Flintlock - Intermediate Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 2) {
				return "Flintlock - Mastery Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock >= 3) {
				return "Flintlock - Research Complete";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 3) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock <= 0) {
				return "Percussion Cap - Entry Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 1) {
				return "Percussion Cap - Intermediate Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 2) {
				return "Percussion Cap - Mastery Level";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock >= 3) {
				return "Percussion Cap - Research Complete";
			}
		}
		return "NONE";
	}
}
