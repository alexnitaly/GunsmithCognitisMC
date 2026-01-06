
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.gunsmithcognitis.network.AmmoReloadMessage;
import net.mcreator.gunsmithcognitis.GunsmithCognitisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GunsmithCognitisModKeyMappings {
	public static final KeyMapping AMMO_RELOAD = new KeyMapping("key.gunsmith_cognitis.ammo_reload", GLFW.GLFW_KEY_R, "key.categories.gameplay");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(AMMO_RELOAD);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == AMMO_RELOAD.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						GunsmithCognitisMod.PACKET_HANDLER.sendToServer(new AmmoReloadMessage(0, 0));
						AmmoReloadMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
