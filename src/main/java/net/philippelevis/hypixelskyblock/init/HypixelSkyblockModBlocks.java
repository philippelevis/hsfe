
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.block.SkyblockislandPortalBlock;
import net.philippelevis.hypixelskyblock.block.ResourceNodeCropsBlock;
import net.philippelevis.hypixelskyblock.block.ResourceNodeBlock;
import net.philippelevis.hypixelskyblock.block.HsfeCraftingTableBlock;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class HypixelSkyblockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HypixelSkyblockMod.MODID);
	public static final RegistryObject<Block> SKYBLOCKISLAND_PORTAL = REGISTRY.register("skyblockisland_portal", () -> new SkyblockislandPortalBlock());
	public static final RegistryObject<Block> RESOURCE_NODE = REGISTRY.register("resource_node", () -> new ResourceNodeBlock());
	public static final RegistryObject<Block> RESOURCE_NODE_CROPS = REGISTRY.register("resource_node_crops", () -> new ResourceNodeCropsBlock());
	public static final RegistryObject<Block> HSFE_CRAFTING_TABLE = REGISTRY.register("hsfe_crafting_table", () -> new HsfeCraftingTableBlock());
}
