package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FlintlockHandMortarProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (immediatesourceentity.isInWater()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 0, 0, 0, 0.5);
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 2, Explosion.BlockInteraction.BREAK);
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
	}
}
