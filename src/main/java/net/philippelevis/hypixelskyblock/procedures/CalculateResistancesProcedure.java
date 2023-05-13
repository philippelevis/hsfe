package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.network.HypixelSkyblockModVariables;
import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CalculateResistancesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		double damage = 0;
		LivingHurtEvent event2 = (LivingHurtEvent) event;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.RESISTANCE.get()) != null) {
			damage = amount - (amount / 100) * ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.RESISTANCE.get()).getValue();
			event2.setAmount((float) damage);
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()) != null) {
			if (((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getBaseValue() >= amount) {
				((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getValue() - amount));
				event2.setAmount((float) 0);
			} else {
				damage = amount - ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getValue();
				((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).setBaseValue(0);
				event2.setAmount((float) damage);
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get()) != null) {
			if (((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get()).getBaseValue() >= amount) {
				((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get()).setBaseValue((((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getValue() - amount));
				event2.setAmount((float) 0);
			} else {
				event2.setAmount((float) 0);
				((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get())
						.setBaseValue(((entity.getCapability(HypixelSkyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HypixelSkyblockModVariables.PlayerVariables())).health_max));
				{
					Entity _ent = entity;
					_ent.teleportTo(HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_X, HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Y,
							HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_X, HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Y,
								HypixelSkyblockModVariables.WorldVariables.get(world).islandSpawn_default_Z, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
