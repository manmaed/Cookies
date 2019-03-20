package net.manmaed.cookies;

import com.unrealdinnerbone.unreallib.api.RegistryHelper;
import com.unrealdinnerbone.unreallib.api.WorldGenUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.manmaed.cookies.blocks.CookieBlocks;
import net.manmaed.cookies.container.CookieContainer;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.tile.BlockEntityGiftBox;
import net.manmaed.cookies.tile.CookieBlockEntities;
import net.manmaed.cookies.world.CustomTreeGen;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;

import static net.minecraft.world.biome.Biome.configureFeature;

public class Cookies implements ModInitializer {

    public static final String MOD_ID = "cookies";
    public static final Identifier CON = new Identifier(MOD_ID, "con");
    public final static RegistryHelper REGISTRY = new RegistryHelper(MOD_ID);
//    public final static CustomTreeGen worldGenTree = WorldGenUtil.createBaiscTree();

    @Override
    public void onInitialize() {
        System.out.println("Loading Cookie!");
        CookieItems.load(REGISTRY);
        CookieBlocks.load(REGISTRY);
        CookieContainers.init();
        CookieBlockEntities.init(REGISTRY);
        ContainerProviderRegistry.INSTANCE.registerFactory(CON, (syncId, identifier, player, buf) -> {
            BlockPos blockPos = buf.readBlockPos();
            BlockEntity blockEntity = player.world.getBlockEntity(blockPos);
            return blockEntity instanceof BlockEntityGiftBox ? new CookieContainer(syncId, player, ((BlockEntityGiftBox) blockEntity)) : null;
                }
        );

//        Registry.register(Registry.FEATURE, new Identifier(MOD_ID, "tree"), worldGenTree);
//        Registry.BIOME.stream().forEach(biome -> biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(new Feature[]{worldGenTree}, new FeatureConfig[]{FeatureConfig.DEFAULT}, new float[]{0.025F}, Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.DARK_OAK_TREE, DecoratorConfig.DEFAULT)));

    }
}
