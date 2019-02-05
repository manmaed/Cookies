package net.manmaed.cookies.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by manmaed on 03/02/2019.
 */
public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GiftBoxGui.GUIID) {
            return new GiftBoxGui(world, x, y, z, player);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GiftBoxGui.GUIID) {
            return new GuiWindow(world, x, y, z, player);
        }
        return null;
    }
}
