package net.manmaed.cookiesplus.blocks;

import net.manmaed.cookiesplus.libs.Reference;
import net.manmaed.cookiesplus.libs.RegistryHelper;
import net.manmaed.cookiesplus.tile.TileEntityGiftBox;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieBlocks {
    public static BlockCrops gingerBlock;
    public static Block giftBox;

    //Tree
    public static BlockLeaves orangeleaf;
    public static CBB orangeplank;
    public static CBB orangelog;

    public static void load() {
        gingerBlock = new BlockGinger();
        giftBox = new BlockGiftBox();
        /*orangeleaf = new OrangeLeaf("Leaf");*/
        orangeplank = new CBB("plank_orange", Material.WOOD,3F,5F, "axe", 0);
        orangelog = new CBB("log_orange", Material.WOOD,3F,5F, "axe", 0);

        RegistryHelper.registerBlock(gingerBlock, "gingerblock");
        RegistryHelper.registerBlock(giftBox, "giftbox");

        RegistryHelper.registerBlock(orangelog, "log_orange");
        RegistryHelper.registerBlock(orangeplank, "plank_orange");

        GameRegistry.registerTileEntity(TileEntityGiftBox.class, new ResourceLocation(Reference.MOD_ID, "giftbox"));


    }
}
