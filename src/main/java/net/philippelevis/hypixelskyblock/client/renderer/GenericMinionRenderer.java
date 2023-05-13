
package net.philippelevis.hypixelskyblock.client.renderer;

import net.philippelevis.hypixelskyblock.entity.GenericMinionEntity;
import net.philippelevis.hypixelskyblock.client.model.Modeluk_bullet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GenericMinionRenderer extends MobRenderer<GenericMinionEntity, Modeluk_bullet<GenericMinionEntity>> {
	public GenericMinionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeluk_bullet(context.bakeLayer(Modeluk_bullet.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GenericMinionEntity entity) {
		return new ResourceLocation("hypixel_skyblock:textures/entities/necron_layer_1.png");
	}
}
