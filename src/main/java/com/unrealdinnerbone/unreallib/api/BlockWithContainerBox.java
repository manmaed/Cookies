package com.unrealdinnerbone.unreallib.api;

import com.unrealdinnerbone.unreallib.api.container.IContainer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class BlockWithContainerBox<T extends BlockEntity> extends BlockWithEntity {

    private final IContainer iContainer;
    private final Class<T> blockEntityClass;

    public BlockWithContainerBox(Settings settings, IContainer iContainer, Class<T> blockEntityClass) {
        super(settings);
        this.iContainer = iContainer;
        this.blockEntityClass = blockEntityClass;
    }

    @Override
    public boolean activate(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult) {
        if(!world.isClient) {
            T blockEntity = getBlockEntity(world.getBlockEntity(blockPos));
            if (blockEntity != null) {
                ContainerProviderRegistry.INSTANCE.openContainer(iContainer.getID(), playerEntity, byteBuf -> iContainer.write(byteBuf, blockState, world, blockPos, playerEntity, hand, hitResult));
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public T createBlockEntity(BlockView var1) {
        try {
            return blockEntityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBlockRemoved(BlockState blockState_1, World world, BlockPos blockPos, BlockState blockState_2, boolean boolean_1) {
        if (blockState_1.getBlock() != blockState_2.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(blockPos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, blockPos, (Inventory) blockEntity);
                world.updateHorizontalAdjacent(blockPos, this);
            }

            super.onBlockRemoved(blockState_1, world, blockPos, blockState_2, boolean_1);
        }
    }

    public T getBlockEntity(BlockEntity blockEntity) {
        if(blockEntity != null) {
            if(blockEntity.getClass().getName().equals(blockEntityClass.getName())) {
                return ((T) blockEntity);
            }
        }
        return null;
    }

}
