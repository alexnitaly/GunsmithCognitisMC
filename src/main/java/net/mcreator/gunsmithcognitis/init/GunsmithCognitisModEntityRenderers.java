
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsmithcognitis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GunsmithCognitisModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GunsmithCognitisModEntities.HANDGUNNE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.THREEEYEGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.HAND_BOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.MATCHLOCK_ARQUEBUS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.MATCHLOCK_BLUNDERBUSS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.TANEGASHIMA.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.MATCHLOCK_SNAPHANCE_MUSKET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.WHEELLOCK_PISTOL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.WHEELLOCK_MUSKET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCKMUSKET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCKMUSKETBAYONET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCKMUSKETGOLD.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCK_PISTOL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCK_PISTOL_GOLD.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCK_DOUBLE_BARREL_MUSKET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.FLINTLOCK_PEPPERBOX.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsmithCognitisModEntities.JEZAILMUSKET.get(), ThrownItemRenderer::new);
	}
}
