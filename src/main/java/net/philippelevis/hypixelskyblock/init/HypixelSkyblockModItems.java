
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.item.SkyblockislandItem;
import net.philippelevis.hypixelskyblock.item.MauricestaffItem;
import net.philippelevis.hypixelskyblock.item.MauriceLazerStaffItem;
import net.philippelevis.hypixelskyblock.item.HyperionarmorArmorItem;
import net.philippelevis.hypixelskyblock.item.HyperionItem;
import net.philippelevis.hypixelskyblock.item.EnchantedRedstoneItem;
import net.philippelevis.hypixelskyblock.item.EnchantedDiamondItem;
import net.philippelevis.hypixelskyblock.item.DiamondMinionItemItem;
import net.philippelevis.hypixelskyblock.item.AutoSmelterItem;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class HypixelSkyblockModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HypixelSkyblockMod.MODID);
	public static final RegistryObject<Item> HYPERION = REGISTRY.register("hyperion", () -> new HyperionItem());
	public static final RegistryObject<Item> SKYBLOCKISLAND = REGISTRY.register("skyblockisland", () -> new SkyblockislandItem());
	public static final RegistryObject<Item> NECRON_ARMOR_CHESTPLATE = REGISTRY.register("necron_armor_chestplate", () -> new HyperionarmorArmorItem.Chestplate());
	public static final RegistryObject<Item> NECRON_ARMOR_LEGGINGS = REGISTRY.register("necron_armor_leggings", () -> new HyperionarmorArmorItem.Leggings());
	public static final RegistryObject<Item> NECRON_ARMOR_BOOTS = REGISTRY.register("necron_armor_boots", () -> new HyperionarmorArmorItem.Boots());
	public static final RegistryObject<Item> ENCHANTED_REDSTONE = REGISTRY.register("enchanted_redstone", () -> new EnchantedRedstoneItem());
	public static final RegistryObject<Item> MAURICE_SPAWN_EGG = REGISTRY.register("maurice_spawn_egg", () -> new ForgeSpawnEggItem(HypixelSkyblockModEntities.MAURICE, -1, -1, new Item.Properties().tab(HypixelSkyblockModTabs.TAB_HYPIXEL)));
	public static final RegistryObject<Item> MAURICESTAFF = REGISTRY.register("mauricestaff", () -> new MauricestaffItem());
	public static final RegistryObject<Item> RESOURCE_NODE = block(HypixelSkyblockModBlocks.RESOURCE_NODE, HypixelSkyblockModTabs.TAB_HYPIXEL);
	public static final RegistryObject<Item> RESOURCE_NODE_CROPS = block(HypixelSkyblockModBlocks.RESOURCE_NODE_CROPS, HypixelSkyblockModTabs.TAB_HYPIXEL);
	public static final RegistryObject<Item> MAURICE_LAZER_STAFF = REGISTRY.register("maurice_lazer_staff", () -> new MauriceLazerStaffItem());
	public static final RegistryObject<Item> HSFE_CRAFTING_TABLE = block(HypixelSkyblockModBlocks.HSFE_CRAFTING_TABLE, HypixelSkyblockModTabs.TAB_HYPIXEL);
	public static final RegistryObject<Item> GENERIC_MINION_SPAWN_EGG = REGISTRY.register("generic_minion_spawn_egg",
			() -> new ForgeSpawnEggItem(HypixelSkyblockModEntities.GENERIC_MINION, -16764109, -16764109, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> AUTO_SMELTER = REGISTRY.register("auto_smelter", () -> new AutoSmelterItem());
	public static final RegistryObject<Item> DIAMOND_MINION_ITEM = REGISTRY.register("diamond_minion_item", () -> new DiamondMinionItemItem());
	public static final RegistryObject<Item> ENCHANTED_DIAMOND = REGISTRY.register("enchanted_diamond", () -> new EnchantedDiamondItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
