package net.philippelevis.hypixelskyblock.procedures;

import net.minecraft.world.entity.Entity;

public class MauricestaffWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity((true));
	}
}
