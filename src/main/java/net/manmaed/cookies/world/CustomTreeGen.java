package net.manmaed.cookies.world;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class CustomTreeGen extends AbstractTreeFeature<DefaultFeatureConfig> {

    protected final int height;
    private final BlockState log;
    private final BlockState leaves;

    public CustomTreeGen(Function<Dynamic<?>, ? extends DefaultFeatureConfig> dynamicFunction, boolean emitNeighborBlockUpdates, int int_1, BlockState log, BlockState leaves) {
        super(dynamicFunction, emitNeighborBlockUpdates);
        this.height = int_1;
        this.log = log;
        this.leaves = leaves;
    }

    public boolean generate(Set<BlockPos> blockPosSet, ModifiableTestableWorld modifiableTestableWorld, Random random, BlockPos blockPos) {
        int int_1 = this.getTreeHeight(random);
        boolean boolean_1 = true;
        if (blockPos.getY() >= 1 && blockPos.getY() + int_1 + 1 <= 256) {
            int int_9;
            int int_18;
            for (int int_2 = blockPos.getY(); int_2 <= blockPos.getY() + 1 + int_1; ++int_2) {
                int int_3 = 1;
                if (int_2 == blockPos.getY()) {
                    int_3 = 0;
                }

                if (int_2 >= blockPos.getY() + 1 + int_1 - 2) {
                    int_3 = 2;
                }

                BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();

                for (int_9 = blockPos.getX() - int_3; int_9 <= blockPos.getX() + int_3 && boolean_1; ++int_9) {
                    for (int_18 = blockPos.getZ() - int_3; int_18 <= blockPos.getZ() + int_3 && boolean_1; ++int_18) {
                        if (int_2 >= 0 && int_2 < 256) {
                            if (!canTreeReplace(modifiableTestableWorld, blockPos$Mutable_1.set(int_9, int_2, int_18))) {
                                boolean_1 = false;
                            }
                        } else {
                            boolean_1 = false;
                        }
                    }
                }
            }

            if (!boolean_1) {
                return false;
            } else if (isDirtOrGrass(modifiableTestableWorld, blockPos.down()) && blockPos.getY() < 256 - int_1 - 1) {
                this.setToDirt(modifiableTestableWorld, blockPos.down());

                int int_19;
                int int_20;
                BlockPos blockPos_4;
                int int_21;
                for (int_21 = blockPos.getY() - 3 + int_1; int_21 <= blockPos.getY() + int_1; ++int_21) {
                    int_9 = int_21 - (blockPos.getY() + int_1);
                    int_18 = 1 - int_9 / 2;

                    for (int int_11 = blockPos.getX() - int_18; int_11 <= blockPos.getX() + int_18; ++int_11) {
                        int_19 = int_11 - blockPos.getX();

                        for (int_20 = blockPos.getZ() - int_18; int_20 <= blockPos.getZ() + int_18; ++int_20) {
                            int int_14 = int_20 - blockPos.getZ();
                            if (Math.abs(int_19) != int_18 || Math.abs(int_14) != int_18 || random.nextInt(2) != 0 && int_9 != 0) {
                                blockPos_4 = new BlockPos(int_11, int_21, int_20);
                                if (isAirOrLeaves(modifiableTestableWorld, blockPos_4) || isReplaceablePlant(modifiableTestableWorld, blockPos_4)) {
                                    this.setBlockState(modifiableTestableWorld, blockPos_4, this.leaves);
                                }
                            }
                        }
                    }
                }
                for(int_21 = 0; int_21 < int_1; ++int_21) {
                    if (isAirOrLeaves(modifiableTestableWorld, blockPos.up(int_21)) || isReplaceablePlant(modifiableTestableWorld, blockPos.up(int_21))) {
                        this.setBlockState(blockPosSet,modifiableTestableWorld, blockPos.up(int_21), this.log);
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected int getTreeHeight(Random random_1)
    {
        return this.height + random_1.nextInt(3);
    }

}
