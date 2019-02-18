package net.manmaed.cookies.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.items.Ginger;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.manmaed.cookies.items.CookieItems.ITEM_SETTINGS;

public class CookieBlocks {

    private final static Block.Settings BLOCK_CROP_SETTINGS = FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).build();
    private final static Block.Settings BLOCK_SETTINGS_CHEST = FabricBlockSettings.of(Material.WOOD).build();

    public static GingerBlockCrop gingerBlockCrop;
    public static BlockGiftBox giftBox;
    public static Item ginger;


    public static void load() {
        gingerBlockCrop = new GingerBlockCrop(BLOCK_CROP_SETTINGS );
        giftBox = new BlockGiftBox(BLOCK_SETTINGS_CHEST);


        Registry.register(Registry.BLOCK, new Identifier(Cookies.MOD_ID, "ginger_crop"), gingerBlockCrop);
        Registry.register(Registry.BLOCK, new Identifier(Cookies.MOD_ID, "giftbox"), giftBox);

        ginger = new Ginger(ITEM_SETTINGS);
        Registry.register(Registry.ITEM, new Identifier(Cookies.MOD_ID, "ginger"), ginger);

        Registry.register(Registry.ITEM, new Identifier(Cookies.MOD_ID, "giftbox"), new BlockItem(giftBox, CookieItems.ITEM_SETTINGS));
//        RegistryHelper.registerBlock(gingerBlock, "gingerBlock");
//        RegistryHelper.registerBlock(giftBox, "giftbox");
//
//        GameRegistry.registerTileEntity(BlockEntityGiftBox.class, new ResourceLocation(Reference.MOD_ID, "giftbox"));
    }
}
