
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class HypixelSkyblockModTabs {
	public static CreativeModeTab TAB_HYPIXEL;

	public static void load() {
		TAB_HYPIXEL = new CreativeModeTab("tabhypixel") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HypixelSkyblockModItems.HYPERION.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
