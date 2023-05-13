
package net.philippelevis.hypixelskyblock.client.renderer;

import net.philippelevis.hypixelskyblock.entity.DiamondMinionEntity;
import net.philippelevis.hypixelskyblock.client.model.Modeluk_bullet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DiamondMinionRenderer extends MobRenderer<DiamondMinionEntity, Modeluk_bullet<DiamondMinionEntity>> {
	public DiamondMinionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeluk_bullet(context.bakeLayer(Modeluk_bullet.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DiamondMinionEntity entity) {
		return new ResourceLocation("hypixel_skyblock:textures/entities/uk_bullet_ent.png");
	}
}
