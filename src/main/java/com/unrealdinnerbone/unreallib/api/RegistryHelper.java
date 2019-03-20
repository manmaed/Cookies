package com.unrealdinnerbone.unreallib.api;

import net.manmaed.cookies.lib.EnumUtil;
import net.minecraft.block.Block;
import net.minecraft.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;

public class RegistryHelper {

    private final String MOD_ID;

    public RegistryHelper(String modId) {
        this.MOD_ID = modId;
    }

    public Item registerItem(Item item, String name) {
        return Registry.register(Registry.ITEM, createIdentifier(name), item);
    }

    public Block registerBlock(Block block, String name) {
        return Registry.register(Registry.BLOCK, createIdentifier(name), block);
    }

    public Pair<Block, BlockItem> registerBlockWithItem(Block block, Item.Settings settings, String name) {
        Block theBlock = registerBlock(block, name);
        BlockItem theBlockItem = new BlockItem(theBlock, settings);
        registerItem(new BlockItem(theBlock, settings), name);
        return new Pair<>(theBlock, theBlockItem);
    }

    public <T extends Enum<T> & IItemEnum> void registerEnumAsItem(Class<T> enumClass) {
        Arrays.stream(enumClass.getEnumConstants()).forEach(enumConstant -> registerItem(new Item(enumConstant.getItemSetting()), EnumUtil.getNameOfEnum(enumConstant)));
    }
    public <T extends Enum<T> & IHungerFood> void registerEnumAsFoodItem(Class<T> enumClass) {
        Arrays.stream(enumClass.getEnumConstants()).forEach(enumConstant -> registerItem(new FoodItem(enumConstant.getHungerRestored(), enumConstant.getStation(), enumConstant.isWolfFood(), enumConstant.getItemSetting()), EnumUtil.getNameOfEnum(enumConstant)));

    }

    private Identifier createIdentifier(String path) {
        return new Identifier(MOD_ID, path);
    }

}
