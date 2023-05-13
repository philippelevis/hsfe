package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class MauriceLazerStaffWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (HypixelSkyblockModParticleTypes.LAZER.get()), x, y, z, 1, 0, 0, 0, 0);
	}
}
