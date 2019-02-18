package net.manmaed.cookies.tile;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.container.CookieContainer;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.InventoryUtil;

public class BlockEntityGiftBox extends LootableContainerBlockEntity {

    private DefaultedList<ItemStack> inventory;


    public BlockEntityGiftBox() {
        super(CookieBlockEntities.GIFT_BOX);
        this.inventory = DefaultedList.create(4, ItemStack.EMPTY);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> var1) {
        this.inventory = var1;
    }

    @Override
    public int getInvSize() {
        return 4;
    }

    @Override
    public boolean isInvEmpty() {
        return this.inventory.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public void fromTag(CompoundTag compoundTag) {
        super.fromTag(compoundTag);
        this.inventory = DefaultedList.create(this.getInvSize(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(compoundTag)) {
            InventoryUtil.deserialize(compoundTag, this.inventory);
        }

    }

    @Override
    public CompoundTag toTag(CompoundTag compoundTag) {
        super.toTag(compoundTag);
        if (!this.serializeLootTable(compoundTag)) {
            InventoryUtil.serialize(compoundTag, this.inventory);
        }
        return compoundTag;
    }

    @Override
    protected TextComponent getContainerName() {
        return new TranslatableTextComponent(Cookies.MOD_ID+ "container.giftbox");
    }

    protected Container createContainer(int int_1, PlayerInventory playerInventory) {
        return new CookieContainer(int_1, playerInventory.player, this);
    }



}
