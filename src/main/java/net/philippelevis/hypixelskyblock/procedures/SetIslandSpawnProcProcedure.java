package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.network.HypixelSkyblockModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SetIslandSpawnProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_X = x;
		HypixelSkyblockModVariables.WorldVariables.get(world).syncData(world);
		HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Y = y;
		HypixelSkyblockModVariables.WorldVariables.get(world).syncData(world);
		HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Z = z;
		HypixelSkyblockModVariables.WorldVariables.get(world).syncData(world);
	}
}
