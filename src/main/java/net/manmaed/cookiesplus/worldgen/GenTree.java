package net.manmaed.cookiesplus.worldgen;

import net.manmaed.cookiesplus.blocks.CookieBlocks;
import net.manmaed.cookiesplus.libs.LogHelper;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

/**
 * Created by manmaed on 20/02/2019.
 */
public class GenTree extends WorldGenAbstractTree {

    public static GenTree INSTANCE = new GenTree(true);

    private IBlockState blockStateWood = CookieBlocks.orangelog.getDefaultState();
    private IBlockState blockStateLeaves = CookieBlocks.orangeleaf.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    /** The minimum height of a generated tree. */
    private final int minTreeHeight = 4;

    public GenTree(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        int minHeight = rand.nextInt(3) + minTreeHeight;

        // Check if tree fits in world
        if (position.getY() >= 1 && position.getY() + minHeight + 1 <= worldIn.getHeight())
        {
            if (!isSuitableLocation(worldIn, position, minHeight))
            {
                return false;
            }
            else
            {
                IBlockState state = worldIn.getBlockState(position.down());

                if (state.getBlock().canSustainPlant(state, worldIn, position.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && position.getY() < worldIn.getHeight() - minHeight - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
                    LogHelper.info("Tree: " + position);
                    generateLeaves(worldIn, position, minHeight, rand);
                    generateTrunk(worldIn, position, minHeight);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    private void generateLeaves(World worldIn, BlockPos position, int height, Random rand)
    {
        for (int foliageY = position.getY() - 3 + height; foliageY <= position.getY() + height; ++foliageY)
        {
            int foliageLayer = foliageY - (position.getY() + height);
            int foliageLayerRadius = 1 - foliageLayer / 2;

            for (int foliageX = position.getX() - foliageLayerRadius; foliageX <= position.getX() + foliageLayerRadius; ++foliageX)
            {
                int foliageRelativeX = foliageX - position.getX();

                for (int foliageZ = position.getZ() - foliageLayerRadius; foliageZ <= position.getZ() + foliageLayerRadius; ++foliageZ)
                {
                    int foliageRelativeZ = foliageZ - position.getZ();

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || rand.nextInt(2) != 0 && foliageLayer != 0)
                    {
                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState state = worldIn.getBlockState(blockPos);

                        if (state.getBlock().isAir(state, worldIn, blockPos) || state.getBlock().isLeaves(state, worldIn, blockPos))
                        {
                            setBlockAndNotifyAdequately(worldIn, blockPos, blockStateLeaves);
                        }
                    }
                }
            }
        }
    }

    private void generateTrunk(World worldIn, BlockPos position, int minHeight)
    {
        for (int height = 0; height < minHeight; ++height)
        {
            BlockPos upN = position.up(height);
            IBlockState state = worldIn.getBlockState(upN);

            if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN))
            {
                setBlockAndNotifyAdequately(worldIn, position.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
            }
        }
    }

    private boolean isSuitableLocation(World worldIn, BlockPos position, int minHeight)
    {
        boolean isSuitableLocation = true;

        for (int checkY = position.getY(); checkY <= position.getY() + 1 + minHeight; ++checkY)
        {
            // Handle increasing space towards top of tree
            int extraSpaceNeeded = 1;
            // Handle base location
            if (checkY == position.getY())
            {
                extraSpaceNeeded = 0;
            }
            // Handle top location
            if (checkY >= position.getY() + 1 + minHeight - 2)
            {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = position.getX() - extraSpaceNeeded; checkX <= position.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX)
            {
                for (int checkZ = position.getZ() - extraSpaceNeeded; checkZ <= position.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ)
                {
                    isSuitableLocation = isReplaceable(worldIn,blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;
    }
}
