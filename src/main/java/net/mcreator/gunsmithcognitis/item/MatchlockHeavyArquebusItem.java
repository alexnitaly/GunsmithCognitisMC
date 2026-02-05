
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

import net.mcreator.gunsmithcognitis.procedures.MatchlockHeavyArquebusCanBeUsedProcedure;
import net.mcreator.gunsmithcognitis.procedures.MatchlockArquebusRangedItemUsedProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;
import net.mcreator.gunsmithcognitis.entity.MatchlockHeavyArquebusEntity;

import java.util.List;

public class MatchlockHeavyArquebusItem extends Item {
	public MatchlockHeavyArquebusItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_TAB).durability(96));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Matchlock Tier: Requires a string"));
		list.add(new TextComponent("gunpowder and heavy musket balls to load"));
		list.add(new TextComponent("requires flint n' steel to fire."));
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
			if (MatchlockHeavyArquebusCanBeUsedProcedure.execute(world, x, y, z, entity)) {
				MatchlockHeavyArquebusEntity entityarrow = MatchlockHeavyArquebusEntity.shoot(world, entity, world.getRandom(), 3.5f, 4, 1);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				MatchlockArquebusRangedItemUsedProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
