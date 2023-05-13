
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class HypixelSkyblockModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HypixelSkyblockMod.MODID);
	public static final RegistryObject<SimpleParticleType> LAZER = REGISTRY.register("lazer", () -> new SimpleParticleType(true));
}
