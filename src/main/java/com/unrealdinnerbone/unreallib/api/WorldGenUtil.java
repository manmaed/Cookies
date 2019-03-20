package com.unrealdinnerbone.unreallib.api;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.OakTreeFeature;

public class WorldGenUtil
{
    public static OakTreeFeature createBaiscTree(Block logBlock, Block leaveBlock) {
        return new OakTreeFeature(DefaultFeatureConfig::deserialize, false, 4, logBlock.getDefaultState(), leaveBlock.getDefaultState(), false);
    }
}
