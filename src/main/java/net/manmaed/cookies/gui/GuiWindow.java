package net.manmaed.cookies.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

/**
 * Created by manmaed on 03/02/2019.
 */
public class GuiWindow extends GuiContainer {
    int x, y, z;
    EntityPlayer entity;

    public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
        super(new GiftBoxGui(world, x, y, z,  entity));
        this.x = x;
        this.y = y;
        this.z = z;
        this.entity = entity;
        this.xSize = 176;
        this.ySize = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("boxgui.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawDefaultBackground();
        this.mc.renderEngine.bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        zLevel = 100.0F;
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        try {
            super.mouseClicked(mouseX, mouseY, mouseButton);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        try {
            super.keyTyped(typedChar, keyCode);
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRenderer.drawString("name", 75, 31, -1);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiLeft = (this.width - 176) / 2;
        this.guiTop = (this.height - 166) / 2;
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        World world = server.getWorld(entity.dimension);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
