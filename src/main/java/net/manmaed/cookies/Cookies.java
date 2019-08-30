package net.manmaed.cookies;

import com.unrealdinnerbone.unreallib.api.UnRealRegistry;
import net.fabricmc.api.ModInitializer;
import net.manmaed.cookies.blocks.CookieBlocks;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.tile.CookieBlockEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cookies implements ModInitializer {

    public static final String MOD_ID = "cookies";
    public final static UnRealRegistry REGISTRY = new UnRealRegistry(MOD_ID);
    public final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("[Cookies] Loading!");
        CookieBlocks.load(REGISTRY);
        REGISTRY.registerEnumsAsBlockEntity(CookieBlockEntities.class);
        REGISTRY.registerEnumsAsItems(CookieItems.Foods.class);
        REGISTRY.registerEnumsAsItems(CookieItems.Basic.class);

        REGISTRY.registerEnumAsContainer(CookieContainers.class);

    }
}
