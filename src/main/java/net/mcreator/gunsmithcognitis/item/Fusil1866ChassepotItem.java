
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.gunsmithcognitis.procedures.Fusil1866ChassepotItemUsedProcedure;
import net.mcreator.gunsmithcognitis.procedures.Fusil1866ChassepotCanUseRangedProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;
import net.mcreator.gunsmithcognitis.entity.Fusil1866ChassepotEntity;

import java.util.List;

public class Fusil1866ChassepotItem extends Item {
	public Fusil1866ChassepotItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_PERCUSSIONCAP_TAB).durability(855));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Breech Loading Rifle: Uses Paper Cartidge Rifle Ammo and Percussion Cap from Inventory."));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public void onUsingTick(ItemStack itemstack, LivingEntity entityLiving, int count) {
		Level world = entityLiving.level;
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (Fusil1866ChassepotCanUseRangedProcedure.execute(world, x, y, z, entity)) {
				Fusil1866ChassepotEntity entityarrow = Fusil1866ChassepotEntity.shoot(world, entity, world.getRandom(), 5.199999999999999f, 1.8, 0);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				Fusil1866ChassepotItemUsedProcedure.execute(world, x, y, z, entity, itemstack);
				entity.releaseUsingItem();
			}
		}
	}
}
