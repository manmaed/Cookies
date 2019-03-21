package com.unrealdinnerbone.unreallib.api;


import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.Item;

public interface IHungerFood extends IItemEnum
{
    int getHungerRestored();

    float getStation();

    default boolean isWolfFood() {
        return false;
    }

    default boolean isFastEat() {
        return false;
    }

    default boolean alwaysEdable() {
        return false;
    }

    @Override
    default Item.Settings getItemSetting() {
        return new Item.Settings().itemGroup(getItemGroup()).food(getFoodItemSetting());
    }

    default FoodItemSetting getFoodItemSetting() {
        FoodItemSetting.Builder builder = new FoodItemSetting.Builder();
        if(alwaysEdable()) {
            builder.alwaysEdible();
        }
        if(isFastEat()) {
            builder.eatenFast();
        }
        if(isWolfFood()) {
            builder.wolfFood();
        }
        builder.hunger(getHungerRestored());
        builder.saturationModifier(getStation());
        return builder.build();
    }
}
