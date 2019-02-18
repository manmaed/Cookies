package net.manmaed.cookies.tile;

import net.manmaed.cookies.Cookies;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CookieBlockEntities {
    public static BlockEntityType<BlockEntityGiftBox> GIFT_BOX = BlockEntityType.Builder.create(BlockEntityGiftBox::new).build(null);

    public static void init() {
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(Cookies.MOD_ID, "gift_box"), GIFT_BOX);
    }

}
