package net.philippelevis.hypixelskyblock.network;

import net.philippelevis.hypixelskyblock.HypixelSkyblockMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HypixelSkyblockModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		HypixelSkyblockMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		HypixelSkyblockMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.mana_max = original.mana_max;
			clone.Player_islandSpawn_X = original.Player_islandSpawn_X;
			clone.Player_islandSpawn_Y = original.Player_islandSpawn_Y;
			clone.Player_islandSpawn_Z = original.Player_islandSpawn_Z;
			clone.health_max = original.health_max;
			clone.overheal = original.overheal;
			clone.skill_farming_lvl = original.skill_farming_lvl;
			clone.skill_combat_lvl = original.skill_combat_lvl;
			clone.skill_foraging_lvl = original.skill_foraging_lvl;
			clone.skill_fishing_lvl = original.skill_fishing_lvl;
			clone.skill_enchant_lvl = original.skill_enchant_lvl;
			clone.skill_alchemy_lvl = original.skill_alchemy_lvl;
			clone.skill_taming_lvl = original.skill_taming_lvl;
			clone.skill_dungeon_lvl = original.skill_dungeon_lvl;
			clone.skill_carpentry_lvl = original.skill_carpentry_lvl;
			clone.skill_runes_lvl = original.skill_runes_lvl;
			clone.skill_socal_lvl = original.skill_socal_lvl;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "hypixel_skyblock_worldvars";
		public double islandSpawn_default_X = 0;
		public double islandSpawn_default_Y = 30.0;
		public double islandSpawn_default_Z = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			islandSpawn_default_X = nbt.getDouble("islandSpawn_default_X");
			islandSpawn_default_Y = nbt.getDouble("islandSpawn_default_Y");
			islandSpawn_default_Z = nbt.getDouble("islandSpawn_default_Z");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("islandSpawn_default_X", islandSpawn_default_X);
			nbt.putDouble("islandSpawn_default_Y", islandSpawn_default_Y);
			nbt.putDouble("islandSpawn_default_Z", islandSpawn_default_Z);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "hypixel_skyblock_mapvars";
		public double islandSpawnOffset_X = 400.0;
		public double islandSpawnOffset_Z = 0.0;
		public double skill_mining_lvl = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			islandSpawnOffset_X = nbt.getDouble("islandSpawnOffset_X");
			islandSpawnOffset_Z = nbt.getDouble("islandSpawnOffset_Z");
			skill_mining_lvl = nbt.getDouble("skill_mining_lvl");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("islandSpawnOffset_X", islandSpawnOffset_X);
			nbt.putDouble("islandSpawnOffset_Z", islandSpawnOffset_Z);
			nbt.putDouble("skill_mining_lvl", skill_mining_lvl);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("hypixel_skyblock", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double mana_max = 100.0;
		public double Player_islandSpawn_X = 0;
		public double Player_islandSpawn_Y = 30.0;
		public double Player_islandSpawn_Z = 0;
		public double health_max = 100.0;
		public double overheal = 0;
		public double skill_farming_lvl = 0;
		public double skill_combat_lvl = 0;
		public double skill_foraging_lvl = 0;
		public double skill_fishing_lvl = 0;
		public double skill_enchant_lvl = 0;
		public double skill_alchemy_lvl = 0;
		public double skill_taming_lvl = 0;
		public double skill_dungeon_lvl = 0;
		public double skill_carpentry_lvl = 0;
		public double skill_runes_lvl = 0;
		public double skill_socal_lvl = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				HypixelSkyblockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("mana_max", mana_max);
			nbt.putDouble("Player_islandSpawn_X", Player_islandSpawn_X);
			nbt.putDouble("Player_islandSpawn_Y", Player_islandSpawn_Y);
			nbt.putDouble("Player_islandSpawn_Z", Player_islandSpawn_Z);
			nbt.putDouble("health_max", health_max);
			nbt.putDouble("overheal", overheal);
			nbt.putDouble("skill_farming_lvl", skill_farming_lvl);
			nbt.putDouble("skill_combat_lvl", skill_combat_lvl);
			nbt.putDouble("skill_foraging_lvl", skill_foraging_lvl);
			nbt.putDouble("skill_fishing_lvl", skill_fishing_lvl);
			nbt.putDouble("skill_enchant_lvl", skill_enchant_lvl);
			nbt.putDouble("skill_alchemy_lvl", skill_alchemy_lvl);
			nbt.putDouble("skill_taming_lvl", skill_taming_lvl);
			nbt.putDouble("skill_dungeon_lvl", skill_dungeon_lvl);
			nbt.putDouble("skill_carpentry_lvl", skill_carpentry_lvl);
			nbt.putDouble("skill_runes_lvl", skill_runes_lvl);
			nbt.putDouble("skill_socal_lvl", skill_socal_lvl);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			mana_max = nbt.getDouble("mana_max");
			Player_islandSpawn_X = nbt.getDouble("Player_islandSpawn_X");
			Player_islandSpawn_Y = nbt.getDouble("Player_islandSpawn_Y");
			Player_islandSpawn_Z = nbt.getDouble("Player_islandSpawn_Z");
			health_max = nbt.getDouble("health_max");
			overheal = nbt.getDouble("overheal");
			skill_farming_lvl = nbt.getDouble("skill_farming_lvl");
			skill_combat_lvl = nbt.getDouble("skill_combat_lvl");
			skill_foraging_lvl = nbt.getDouble("skill_foraging_lvl");
			skill_fishing_lvl = nbt.getDouble("skill_fishing_lvl");
			skill_enchant_lvl = nbt.getDouble("skill_enchant_lvl");
			skill_alchemy_lvl = nbt.getDouble("skill_alchemy_lvl");
			skill_taming_lvl = nbt.getDouble("skill_taming_lvl");
			skill_dungeon_lvl = nbt.getDouble("skill_dungeon_lvl");
			skill_carpentry_lvl = nbt.getDouble("skill_carpentry_lvl");
			skill_runes_lvl = nbt.getDouble("skill_runes_lvl");
			skill_socal_lvl = nbt.getDouble("skill_socal_lvl");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.mana_max = message.data.mana_max;
					variables.Player_islandSpawn_X = message.data.Player_islandSpawn_X;
					variables.Player_islandSpawn_Y = message.data.Player_islandSpawn_Y;
					variables.Player_islandSpawn_Z = message.data.Player_islandSpawn_Z;
					variables.health_max = message.data.health_max;
					variables.overheal = message.data.overheal;
					variables.skill_farming_lvl = message.data.skill_farming_lvl;
					variables.skill_combat_lvl = message.data.skill_combat_lvl;
					variables.skill_foraging_lvl = message.data.skill_foraging_lvl;
					variables.skill_fishing_lvl = message.data.skill_fishing_lvl;
					variables.skill_enchant_lvl = message.data.skill_enchant_lvl;
					variables.skill_alchemy_lvl = message.data.skill_alchemy_lvl;
					variables.skill_taming_lvl = message.data.skill_taming_lvl;
					variables.skill_dungeon_lvl = message.data.skill_dungeon_lvl;
					variables.skill_carpentry_lvl = message.data.skill_carpentry_lvl;
					variables.skill_runes_lvl = message.data.skill_runes_lvl;
					variables.skill_socal_lvl = message.data.skill_socal_lvl;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
