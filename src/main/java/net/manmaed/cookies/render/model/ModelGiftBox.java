package net.manmaed.cookies.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * giftbox - Loneztar
 * Created using Tabula 7.0.0
 */
public class ModelGiftBox extends ModelBase {
    public ModelRenderer boxbottom;
    public ModelRenderer boxtop;

    public ModelGiftBox() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.boxtop = new ModelRenderer(this, 0, 16);
        this.boxtop.setRotationPoint(-6.5F, 16.0F, -6.5F);
        this.boxtop.addBox(0.0F, 0.0F, 0.0F, 13, 3, 13, 0.0F);
        this.boxbottom = new ModelRenderer(this, 0, 0);
        this.boxbottom.setRotationPoint(-5.5F, 19.0F, -5.5F);
        this.boxbottom.addBox(0.0F, 0.0F, 0.0F, 11, 5, 11, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.boxbottom.render(f5);
        this.boxtop.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void renderModel(float f5) {
        boxbottom.render(f5);
        boxtop.render(f5);

    }
}
