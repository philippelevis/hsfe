/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HypixelSkyblockModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, HypixelSkyblockMod.MODID);
	public static final RegistryObject<Attribute> RESISTANCE = ATTRIBUTES.register("resistance", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".resistance", 0, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> AUTOPICKUP = ATTRIBUTES.register("autopickup", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".autopickup", 0, 0, 1)).setSyncable(true));
	public static final RegistryObject<Attribute> ABSORPTION = ATTRIBUTES.register("absorption", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".absorption", 0, 0, 32767)).setSyncable(true));
	public static final RegistryObject<Attribute> STRENGTH = ATTRIBUTES.register("strength", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".strength", 0, 0, 32767)).setSyncable(true));
	public static final RegistryObject<Attribute> DEFENCE = ATTRIBUTES.register("defence", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".defence", 0, 0, 32767)).setSyncable(true));
	public static final RegistryObject<Attribute> BETTERHEALTH = ATTRIBUTES.register("betterhealth", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".betterhealth", 0, 0, 16777216)).setSyncable(true));
	public static final RegistryObject<Attribute> MANA = ATTRIBUTES.register("mana", () -> (new RangedAttribute("attribute." + HypixelSkyblockMod.MODID + ".mana", 0, 0, 32767)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.ZOMBIE, RESISTANCE.get());
		event.add(EntityType.PLAYER, AUTOPICKUP.get());
		event.add(EntityType.PLAYER, ABSORPTION.get());
		event.add(EntityType.PLAYER, ABSORPTION.get());
		event.add(EntityType.PLAYER, MANA.get());
		event.add(EntityType.PLAYER, MANA.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(MANA.get()).setBaseValue(oldP.getAttribute(MANA.get()).getBaseValue());
		}
	}
}
