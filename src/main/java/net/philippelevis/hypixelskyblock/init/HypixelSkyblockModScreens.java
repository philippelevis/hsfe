
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.client.gui.ResourceNodeGUIScreen;
import net.philippelevis.hypixelskyblock.client.gui.MinionGUIScreen;
import net.philippelevis.hypixelskyblock.client.gui.CraftScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HypixelSkyblockModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(HypixelSkyblockModMenus.RESOURCE_NODE_GUI.get(), ResourceNodeGUIScreen::new);
			MenuScreens.register(HypixelSkyblockModMenus.CRAFT.get(), CraftScreen::new);
			MenuScreens.register(HypixelSkyblockModMenus.MINION_GUI.get(), MinionGUIScreen::new);
		});
	}
}
