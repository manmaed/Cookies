package net.manmaed.cookies.blocks.dud;

import net.manmaed.cookies.libs.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.NonNullList;

/**
 * Created by manmaed on 13/01/2019.
 */
public class TileEntityGiftBox extends TileEntityLockableLoot {

    private NonNullList<ItemStack> stacks = NonNullList.<ItemStack> withSize(4, ItemStack.EMPTY);

    public int getSizeInventory()
    {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemStack : this.stacks)
            if (!itemStack.isEmpty())
                return false;
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return stacks.get(index);
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.giftbox" ;
    }
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.stacks = NonNullList.<ItemStack> withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound))
            ItemStackHelper.loadAllItems(compound, this.stacks);
        if (compound.hasKey("CustomName", 8))
            this.customName = compound.getString("CustomName");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (!this.checkLootAndWrite(compound))
            ItemStackHelper.saveAllItems(compound, this.stacks);
        if (this.hasCustomName())
            compound.setString("CustomName", this.customName);
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public String getGuiID() {
        return Reference.MOD_ID.toLowerCase() + ":box";
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        this.fillWithLoot(playerIn);
        return new ContainerDispenser(playerInventory, this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }
}
