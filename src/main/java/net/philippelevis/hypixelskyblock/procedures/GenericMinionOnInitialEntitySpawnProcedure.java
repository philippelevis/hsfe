package net.philippelevis.hypixelskyblock.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.core.BlockPos;

public class GenericMinionOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double iterator1 = 0;
		double iterator2 = 0;
		List<BlockPos> blocksToCheck = new ArrayList<>();
		iterator1 = -2;
		iterator2 = -2;
		while (iterator1 <= (-1) * iterator1) {
			while (iterator2 <= (-1) * iterator2) {
				blocksToCheck.add(new BlockPos(x+iterator1,y-1,z+iterator2));
				iterator2 = iterator2 + 1;
			}
			iterator1 = iterator1 + 1;
		}
		int curpos;
		int curpos2;
		for (curpos = 0; curpos < (int) (blocksToCheck.size()); curpos++) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component.literal(blocksToCheck.get(curpos).getX().toString()+blocksToCheck.get(curpos).getY().toString()+blocksToCheck.get(curpos).getZ().toString()), false);
			}
		}
	}
}
