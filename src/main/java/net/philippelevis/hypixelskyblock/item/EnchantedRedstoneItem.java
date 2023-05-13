
package net.philippelevis.hypixelskyblock.item;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EnchantedRedstoneItem extends Item {
	public EnchantedRedstoneItem() {
		super(new Item.Properties().tab(HypixelSkyblockModTabs.TAB_HYPIXEL).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
