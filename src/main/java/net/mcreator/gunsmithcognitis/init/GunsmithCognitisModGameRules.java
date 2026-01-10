
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunsmithCognitisModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOGUNSJAM = GameRules.register("doGunsJam", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
