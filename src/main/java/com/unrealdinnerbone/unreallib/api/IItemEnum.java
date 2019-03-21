package com.unrealdinnerbone.unreallib.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public interface IItemEnum
{
    ItemGroup getItemGroup();

    default Item.Settings getItemSetting() {
        return new Item.Settings().itemGroup(getItemGroup());
    }
}
