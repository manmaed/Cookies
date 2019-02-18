package net.manmaed.cookiesplus.blocks;

import net.manmaed.cookiesplus.libs.Reference;
import net.manmaed.cookiesplus.libs.RegistryHelper;
import net.manmaed.cookiesplus.tile.TileEntityGiftBox;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieBlocks {
    public static BlockCrops gingerBlock;
    public static Block giftBox;

    public static void load() {
        gingerBlock = new BlockGinger();
        giftBox = new BlockGiftBox();

        RegistryHelper.registerBlock(gingerBlock, "gingerblock");
        RegistryHelper.registerBlock(giftBox, "giftbox");

        GameRegistry.registerTileEntity(TileEntityGiftBox.class, new ResourceLocation(Reference.MOD_ID, "giftbox"));


    }
}
