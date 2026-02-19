
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunsmithCognitisModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOGUNSJAM = GameRules.register("doGunsJam", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> SHOTGUNBACKBLAST = GameRules.register("shotgunBackBlast", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> SHOTGUNBACKBLASTMULTIPLIER = GameRules.register("shotgunBackBlastMultiplier", GameRules.Category.PLAYER, GameRules.IntegerValue.create(10));
	public static final GameRules.Key<GameRules.BooleanValue> CANPILLAGERSHAVEFIREARMS = GameRules.register("canPillagersHaveFirearms", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> CANSKELETONHAVEFIREARMS = GameRules.register("canSkeletonHaveFirearms", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
