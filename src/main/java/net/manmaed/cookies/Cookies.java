package net.manmaed.cookies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.manmaed.cookies.blocks.CookieBlocks;
import net.manmaed.cookies.container.CookieContainer;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.tile.BlockEntityGiftBox;
import net.manmaed.cookies.tile.CookieBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;


public class Cookies implements ModInitializer {

    public static ItemGroup itemGroup = FabricItemGroupBuilder.build(new Identifier(Cookies.MOD_ID, Cookies.MOD_ID), () -> new ItemStack(CookieItems.ccGBMan));
    public static final String MOD_ID = "cookies";
    public static final Identifier CON = new Identifier(MOD_ID, "con");

    @Override
    public void onInitialize() {
        System.out.println("Loading Cookies!");
        CookieBlocks.load();
        CookieItems.load();
        CookieContainers.init();
        CookieBlockEntities.init();

        ContainerProviderRegistry.INSTANCE.registerFactory(CON, (syncId, identifier, player, buf) -> {
                    BlockPos blockPos = buf.readBlockPos();
                    BlockEntity blockEntity = player.world.getBlockEntity(blockPos);
                    if(blockEntity instanceof BlockEntityGiftBox) {
                        return new CookieContainer(syncId, player, ((BlockEntityGiftBox) blockEntity));
                    }else {
                        return null;
                    }
        }
        );
    }
}
