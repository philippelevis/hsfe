
package net.philippelevis.hypixelskyblock.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/statbarempty.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 1, posY + 89, 0, 0, 90, 2, 90, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar_start.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 1, posY + 89, 0, 0, 6, 2, 6, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar_end.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 85, posY + 89, 0, 0, 6, 2, 6, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 7, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 10, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 13, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 16, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 19, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 22, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 25, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 28, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 31, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 34, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 37, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 40, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 43, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 46, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 49, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 52, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 55, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 58, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 61, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 64, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 67, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 70, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 73, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 76, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 79, posY + 89, 0, 0, 3, 2, 3, 2);

			RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/manabar.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 82, posY + 89, 0, 0, 3, 2, 3, 2);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
