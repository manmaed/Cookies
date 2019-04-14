package net.manmaed.cookies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.manmaed.cookies.container.CookieContainers;

import java.util.Arrays;

public class CookiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("Loading Cookie Client!");
    }
}
