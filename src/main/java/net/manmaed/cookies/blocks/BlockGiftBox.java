package net.manmaed.cookies.blocks;

import com.unrealdinnerbone.unreallib.api.BlockWithContainerBox;
import net.manmaed.cookies.container.CookieContainers;
import net.manmaed.cookies.tile.BlockEntityGiftBox;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.EntityContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;

public class BlockGiftBox extends BlockWithContainerBox<BlockEntityGiftBox> implements Waterloggable {

    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape BOUNDING_BOX = VoxelShapes.union(Block.createCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 5.0D, 13.5D), Block.createCuboidShape(1.5D, 5.0D, 1.5D, 14.5D, 8.0D, 14.5D));

    public BlockGiftBox(Block.Settings settings) {
        super(settings, CookieContainers.COOKIE, BlockEntityGiftBox.class);
        this.setDefaultState(this.stateFactory.getDefaultState().with(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return BOUNDING_BOX;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState, Direction direction_1, BlockState blockState_2, IWorld world, BlockPos blockPos, BlockPos blockPos_2) {
        if (blockState.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(blockPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(blockState, direction_1, blockState_2, world, blockPos, blockPos_2);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
       return blockState.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(blockState);

    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED);
    }

    @Override
    public boolean hasDynamicBounds() {
        return true;
    }
}
