
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.block.entity.ResourceNodeCropsBlockEntity;
import net.philippelevis.hypixelskyblock.block.entity.ResourceNodeBlockEntity;
import net.philippelevis.hypixelskyblock.block.entity.HsfeCraftingTableBlockEntity;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class HypixelSkyblockModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HypixelSkyblockMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> RESOURCE_NODE = register("resource_node", HypixelSkyblockModBlocks.RESOURCE_NODE, ResourceNodeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESOURCE_NODE_CROPS = register("resource_node_crops", HypixelSkyblockModBlocks.RESOURCE_NODE_CROPS, ResourceNodeCropsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HSFE_CRAFTING_TABLE = register("hsfe_crafting_table", HypixelSkyblockModBlocks.HSFE_CRAFTING_TABLE, HsfeCraftingTableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
