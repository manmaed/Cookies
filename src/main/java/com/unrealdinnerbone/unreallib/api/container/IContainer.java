package com.unrealdinnerbone.unreallib.api.container;

import net.fabricmc.fabric.api.container.ContainerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.ContainerScreen;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IContainer {
    Identifier getID();

    void write(PacketByteBuf byteBuf, BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult);

    ContainerFactory<Container> getContainer();

    ContainerFactory<ContainerScreen> getGuiCon();

}
