package net.manmaed.cookies.container;

import net.minecraft.container.Container;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

import java.util.stream.IntStream;

public class CookieContainer extends Container {

    public final PlayerEntity playerEntity;

    public CookieContainer(Integer syncId, PlayerEntity playerEntity, Inventory inventory) {
        super(null, syncId);
        this.playerEntity = playerEntity;
        PlayerInventory playerInventory = playerEntity.inventory;
        IntStream.range(0, 9).mapToObj(j -> new Slot(playerInventory, j + 9, 8 + j * 18, 84)).forEach(this::addSlot);
        IntStream.range(0, 9).mapToObj(j -> new Slot(playerInventory, j + 9 + 9, 8 + j * 18, 84 + 18)).forEach(this::addSlot);
        IntStream.range(0, 9).mapToObj(j -> new Slot(playerInventory, j + 2 * 9 + 9, 8 + j * 18, 84 + 2 * 18)).forEach(this::addSlot);
        IntStream.range(0, 9).mapToObj(j -> new Slot(playerInventory, j, 8 + j * 18, 142)).forEach(this::addSlot);

        this.addSlot(new Slot(inventory, 0, 63, 20));
        this.addSlot(new Slot(inventory, 1, 96, 20));
        this.addSlot(new Slot(inventory, 2, 63, 53));
        this.addSlot(new Slot(inventory, 3, 96, 53));

    }

    @Override
    public ItemStack transferSlot(PlayerEntity playerEntity, int slotSpot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slotList.get(slotSpot);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack_2 = slot.getStack();
            if (slotSpot < 4) {
                if (!this.insertItem(itemStack_2, 4, this.slotList.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack_2, 0, 4, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack_2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemStack;
    }


    @Override
    public boolean canUse(PlayerEntity var1) {
        return true;
    }
}