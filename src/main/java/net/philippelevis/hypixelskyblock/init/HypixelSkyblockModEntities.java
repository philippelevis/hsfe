
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.philippelevis.hypixelskyblock.init;

import net.philippelevis.hypixelskyblock.entity.MauricestaffEntity;
import net.philippelevis.hypixelskyblock.entity.MauriceLazerStaffEntity;
import net.philippelevis.hypixelskyblock.entity.MauriceEntity;
import net.philippelevis.hypixelskyblock.entity.GenericMinionEntity;
import net.philippelevis.hypixelskyblock.entity.DiamondMinionEntity;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HypixelSkyblockModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HypixelSkyblockMod.MODID);
	public static final RegistryObject<EntityType<MauriceEntity>> MAURICE = register("maurice",
			EntityType.Builder.<MauriceEntity>of(MauriceEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MauriceEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<MauricestaffEntity>> MAURICESTAFF = register("projectile_mauricestaff",
			EntityType.Builder.<MauricestaffEntity>of(MauricestaffEntity::new, MobCategory.MISC).setCustomClientFactory(MauricestaffEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MauriceLazerStaffEntity>> MAURICE_LAZER_STAFF = register("projectile_maurice_lazer_staff", EntityType.Builder.<MauriceLazerStaffEntity>of(MauriceLazerStaffEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MauriceLazerStaffEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GenericMinionEntity>> GENERIC_MINION = register("generic_minion", EntityType.Builder.<GenericMinionEntity>of(GenericMinionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(GenericMinionEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DiamondMinionEntity>> DIAMOND_MINION = register("diamond_minion", EntityType.Builder.<DiamondMinionEntity>of(DiamondMinionEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DiamondMinionEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MauriceEntity.init();
			GenericMinionEntity.init();
			DiamondMinionEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MAURICE.get(), MauriceEntity.createAttributes().build());
		event.put(GENERIC_MINION.get(), GenericMinionEntity.createAttributes().build());
		event.put(DIAMOND_MINION.get(), DiamondMinionEntity.createAttributes().build());
	}
}
