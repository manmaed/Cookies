package net.manmaed.cookies.container;

import net.manmaed.cookies.tile.TileEntityGiftBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by manmaed on 04/02/2019.
 */
public class CookieContainer extends Container {

    private TileEntityGiftBox tileEntity;

    public CookieContainer(IInventory playerInventory, TileEntityGiftBox tileEntity) {
        this.tileEntity = tileEntity;
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int i1 = 0; i1 < 3; ++i1)
        {
            for (int k1 = 0; k1 < 9; ++k1)
            {
                this.addSlotToContainer(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; ++j1)
        {
            this.addSlotToContainer(new Slot(playerInventory, j1, 8 + j1 * 18, 142));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        addSlotToContainer(new SlotItemHandler(itemHandler, 0, 63, 20));
        addSlotToContainer(new SlotItemHandler(itemHandler, 1, 96, 20));

        addSlotToContainer(new SlotItemHandler(itemHandler, 2, 63, 53));
        addSlotToContainer(new SlotItemHandler(itemHandler, 3, 96, 53));


    }


    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < TileEntityGiftBox.SIZE) {
                if (!this.mergeItemStack(itemstack1, TileEntityGiftBox.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, TileEntityGiftBox.SIZE, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileEntity.canInteractWith(playerIn);
    }
}
