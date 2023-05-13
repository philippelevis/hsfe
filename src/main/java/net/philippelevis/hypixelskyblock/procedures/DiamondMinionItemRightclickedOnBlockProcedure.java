package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModEntities;
import net.philippelevis.hypixelskyblock.entity.DiamondMinionEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class DiamondMinionItemRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		(itemstack).setCount(0);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new DiamondMinionEntity(HypixelSkyblockModEntities.DIAMOND_MINION.get(), _level);
			entityToSpawn.moveTo(x, y, z, 0, 0);
			entityToSpawn.setYBodyRot(0);
			entityToSpawn.setYHeadRot(0);
			entityToSpawn.setDeltaMovement(0, 0, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}
}
