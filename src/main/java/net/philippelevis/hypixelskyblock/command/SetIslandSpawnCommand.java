
package net.philippelevis.hypixelskyblock.command;

import org.checkerframework.checker.units.qual.s;

import net.philippelevis.hypixelskyblock.procedures.SetIslandSpawnProcProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class SetIslandSpawnCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("islspawn").requires(s -> s.hasPermission(4)).then(Commands.argument("block", BlockPosArgument.blockPos()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			SetIslandSpawnProcProcedure.execute(world, x, y, z);
			return 0;
		})));
	}
}
