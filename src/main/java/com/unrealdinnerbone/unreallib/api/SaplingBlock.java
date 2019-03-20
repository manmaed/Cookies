package com.unrealdinnerbone.unreallib.api;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.IntegerProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;

public class SaplingBlock extends PlantBlock implements Fertilizable {

    public static final IntegerProperty STAGE = Properties.SAPLING_STAGE;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final SaplingGenerator generator;

    public SaplingBlock(AbstractTreeFeature<DefaultFeatureConfig> defaultFeatureConfigAbstractTreeFeature, Block.Settings blockSettings) {
        super(blockSettings);
        this.generator = new SaplingGenerator() {
            @Override
            protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random var1) {
                return defaultFeatureConfigAbstractTreeFeature;
            }
        };
        this.setDefaultState(this.stateFactory.getDefaultState().with(STAGE, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
        return SHAPE;
    }

    @Override
    public void onScheduledTick(BlockState blockState, World world, BlockPos blockPos, Random random) {
        super.onScheduledTick(blockState, world, blockPos, random);
        if (world.getLightLevel(blockPos.up()) >= 9 && random.nextInt(7) == 0) {
            this.generate(world, blockPos, blockState, random);
        }
    }

    public void generate(IWorld world, BlockPos blockPos, BlockState blockState, Random random) {
        if (blockState.get(STAGE) == 0) {
            world.setBlockState(blockPos, blockState.method_11572(STAGE), 4);
        } else {
            this.generator.generate(world, blockPos, blockState, random);
        }

    }

    public boolean isFertilizable(BlockView blockView, BlockPos blockPos, BlockState blockState, boolean isClient) {
        return true;
    }

    public boolean canGrow(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return (double) world.random.nextFloat() < 0.45D;
    }

    public void grow(World world, Random random, BlockPos blockPos, BlockState blockState) {
        this.generate(world, blockPos, blockState, random);
    }

    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.with(STAGE);
    }
}