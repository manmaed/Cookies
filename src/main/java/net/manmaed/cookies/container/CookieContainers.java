package net.manmaed.cookies.container;

import com.unrealdinnerbone.unreallib.api.container.IContainer;
import net.fabricmc.fabric.api.container.ContainerFactory;
import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.client.gui.GUICookieContainer;
import net.manmaed.cookies.tile.BlockEntityGiftBox;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.ContainerScreen;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public enum CookieContainers implements IContainer
{
    COOKIE("cookies", BlockEntityGiftBox.class, CookieContainer.class, () -> GUICookieContainer.class);

    private final Identifier name;
    private final Class<? extends BlockEntity> blockEntityClass;
    private final Class<? extends Container> cookieContainerClass;
    private final Supplier<Class<GUICookieContainer>> guiCookieContainerClass;

    CookieContainers(String name, Class<? extends BlockEntity> blockEntityClass, Class<? extends Container> cookieContainerClass, Supplier<Class<GUICookieContainer>> guiCookieContainerClass) {
        this.name = new Identifier(Cookies.MOD_ID, name);
        this.blockEntityClass = blockEntityClass;
        this.cookieContainerClass = cookieContainerClass;
        this.guiCookieContainerClass = guiCookieContainerClass;
    }


    @Override
    public Identifier getID() {
        return name;
    }

    @Override
    public void write(PacketByteBuf byteBuf, BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult) {
        byteBuf.writeBlockPos(blockPos);
    }

    @Override
    public ContainerFactory<Container> getContainer() {
        return (syncId, identifier, player, buf) -> {
            BlockPos blockPos = buf.readBlockPos();
            BlockEntity blockEntity = player.world.getBlockEntity(blockPos);
            BlockEntity blockEntity1 = getBlockEntity(blockEntity);
            if (blockEntity1 != null) {
                try {
                    return cookieContainerClass.getDeclaredConstructor(Integer.class, PlayerEntity.class, Inventory.class).newInstance(syncId, player, blockEntity1);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            return null;
        };
    }

    @Override
    public ContainerFactory<ContainerScreen> getGuiCon() {
        return (syncId, identifier, player, buf) -> {
            Container container = getContainer().create(syncId, identifier, player, buf);
            try {
                return guiCookieContainerClass.get().getDeclaredConstructor(container.getClass()).newInstance(container);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        };
    }


    public <T extends BlockEntity> T getBlockEntity(BlockEntity blockEntity) {
        if(blockEntity != null) {
            if(blockEntity.getClass().getName().equals(blockEntityClass.getName())) {
                return ((T) blockEntity);
            }
        }
        return null;
    }
}
