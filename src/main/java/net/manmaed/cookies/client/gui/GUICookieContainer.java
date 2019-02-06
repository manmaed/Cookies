package net.manmaed.cookies.client.gui;

import net.manmaed.cookies.container.CookieContainer;
import net.manmaed.cookies.libs.Reference;
import net.manmaed.cookies.tile.TileEntityGiftBox;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 04/02/2019.
 */
public class GUICookieContainer extends GuiContainer {

    private static final int WIDTH = 176;
    private static final int HEIGHT = 166;

    private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/giftbox.png");

    public GUICookieContainer(TileEntityGiftBox tileEntity, CookieContainer inventorySlotsIn) {
        super(inventorySlotsIn);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
