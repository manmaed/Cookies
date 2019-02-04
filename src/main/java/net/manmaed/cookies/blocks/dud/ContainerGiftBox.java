package net.manmaed.cookies.blocks.dud;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by manmaed on 13/01/2019.
 */
public class ContainerGiftBox extends Container {

    private final int numRows;
    private final TileEntityGiftBox inventory;

    public ContainerGiftBox(InventoryPlayer playerInv, TileEntityGiftBox giftBoxTileEntity, EntityPlayer player) {
        this.inventory = giftBoxTileEntity;
        this.numRows = 2;
        /*giftBoxTileEntity.openInventory(player);*/
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        /*return this.inventory.isUsableByPlayer();*/
        return canInteractWith(playerIn);
    }
}
