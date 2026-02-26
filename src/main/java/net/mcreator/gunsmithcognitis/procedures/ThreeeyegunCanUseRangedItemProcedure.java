package net.mcreator.gunsmithcognitis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModGameRules;

import java.util.Random;

public class ThreeeyegunCanUseRangedItemProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("IsFiring", (false));
		if (world.getLevelData().getGameRules().getBoolean(GunsmithCognitisModGameRules.DOGUNSJAM)) {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() > 24) {
				if (Math.random() < 0.3 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.THREEEYEGUN.get()
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.FLINT_AND_STEEL
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ammo") > 0) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("jammed", (true));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.NEUTRAL, 1, 2);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.NEUTRAL, 1, 2, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 2, 2);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 2, 2, false);
						}
					}
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(8, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GunsmithCognitisModItems.THREEEYEGUN.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.FLINT_AND_STEEL
				&& !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_snowy")))
				&& !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_wet")))
				&& !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_water")))
				&& !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_ocean")))
				&& !world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_jungle"))) && !entity.isInWaterRainOrBubble()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("IgnitionTimer") <= 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("gunpowder") >= 3
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ammo") > 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("ramrod loaded")
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("hasString")
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("cooldown") <= 0
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("jammed"))) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("IsFiring", (true));
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("IgnitionTimer", 42);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 2, false);
				}
			}
		} else if (world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_snowy")))
				|| world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_wet")))
				|| world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_water")))
				|| world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_ocean"))) || entity.isInWaterRainOrBubble()) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("IsFiring", (false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 1, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 1, 2, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		return false;
	}
}
