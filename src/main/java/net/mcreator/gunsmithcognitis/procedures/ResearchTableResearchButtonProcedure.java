package net.mcreator.gunsmithcognitis.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsmithcognitis.network.GunsmithCognitisModVariables;
import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModItems;

import java.util.concurrent.atomic.AtomicReference;

public class ResearchTableResearchButtonProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double gunpowder = 0;
		if (entity.getPersistentData().getDouble("gui_tech_page") == 0) {
			if ((entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock == 0) {
				gunpowder = 0;
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (Items.GUNPOWDER == itemstackiterator.getItem()) {
							}
						}
					}
				}
				if (gunpowder >= 5 && (entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.GUNPOWDER);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 5, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-(5));
					{
						double _setval = (entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GunsmithCognitisModVariables.PlayerVariables())).progression_matchlock + 1;
						entity.getCapability(GunsmithCognitisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.progression_matchlock = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(GunsmithCognitisModItems.MATCHLOCK_BLUEPRINT.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(GunsmithCognitisModItems.MATCHLOCK_BLUEPRINT_INTERMEDIATE.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
