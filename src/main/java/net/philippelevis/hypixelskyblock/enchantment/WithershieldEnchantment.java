
package net.philippelevis.hypixelskyblock.enchantment;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class WithershieldEnchantment extends Enchantment {
	public WithershieldEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(HypixelSkyblockModItems.HYPERION.get()).contains(item);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
