package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.network.HypixelSkyblockModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class SkyblockislandPlayerEntersDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(0, ((entity.getCapability(HypixelSkyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HypixelSkyblockModVariables.PlayerVariables())).Player_islandSpawn_Y),
					((entity.getCapability(HypixelSkyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HypixelSkyblockModVariables.PlayerVariables())).Player_islandSpawn_Z));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(0, ((entity.getCapability(HypixelSkyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HypixelSkyblockModVariables.PlayerVariables())).Player_islandSpawn_Y),
						((entity.getCapability(HypixelSkyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HypixelSkyblockModVariables.PlayerVariables())).Player_islandSpawn_Z), _ent.getYRot(), _ent.getXRot());
		}
	}
}
