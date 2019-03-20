package net.manmaed.cookies.client.gui;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.container.CookieContainer;
import net.minecraft.client.gui.ContainerScreen;
import net.minecraft.text.StringTextComponent;
import net.minecraft.util.Identifier;

public class GUICookieContainer extends ContainerScreen<CookieContainer> {

    private static final int WIDTH = 176;
    private static final int HEIGHT = 166;

    private static final Identifier background = new Identifier(Cookies.MOD_ID, "textures/gui/giftbox.png");

    public GUICookieContainer(CookieContainer cookieContainer) {
        super(cookieContainer, cookieContainer.playerEntity.inventory, new StringTextComponent("Test"));
        width = WIDTH;
        height = HEIGHT;
    }

    @Override
    protected void drawBackground(float var1, int var2, int var3) {
        client.getTextureManager().bindTexture(background);
        this.drawTexturedRect(left, top, 0, 0, width, height);
    }
}
