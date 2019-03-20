package com.unrealdinnerbone.unreallib.api;


public interface IHungerFood extends IItemEnum
{
    int getHungerRestored();

    float getStation();

    default boolean isWolfFood() {
        return false;
    }
}
