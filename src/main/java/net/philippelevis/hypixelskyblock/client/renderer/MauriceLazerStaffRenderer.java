package net.philippelevis.hypixelskyblock.client.renderer;

import net.philippelevis.hypixelskyblock.entity.MauriceLazerStaffEntity;
import net.philippelevis.hypixelskyblock.client.model.Modeluk_bullet;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Vector3f;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MauriceLazerStaffRenderer extends EntityRenderer<MauriceLazerStaffEntity> {
	private static final ResourceLocation texture = new ResourceLocation("hypixel_skyblock:textures/entities/uk_bullet_ent.png");
	private final Modeluk_bullet model;

	public MauriceLazerStaffRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modeluk_bullet(context.bakeLayer(Modeluk_bullet.LAYER_LOCATION));
	}

	@Override
	public void render(MauriceLazerStaffEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(MauriceLazerStaffEntity entity) {
		return texture;
	}
}
