package net.philippelevis.hypixelskyblock.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class HyperionLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(Component.literal("Display name"));
		entity.getPersistentData().putString("id", "minecraft:creeper");
	}
}
