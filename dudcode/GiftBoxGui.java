package net.manmaed.cookies.gui;

import net.manmaed.cookies.blocks.dud.TileEntityGiftBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;

/**
 * Created by manmaed on 03/02/2019.
 */
public class GiftBoxGui extends Container {

    public static int GUIID = 1;
    public static HashMap guiinventory = new HashMap();
    public static IInventory box_inv;
    public static IInventory inherited;
    World world;
    EntityPlayer player;
    int x, y, z;

    public GiftBoxGui(World world, int x, int y, int z, EntityPlayer player) {
        this.world = world;
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if (tileEntity != null && tileEntity instanceof TileEntityGiftBox) {
            inherited = (IInventory) tileEntity;
        } else {
            inherited = new InventoryBasic("", true, 9);
        }
        box_inv = new InventoryBasic("box_inv", true, 4);
        guiinventory.put("box_inv", box_inv);
        guiinventory.put("inherited", inherited);
        this.addSlotToContainer(new Slot(box_inv, 0, 41, 11) {

            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new Slot(box_inv, 1, 124, 10) {
        });
        this.addSlotToContainer(new Slot(box_inv, 2, 40, 55) {

            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new Slot(box_inv, 3, 123, 54) {
        });
        int si;
        int sj;
        for (si = 0; si < 3; ++si)
            for (sj = 0; sj < 9; ++sj)
                this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
        for (si = 0; si < 9; ++si)
            this.addSlotToContainer(new Slot(player.inventory, si, 0 + 8 + si * 18, 0 + 142));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 9) {
                if (!this.mergeItemStack(itemstack1, 9, (45 - 9), true))
                    return ItemStack.EMPTY;
            } else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
    }
}


