package net.philippelevis.hypixelskyblock.client.gui;

import net.philippelevis.hypixelskyblock.world.inventory.MinionGUIMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MinionGUIScreen extends AbstractContainerScreen<MinionGUIMenu> {
	private final static HashMap<String, Object> guistate = MinionGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_next_tier;
	ImageButton imagebutton_pick_up;
	ImageButton imagebutton_quik_upgrd_notavail;
	ImageButton imagebutton_collect_all;
	ImageButton imagebutton_hypixel_compass;

	public MinionGUIScreen(MinionGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 210;
	}

	private static final ResourceLocation texture = new ResourceLocation("hypixel_skyblock:textures/screens/minion_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/empty.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/profile.png"));
		this.blit(ms, this.leftPos + 76, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/fuel.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 41, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/automated_shipping.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/upgrade_slot.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 78, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("hypixel_skyblock:textures/screens/upgrade_slot.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 96, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.hypixel_skyblock.minion_gui.label_minion"), 12, 9, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		imagebutton_next_tier = new ImageButton(this.leftPos + 92, this.topPos + 9, 16, 16, 0, 0, 16, new ResourceLocation("hypixel_skyblock:textures/screens/atlas/imagebutton_next_tier.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_next_tier", imagebutton_next_tier);
		this.addRenderableWidget(imagebutton_next_tier);
		imagebutton_pick_up = new ImageButton(this.leftPos + 156, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("hypixel_skyblock:textures/screens/atlas/imagebutton_pick_up.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_pick_up", imagebutton_pick_up);
		this.addRenderableWidget(imagebutton_pick_up);
		imagebutton_quik_upgrd_notavail = new ImageButton(this.leftPos + 108, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("hypixel_skyblock:textures/screens/atlas/imagebutton_quik_upgrd_notavail.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_quik_upgrd_notavail", imagebutton_quik_upgrd_notavail);
		this.addRenderableWidget(imagebutton_quik_upgrd_notavail);
		imagebutton_collect_all = new ImageButton(this.leftPos + 60, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("hypixel_skyblock:textures/screens/atlas/imagebutton_collect_all.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_collect_all", imagebutton_collect_all);
		this.addRenderableWidget(imagebutton_collect_all);
		imagebutton_hypixel_compass = new ImageButton(this.leftPos + 12, this.topPos + 25, 16, 16, 0, 0, 16, new ResourceLocation("hypixel_skyblock:textures/screens/atlas/imagebutton_hypixel_compass.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_hypixel_compass", imagebutton_hypixel_compass);
		this.addRenderableWidget(imagebutton_hypixel_compass);
	}
}
