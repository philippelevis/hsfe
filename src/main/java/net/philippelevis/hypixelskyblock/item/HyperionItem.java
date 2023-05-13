
package net.philippelevis.hypixelskyblock.item;

import net.philippelevis.hypixelskyblock.procedures.HyperionRightClickedInAirProcedure;
import net.philippelevis.hypixelskyblock.procedures.HyperionLivingEntityIsHitWithToolProcedure;
import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class HyperionItem extends SwordItem {
	public HyperionItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 0f;
			}

			public float getAttackDamageBonus() {
				return -2f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 4;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, 6f, new Item.Properties().tab(HypixelSkyblockModTabs.TAB_HYPIXEL).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		HyperionLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		HyperionRightClickedInAirProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}
