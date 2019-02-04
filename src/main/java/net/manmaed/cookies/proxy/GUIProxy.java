package net.manmaed.cookies.proxy;

import net.manmaed.cookies.blocks.giftbox.CookieContainer;
import net.manmaed.cookies.blocks.giftbox.CookieContainerGui;
import net.manmaed.cookies.blocks.giftbox.GiftBoxContainerTileEntity;
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
        if (tileEntity instanceof GiftBoxContainerTileEntity) {
            return new CookieContainer(player.inventory, (GiftBoxContainerTileEntity) tileEntity);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(pos);
        if(tileEntity instanceof GiftBoxContainerTileEntity) {
            GiftBoxContainerTileEntity giftBoxContainerTileEntity = (GiftBoxContainerTileEntity) tileEntity;
            return new CookieContainerGui(giftBoxContainerTileEntity, new CookieContainer(player.inventory, giftBoxContainerTileEntity));
        }
        return null;
    }
}
