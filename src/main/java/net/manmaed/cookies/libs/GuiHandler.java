package net.manmaed.cookies.libs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by manmaed on 13/01/2019.
 */
public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        /*if(ID == Reference.GUI_GIFTBOX) return new ContainerGiftBox(player.inventory, (GiftBoxTileEntity)world.getTileEntity(new BlockPos(x, y, x)), player);*/
        return getClientGuiElement(id, player, world, x, y, z);
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        /*if(ID == Reference.GUI_GIFTBOX) return new GuiGiftBox(player.inventory, (GiftBoxTileEntity)world.getTileEntity(new BlockPos(x,y,z)), player);
         */
        return getClientGuiElement(id, player, world, x, y, z);
    }
}
