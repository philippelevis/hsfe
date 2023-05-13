
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class HypixelSkyblockModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HypixelSkyblockMod.MODID);
	public static final RegistryObject<SoundEvent> UK_BULLETSHOT = REGISTRY.register("uk_bulletshot", () -> new SoundEvent(new ResourceLocation("hypixel_skyblock", "uk_bulletshot")));
	public static final RegistryObject<SoundEvent> ULTRAKILL_LAZER = REGISTRY.register("ultrakill_lazer", () -> new SoundEvent(new ResourceLocation("hypixel_skyblock", "ultrakill_lazer")));
}
