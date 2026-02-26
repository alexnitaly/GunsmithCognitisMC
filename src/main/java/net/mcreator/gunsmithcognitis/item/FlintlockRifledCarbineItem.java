
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

import net.mcreator.gunsmithcognitis.procedures.MusketRangedItemUsedProcedure;
import net.mcreator.gunsmithcognitis.procedures.FlintlockRifledCarbineCanUseRangedItemProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;
import net.mcreator.gunsmithcognitis.entity.FlintlockRifledCarbineEntity;

import java.util.List;

public class FlintlockRifledCarbineItem extends Item {
	public FlintlockRifledCarbineItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_FLINTLOCK_TAB).durability(196));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Flintlock tier: Requires gunpowder and musket ball OR a paper cartidge to load."));
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
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (FlintlockRifledCarbineCanUseRangedItemProcedure.execute(world, x, y, z, entity)) {
				FlintlockRifledCarbineEntity entityarrow = FlintlockRifledCarbineEntity.shoot(world, entity, world.getRandom(), 4f, 2, 0);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				MusketRangedItemUsedProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
