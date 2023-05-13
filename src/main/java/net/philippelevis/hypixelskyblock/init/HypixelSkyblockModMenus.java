
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.world.inventory.ResourceNodeGUIMenu;
import net.philippelevis.hypixelskyblock.world.inventory.MinionGUIMenu;
import net.philippelevis.hypixelskyblock.world.inventory.CraftMenu;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class HypixelSkyblockModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HypixelSkyblockMod.MODID);
	public static final RegistryObject<MenuType<ResourceNodeGUIMenu>> RESOURCE_NODE_GUI = REGISTRY.register("resource_node_gui", () -> IForgeMenuType.create(ResourceNodeGUIMenu::new));
	public static final RegistryObject<MenuType<CraftMenu>> CRAFT = REGISTRY.register("craft", () -> IForgeMenuType.create(CraftMenu::new));
	public static final RegistryObject<MenuType<MinionGUIMenu>> MINION_GUI = REGISTRY.register("minion_gui", () -> IForgeMenuType.create(MinionGUIMenu::new));
}
