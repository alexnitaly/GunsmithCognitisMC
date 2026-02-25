package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;

public class ResearchTableTechDescriptionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("gui_tech_page") == 0) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock <= 0) {
				return "With this gunpowder, you start your journey.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 1) {
				return "From cannons on a stick to proper arquebuses.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 2) {
				return "Perfect the current musket design from crude to refined.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock >= 3) {
				return "You can craft everything related to Matchlocks!";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 1) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock <= 0) {
				return "Switch from a match to a Clockwork mechanism.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 1) {
				return "Make the barrels longer for infantry musket designs.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock == 2) {
				return "Improve the musket's barrel itself with rifling.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock >= 3) {
				return "You can craft everything related to Wheellocks!";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 2) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock <= 0) {
				return "The next step of firearm technology.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 1) {
				return "Start to experiment with multi-barrel system.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock == 2) {
				return "Perfect the Flintlock design and prototypes.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock >= 3) {
				return "You can craft everything related to Flintlocks!";
			}
		}
		if (entity.getPersistentData().getDouble("gui_tech_page") == 3) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap <= 0) {
				return "Step up from Gunpowder to Fulminate.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap == 1) {
				return "Prototyping new firing mechanisms.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap == 2) {
				return "Experimenting with the concept of a modern cartidge firearm.";
			} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap >= 3) {
				return "You can craft everything related to Percussion Caps!";
			}
		}
		return "NONE";
	}
}
