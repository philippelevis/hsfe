
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.client.renderer.MauricestaffRenderer;
import net.philippelevis.hypixelskyblock.client.renderer.MauriceRenderer;
import net.philippelevis.hypixelskyblock.client.renderer.MauriceLazerStaffRenderer;
import net.philippelevis.hypixelskyblock.client.renderer.GenericMinionRenderer;
import net.philippelevis.hypixelskyblock.client.renderer.DiamondMinionRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HypixelSkyblockModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(HypixelSkyblockModEntities.MAURICE.get(), MauriceRenderer::new);
		event.registerEntityRenderer(HypixelSkyblockModEntities.MAURICESTAFF.get(), MauricestaffRenderer::new);
		event.registerEntityRenderer(HypixelSkyblockModEntities.MAURICE_LAZER_STAFF.get(), MauriceLazerStaffRenderer::new);
		event.registerEntityRenderer(HypixelSkyblockModEntities.GENERIC_MINION.get(), GenericMinionRenderer::new);
		event.registerEntityRenderer(HypixelSkyblockModEntities.DIAMOND_MINION.get(), DiamondMinionRenderer::new);
	}
}
