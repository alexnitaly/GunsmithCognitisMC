
package net.mcreator.gunsmithcognitis.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEntities;

import java.util.Random;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SpringfieldModel1861RifledMusketBayonetEntity extends AbstractArrow implements ItemSupplier {
	public SpringfieldModel1861RifledMusketBayonetEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(GunsmithCognitisModEntities.SPRINGFIELD_MODEL_1861_RIFLED_MUSKET_BAYONET.get(), world);
	}

	public SpringfieldModel1861RifledMusketBayonetEntity(EntityType<? extends SpringfieldModel1861RifledMusketBayonetEntity> type, Level world) {
		super(type, world);
	}

	public SpringfieldModel1861RifledMusketBayonetEntity(EntityType<? extends SpringfieldModel1861RifledMusketBayonetEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public SpringfieldModel1861RifledMusketBayonetEntity(EntityType<? extends SpringfieldModel1861RifledMusketBayonetEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(GunsmithCognitisModItems.MUSKET_BALL_PROJECTILE.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static SpringfieldModel1861RifledMusketBayonetEntity shoot(Level world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		SpringfieldModel1861RifledMusketBayonetEntity entityarrow = new SpringfieldModel1861RifledMusketBayonetEntity(GunsmithCognitisModEntities.SPRINGFIELD_MODEL_1861_RIFLED_MUSKET_BAYONET.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gunsmith_cognitis:musket_shot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static SpringfieldModel1861RifledMusketBayonetEntity shoot(LivingEntity entity, LivingEntity target) {
		SpringfieldModel1861RifledMusketBayonetEntity entityarrow = new SpringfieldModel1861RifledMusketBayonetEntity(GunsmithCognitisModEntities.SPRINGFIELD_MODEL_1861_RIFLED_MUSKET_BAYONET.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 5.5f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gunsmith_cognitis:musket_shot")), SoundSource.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
