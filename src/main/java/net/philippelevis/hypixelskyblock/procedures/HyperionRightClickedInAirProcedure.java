package net.philippelevis.hypixelskyblock.procedures;

import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModEnchantments;
import net.philippelevis.hypixelskyblock.init.HypixelSkyblockModAttributes;
import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class HyperionRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(HypixelSkyblockModEnchantments.SHADOWWARP.get(), itemstack) >= 1) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 0.5),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 0.5));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 0.5),
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 0.5),
							_ent.getYRot(), _ent.getXRot());
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(HypixelSkyblockModEnchantments.IMPLOSION.get(), itemstack) >= 1) {
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = (true);
				_player.onUpdateAbilities();
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 4, 4, 4, 1);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("hyperion").bypassArmor(), 5);
					entityiterator.invulnerableTime = 0;
				}
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = (false);
				_player.onUpdateAbilities();
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(HypixelSkyblockModEnchantments.WITHERSHIELD.get(), itemstack) >= 1) {
			((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getValue() + 1000));
			HypixelSkyblockMod.queueServerWork(200, () -> {
				((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get())
						.setBaseValue((((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.BETTERHEALTH.get()).getBaseValue() + ((LivingEntity) entity).getAttribute(HypixelSkyblockModAttributes.ABSORPTION.get()).getValue()));
			});
		}
		if (entity instanceof Player _player) {
			_player.getAbilities().invulnerable = (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false);
			_player.onUpdateAbilities();
		}
	}
}
