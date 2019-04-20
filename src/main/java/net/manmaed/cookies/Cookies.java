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
//    public final static CustomTreeGen worldGenTree = WorldGenUtil.createBaiscTree();

    @Override
    public void onInitialize() {
        LOGGER.info("[Cookies] Loading!");
        CookieBlocks.load(REGISTRY);
        REGISTRY.registerEnumsAsBlockEntity(CookieBlockEntities.class);
        REGISTRY.registerEnumsAsItems(CookieItems.Foods.class);
        REGISTRY.registerEnumsAsItems(CookieItems.Basic.class);

        REGISTRY.registerEnumAsContainer(CookieContainers.class);
//        Registry.register(Registry.FEATURE, new Identifier(MOD_ID, "tree"), worldGenTree);
//        Registry.BIOME.stream().forEach(biome -> biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{worldGenTree}, new FeatureConfig[]{FeatureConfig.DEFAULT}, new float[]{0.025F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.DARK_OAK_TREE, DecoratorConfig.DEFAULT)));

    }
}
