package net.philippelevis.hypixelskyblock.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class ResourceNodePlayerStartsToDestroyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState disguiseblock = Blocks.AIR.defaultBlockState();
		ItemStack disguiseitem = ItemStack.EMPTY;
		double fireHeight = 0;
		disguiseitem = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), 0));
		disguiseblock = (disguiseitem.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState());
		world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(disguiseblock));
		if (world instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (x + Mth.nextDouble(RandomSource.create(), 0, 0.4)), (y + Mth.nextDouble(RandomSource.create(), 0, 0.4)), (z + Mth.nextDouble(RandomSource.create(), 0, 0.4)), disguiseitem);
			entityToSpawn.setPickUpDelay(80);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
