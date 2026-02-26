
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

import net.mcreator.gunsmithcognitis.procedures.WheellockPetronelItemSwungProcedure;
import net.mcreator.gunsmithcognitis.procedures.WheellockPetronelCanUseRangedProcedure;
import net.mcreator.gunsmithcognitis.procedures.WheellockMusketRangedItemUsedProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;
import net.mcreator.gunsmithcognitis.entity.WheellockPetronelEntity;

import java.util.List;

public class WheellockPetronelItem extends Item {
	public WheellockPetronelItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_WHEELLOCK_TAB).durability(89));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		WheellockPetronelItemSwungProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Wheellock tier: Wheel must be spun"));
		list.add(new TextComponent("then requires gunpowder and heavy musket ball to load."));
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
			if (WheellockPetronelCanUseRangedProcedure.execute(world, x, y, z, entity)) {
				WheellockPetronelEntity entityarrow = WheellockPetronelEntity.shoot(world, entity, world.getRandom(), 3f, 3, 1);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				WheellockMusketRangedItemUsedProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
