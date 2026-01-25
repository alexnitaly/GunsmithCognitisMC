package net.mcreator.gunsmithcognitis.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Random;

public class BrowningHarmonicaRifleRangedItemUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemstack) != 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, (y + 1.5), z, 28, 0, 0, 0, 0.015);
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			itemstack.getOrCreateTag().putBoolean("cocked", (false));
			itemstack.getOrCreateTag().putBoolean("cooldown", (true));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					itemstack.getOrCreateTag().putBoolean("cooldown", (true));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 30);
		} else {
			if (!(itemstack.getOrCreateTag().getDouble("ammo") < 1)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 1.5), z, 18, 0, 0, 0, 0.0025);
				itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
				itemstack.getOrCreateTag().putDouble("gunpowder", (itemstack.getOrCreateTag().getDouble("gunpowder") - 1));
				itemstack.getOrCreateTag().putBoolean("percussion cap", (false));
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						itemstack.getOrCreateTag().putBoolean("cooldown", (false));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 15);
				if (itemstack.getOrCreateTag().getDouble("ammo") == 0) {
					itemstack.getOrCreateTag().putDouble("gunpowder", 0);
				}
			}
		}
	}
}
