
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

import net.mcreator.gunsmithcognitis.procedures.DynamitePackWhileProjectileFlyingTickProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModEntities;

import java.util.Random;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class DynamitePackEntity extends AbstractArrow implements ItemSupplier {
	public DynamitePackEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(GunsmithCognitisModEntities.DYNAMITE_PACK.get(), world);
	}

	public DynamitePackEntity(EntityType<? extends DynamitePackEntity> type, Level world) {
		super(type, world);
	}

	public DynamitePackEntity(EntityType<? extends DynamitePackEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public DynamitePackEntity(EntityType<? extends DynamitePackEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(GunsmithCognitisModItems.DYNAMITE_PACK.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(GunsmithCognitisModItems.DYNAMITE_PACK.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		DynamitePackWhileProjectileFlyingTickProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		this.inGround = false; 
	}

	public static DynamitePackEntity shoot(Level world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		DynamitePackEntity entityarrow = new DynamitePackEntity(GunsmithCognitisModEntities.DYNAMITE_PACK.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static DynamitePackEntity shoot(LivingEntity entity, LivingEntity target) {
		DynamitePackEntity entityarrow = new DynamitePackEntity(GunsmithCognitisModEntities.DYNAMITE_PACK.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.7f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(true);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}

	@Override
	public void onHitBlock(net.minecraft.world.phys.BlockHitResult blockHitResult) {
	    net.minecraft.core.Direction face = blockHitResult.getDirection();
	    net.minecraft.world.phys.Vec3 motion = this.getDeltaMovement();
	    
	    double bounceFactor = 0.125D; 
	    
	    double motX = motion.x;
	    double motY = motion.y;
	    double motZ = motion.z;
	    
	    if (face.getAxis() == net.minecraft.core.Direction.Axis.X) {
	        motX = -motX * bounceFactor;
	    } else if (face.getAxis() == net.minecraft.core.Direction.Axis.Y) {
	        motY = -motY * bounceFactor;
	        motX *= 0.6D;
	        motZ *= 0.6D;
	    } else if (face.getAxis() == net.minecraft.core.Direction.Axis.Z) {
	        motZ = -motZ * bounceFactor;
	    }
	    
	    if (Math.abs(motY) < 0.05D) {
	        motY = 0.0D;
	    } else {
	        this.playSound(net.minecraft.sounds.SoundEvents.STONE_HIT, 0.5F, 1.2F);
	    }
	    
	    this.setDeltaMovement(motX, motY, motZ);
	}
		
	@Override
	public void onHitEntity(net.minecraft.world.phys.EntityHitResult entityHitResult) {
	    
	    net.minecraft.world.phys.Vec3 motion = this.getDeltaMovement();
	    this.setDeltaMovement(motion.x * -0.3D, motion.y * -0.3D, motion.z * -0.3D);
	    
	    this.playSound(net.minecraft.sounds.SoundEvents.STONE_HIT, 1.0F, 1.2F);
	}
}
