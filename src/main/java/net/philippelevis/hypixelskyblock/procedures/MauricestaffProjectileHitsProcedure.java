package net.philippelevis.hypixelskyblock.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class MauricestaffProjectileHitsProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minecraft:player")))) {
			entity.hurt(DamageSource.GENERIC, 10);
		} else {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
