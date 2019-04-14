package com.unrealdinnerbone.unreallib.api;

import com.unrealdinnerbone.unreallib.api.container.IContainer;
import com.unrealdinnerbone.unreallib.api.registry.IRegistryItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.lib.EnumUtil;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.function.Supplier;

public class UnRealRegistry {

    private final String MOD_ID;

    public UnRealRegistry(String modId) {
        this.MOD_ID = modId;
    }

    public ItemGroup createModItemGroup(Supplier<ItemStack> itemStackSupplier) {
        return FabricItemGroupBuilder.create(createIdentifier(MOD_ID)).icon(itemStackSupplier).build();
    }

    public <T extends Item> T registerItem(T item, String name) {
        return Registry.register(Registry.ITEM, createIdentifier(name), item);
    }

    public BlockEntityType registerBlockEntity(BlockEntityType<?> blockEntityType, String name) {
        return Registry.register(Registry.BLOCK_ENTITY, createIdentifier(name), blockEntityType);
    }


    public Block registerBlock(Block block, String name) {
        return Registry.register(Registry.BLOCK, createIdentifier(name), block);
    }

    public Pair<Block, BlockItem> registerBlockWithItem(Block block, Item.Settings settings, String name) {
        Block theBlock = registerBlock(block, name);
        BlockItem theRealBlockItem = registerItem(new BlockItem(theBlock, settings), name);
        return new Pair<>(theBlock, theRealBlockItem);
    }

    public <T extends Enum<T> & IContainer> void registerEnumAsContainer(Class<T> enumClass) {
        Arrays.stream(enumClass.getEnumConstants()).forEach(enumConstant -> {
            ContainerProviderRegistry.INSTANCE.registerFactory(enumConstant.getID(), enumConstant.getContainer());
            if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                Runnable runnable = () -> ScreenProviderRegistry.INSTANCE.registerFactory(enumConstant.getID(), enumConstant.getGuiCon());
                runnable.run();
            }
        });
    }

    public <T extends Enum<T> & IRegistryItem<Item>> void registerEnumsAsItems(Class<T> enumClass) {
        Arrays.stream(enumClass.getEnumConstants()).forEach(enumConstant -> registerItem(enumConstant.get(), EnumUtil.getNameOfEnum(enumConstant)));
    }

    public <T extends Enum<T> & IRegistryItem<BlockEntityType<?>>> void registerEnumsAsBlockEntity(Class<T> enumClass) {
        Arrays.stream(enumClass.getEnumConstants()).forEach(enumConstant -> registerBlockEntity(enumConstant.get(), EnumUtil.getNameOfEnum(enumConstant)));

    }

    private Identifier createIdentifier(String path) {
        return new Identifier(MOD_ID, path);
    }

}
