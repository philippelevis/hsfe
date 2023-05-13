
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.enchantment.WithershieldEnchantment;
import net.philippelevis.hypixelskyblock.enchantment.ShadowwarpEnchantment;
import net.philippelevis.hypixelskyblock.enchantment.ImplosionEnchantment;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class HypixelSkyblockModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, HypixelSkyblockMod.MODID);
	public static final RegistryObject<Enchantment> SHADOWWARP = REGISTRY.register("shadowwarp", () -> new ShadowwarpEnchantment());
	public static final RegistryObject<Enchantment> IMPLOSION = REGISTRY.register("implosion", () -> new ImplosionEnchantment());
	public static final RegistryObject<Enchantment> WITHERSHIELD = REGISTRY.register("withershield", () -> new WithershieldEnchantment());
}
