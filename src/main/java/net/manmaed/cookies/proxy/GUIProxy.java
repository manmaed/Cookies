package net.manmaed.cookies.proxy;

import net.manmaed.cookies.container.CookieContainer;
import net.manmaed.cookies.client.gui.GUICookieContainer;
import net.manmaed.cookies.tile.TileEntityGiftBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by manmaed on 04/02/2019.
 */
public class GUIProxy implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity instanceof TileEntityGiftBox) {
            return new CookieContainer(player.inventory, (TileEntityGiftBox) tileEntity);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(pos);
        if(tileEntity instanceof TileEntityGiftBox) {
            TileEntityGiftBox giftBoxContainerTileEntity = (TileEntityGiftBox) tileEntity;
            return new GUICookieContainer(giftBoxContainerTileEntity, new CookieContainer(player.inventory, giftBoxContainerTileEntity));
        }
        return null;
    }
}
