package net.manmaed.cookies.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import net.manmaed.cookies.render.model.ModelGiftBox;
import net.manmaed.cookies.libs.Textures;

/**
 * Created by manmaed on 13/01/2019.
 */
public class GiftBoxRenderer extends TileEntitySpecialRenderer {

    private final ModelGiftBox modelGiftBox;

    public GiftBoxRenderer() {
        this.modelGiftBox = new ModelGiftBox();
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F ,(float)z +0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        this.bindTexture(Textures.GIFT_BOX);
        modelGiftBox.renderModel(0.0625F);
        GL11.glPopMatrix();
    }
}
