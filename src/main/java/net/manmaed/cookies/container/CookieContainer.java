package net.manmaed.cookies.container;

import net.minecraft.container.Container;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

import java.util.stream.IntStream;

public class CookieContainer extends Container {

    private final Inventory inventory;
    public final PlayerEntity playerEntity;

    public CookieContainer(int syncId, PlayerEntity playerEntity, Inventory inventory) {
        super(null, syncId);
        this.inventory = inventory;
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
    public ItemStack transferSlot(PlayerEntity playerEntity_1, int int_1) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot_1 = this.slotList.get(int_1);
        if (slot_1 != null && slot_1.hasStack()) {
            ItemStack itemStack_2 = slot_1.getStack();
            if (int_1 < 4) {
                if (!this.insertItem(itemStack_2, 4, this.slotList.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack_2, 0, 4, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack_2.isEmpty()) {
                slot_1.setStack(ItemStack.EMPTY);
            } else {
                slot_1.markDirty();
            }
        }

        return itemStack;
    }


    @Override
    public boolean canUse(PlayerEntity var1) {
        return true;
    }
}