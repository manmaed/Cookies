package net.manmaed.cookies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.manmaed.cookies.blocks.CookieBlocks;
import net.manmaed.cookies.client.gui.GUICookieContainer;
import net.manmaed.cookies.container.CookieContainer;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.tile.CookieBlockEntities;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CookiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("Loading Cookie Client!");
        ScreenProviderRegistry.INSTANCE.registerFactory(Cookies.CON, GUICookieContainer::new);

    }
}
