package com.unrealdinnerbone.unreallib.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ItemUtil
{
    public static Supplier<ItemStack> getItemStack(Item item) {
        return () -> new ItemStack(item);
    }
}
