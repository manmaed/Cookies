package net.manmaed.cookies.client.gui;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.container.CookieContainer;
import net.minecraft.client.gui.screen.ingame.AbstractContainerScreen;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class GUICookieContainer extends AbstractContainerScreen<CookieContainer> {

    private static final int WIDTH = 176;
    private static final int HEIGHT = 166;

    private static final Identifier background = new Identifier(Cookies.MOD_ID, "textures/screen/giftbox.png");

    public GUICookieContainer(CookieContainer cookieContainer) {
        super(cookieContainer, cookieContainer.playerEntity.inventory, new LiteralText("Test"));
        width = WIDTH;
        height = HEIGHT;
    }

    @Override
    protected void drawBackground(float var1, int var2, int var3) {
        minecraft.getTextureManager().bindTexture(background);
        this.blit(left, top, 0, 0, width, height);
    }
}
