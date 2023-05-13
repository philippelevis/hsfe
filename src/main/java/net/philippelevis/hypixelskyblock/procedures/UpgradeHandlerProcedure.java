package net.philippelevis.hypixelskyblock.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

public class UpgradeHandlerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack upgrade1 = ItemStack.EMPTY;
		ItemStack upgrade2 = ItemStack.EMPTY;
		upgrade1 = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(17)).getItem() : ItemStack.EMPTY);
		upgrade2 = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(18)).getItem() : ItemStack.EMPTY);
	}
}
