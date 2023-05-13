
package net.philippelevis.hypixelskyblock.item;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class AutoSmelterItem extends Item {
	public AutoSmelterItem() {
		super(new Item.Properties().tab(HypixelSkyblockModTabs.TAB_HYPIXEL).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}
}
