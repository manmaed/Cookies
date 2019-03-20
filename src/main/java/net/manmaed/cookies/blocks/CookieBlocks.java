package net.manmaed.cookies.blocks;

import com.unrealdinnerbone.unreallib.api.RegistryHelper;
import com.unrealdinnerbone.unreallib.api.SaplingBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.lib.EnumUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.SeedsItem;
import net.minecraft.sound.BlockSoundGroup;

import static net.manmaed.cookies.items.CookieItems.ITEM_SETTINGS;

public class CookieBlocks {

    private final static Block.Settings BLOCK_CROP_SETTINGS = FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).build();
    private final static Block.Settings BLOCK_SETTINGS_CHEST = FabricBlockSettings.of(Material.WOOD).build();

    public static GingerBlockCrop gingerBlockCrop;
    public static BlockGiftBox giftBox;
    public static Item ginger;



    public static void load(RegistryHelper registry) {
        gingerBlockCrop = new GingerBlockCrop(BLOCK_CROP_SETTINGS);
        giftBox = new BlockGiftBox(BLOCK_SETTINGS_CHEST);
        registry.registerBlock(gingerBlockCrop, "ginger_crop");
        registry.registerBlockWithItem(giftBox, ITEM_SETTINGS, "giftbox");
        ginger = registry.registerItem(new SeedsItem(gingerBlockCrop, ITEM_SETTINGS), "ginger");
//        registry.registerBlockWithItem(new SaplingBlock(Cookies.worldGenTree, BLOCK_CROP_SETTINGS), ITEM_SETTINGS, "sapling_block");
    }

    public enum Blocks {
        ORANGE_LEAVE,
        ORANGE_LOG,
        ORANGE_WOOD;

        Block block;

        Blocks() {
//            this.block = new Block(EnumUtil.getNameOfEnum(this), );
        }
    }
}
