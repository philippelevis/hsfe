package net.philippelevis.hypixelskyblock.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.ArrayList;

public class GenericMinionOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double iterator1 = 0;
		double iterator2 = 0;
		List<Object> blocksToCheck = new ArrayList<>();
		List<Object> coords = new ArrayList<>();
		iterator1 = -2;
		iterator2 = -2;
		while (iterator1 <= (-1) * iterator1) {
			while (iterator2 <= (-1) * iterator2) {
				coords.add(x);
				coords.add(y);
				coords.add(z);
				blocksToCheck.add(coords);
				iterator2 = iterator2 + 1;
			}
			iterator1 = iterator1 + 1;
		}
		int curpos;
		for (curpos = 0; curpos < (int) (blocksToCheck.size()); curpos++) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component.literal(("test" + /*@ALVIterator*/curpos)), false);
			}
		}
	}
}
