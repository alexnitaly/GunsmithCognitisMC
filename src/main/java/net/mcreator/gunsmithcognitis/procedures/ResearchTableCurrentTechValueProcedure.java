package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;

public class ResearchTableCurrentTechValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_moderncartidges > 0) {
			return "Current Tech: Modern Cartidges (" + (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_moderncartidges + ")";
		} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap > 0) {
			return "Current Tech: Percussion Cap (" + (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap + ")";
		} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock > 0) {
			return "Current Tech: Flintlock (" + (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock + ")";
		} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock > 0) {
			return "Current Tech: Wheellock (" + (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock + ")";
		} else if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock > 0) {
			return "Current Tech: Matchlock (" + (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock + ")";
		}
		return "Current Era: Pre-Gunpowder (Arrows/Melee)";
	}
}
