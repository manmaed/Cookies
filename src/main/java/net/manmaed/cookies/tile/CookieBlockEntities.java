package net.manmaed.cookies.tile;

import com.unrealdinnerbone.unreallib.api.registry.IRegistryItem;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public enum CookieBlockEntities implements IRegistryItem<BlockEntityType<?>> {

    GIFT_BOX(BlockEntityGiftBox.class);

    private BlockEntityType<?> blockEntityType;

    CookieBlockEntities(Class<? extends BlockEntity> blockEntityType) {
        this.blockEntityType = BlockEntityType.Builder.create(() -> createInstance(blockEntityType)).build(null);
    }

    public static <T> T createInstance(Class<T> classInstance) {
        try {
            return classInstance.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public BlockEntityType<?> get() {
        return blockEntityType;
    }
}
