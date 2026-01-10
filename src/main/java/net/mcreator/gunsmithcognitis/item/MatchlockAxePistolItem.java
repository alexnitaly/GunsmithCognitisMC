
package net.mcreator.gunsmithcognitis.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.gunsmithcognitis.procedures.MatchlockAxePistolRangedItemUsedProcedure;
import net.mcreator.gunsmithcognitis.procedures.MatchlockAxePistolCanUseRangedItemProcedure;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModTabs;
import net.mcreator.gunsmithcognitis.entity.MatchlockAxePistolEntity;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class MatchlockAxePistolItem extends Item {
	public MatchlockAxePistolItem() {
		super(new Item.Properties().tab(GunsmithCognitisModTabs.TAB_GUNSMITH_COGNITIS_TAB).durability(90));
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
	    if (!world.isClientSide && state.getDestroySpeed(world, pos) != 0.0F) {
	        itemstack.hurtAndBreak(1, entity, (ent) -> ent.broadcastBreakEvent(EquipmentSlot.MAINHAND));
	    }
	    if (entity instanceof Player _player) {
	        _player.getCooldowns().addCooldown(this, 40);
	    }
	    return true;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
	    if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
	        return 6.0f; // Iron Tier Speed
	    }
	    return 1.0f;
	}
	
	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
	    return state.is(BlockTags.MINEABLE_WITH_AXE);
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
		list.add(new TextComponent("two gunpowder and musket balls to load"));
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
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
	    if (slot == EquipmentSlot.MAINHAND) {
	        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	        builder.putAll(super.getDefaultAttributeModifiers(slot));
	        // Base attack speed is 4.0. -3.1 results in 0.9 (Iron Axe speed)
	        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3.1, AttributeModifier.Operation.ADDITION));
	        // Attack damage 6.0 (Iron Axe equivalent)
	        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 6.0, AttributeModifier.Operation.ADDITION));
	        return builder.build();
	    }
	    return super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (MatchlockAxePistolCanUseRangedItemProcedure.execute(world, x, y, z, entity)) {
				MatchlockAxePistolEntity entityarrow = MatchlockAxePistolEntity.shoot(world, entity, world.getRandom(), 2.5f, 2, 0);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				MatchlockAxePistolRangedItemUsedProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
