package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;

public class ResearchTableUIThisGUIIsOpenedCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:matchlock_intermediate_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock < 2) {
			{
				double _setval = 2;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_matchlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:matchlock_mastery_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock < 3) {
			{
				double _setval = 3;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_matchlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:wheellock_entry_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock < 1) {
			{
				double _setval = 1;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_wheellock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:wheellock_intermediate_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock < 2) {
			{
				double _setval = 2;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_wheellock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:wheellock_mastery_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_wheellock < 3) {
			{
				double _setval = 3;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_wheellock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:flintlock_entry_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock < 1) {
			{
				double _setval = 1;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_flintlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:flintlock_intermediate_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock < 2) {
			{
				double _setval = 2;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_flintlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:flintlock_mastery_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_flintlock < 3) {
			{
				double _setval = 3;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_flintlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:percussion_entry_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap < 1) {
			{
				double _setval = 1;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_percussioncap = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:percussion_intermediate_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap < 2) {
			{
				double _setval = 2;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_percussioncap = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("gunsmith_cognitis:percussion_mastery_advancement"))).isDone()
				: false) && (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_percussioncap < 3) {
			{
				double _setval = 3;
				entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.progression_percussioncap = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
