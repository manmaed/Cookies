package net.manmaed.cookies.blocks;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.tile.BlockEntityGiftBox;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventory;
import net.minecraft.sortme.ItemScatterer;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockGiftBox extends BlockWithEntity implements Waterloggable {

    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape BOUNDING_BOX = VoxelShapes.union(Block.createCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 5.0D, 13.5D), Block.createCuboidShape(1.5D, 5.0D, 1.5D, 14.5D, 8.0D, 14.5D));

    public BlockGiftBox(Block.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateFactory.getDefaultState().with(WATERLOGGED, false));

    }

    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
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
       return blockState.get(WATERLOGGED) ? Fluids.WATER.getState(false) : super.getFluidState(blockState);

    }

    @Override
    public boolean activate(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult) {
        if (world.isClient) {
            return true;
        } else {
            if(world.getBlockEntity(blockPos) instanceof BlockEntityGiftBox) {
                ContainerProviderRegistry.INSTANCE.openContainer(Cookies.CON, playerEntity, buf -> buf.writeBlockPos(blockPos));
            }
            return true;
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.with(WATERLOGGED);
    }

    @Override
    public boolean hasDynamicBounds() {
        return true;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView var1) {
        return new BlockEntityGiftBox();
    }

    @Override
    public void onBlockRemoved(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, boolean boolean_1) {
        if (blockState_1.getBlock() != blockState_2.getBlock()) {
            BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
            if (blockEntity_1 instanceof Inventory) {
                ItemScatterer.spawn(world_1, blockPos_1, (Inventory)blockEntity_1);
                world_1.updateHorizontalAdjacent(blockPos_1, this);
            }

            super.onBlockRemoved(blockState_1, world_1, blockPos_1, blockState_2, boolean_1);
        }
    }
}
