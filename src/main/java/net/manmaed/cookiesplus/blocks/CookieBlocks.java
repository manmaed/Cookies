package net.manmaed.cookiesplus.blocks;

import net.manmaed.cookiesplus.libs.Reference;
import net.manmaed.cookiesplus.libs.RegistryHelper;
import net.manmaed.cookiesplus.tile.TileEntityGiftBox;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieBlocks {
    public static BlockCrops gingerBlock;
    public static Block giftBox;

    //Tree
    public static BlockLeaves orangeleaf;
    public static CBB orangeplank;
    public static BlockLog orangelog;
    public static BlockBush orangesapling;

    public static void load() {
        gingerBlock = new BlockGinger();
        giftBox = new BlockGiftBox();
        orangeleaf = new OrangeLeaf("leaves_orange");
        orangeplank = new CBB("plank_orange", Material.WOOD,3F,5F, "axe", 0, SoundType.WOOD);
        orangelog = new OrangeLog("log_orange");
        orangesapling = new OrangeSapling("sapling_orange");

        Blocks.FIRE.setFireInfo(orangeleaf, 8, 30);
        Blocks.FIRE.setFireInfo(orangeplank, 3, 10);
        Blocks.FIRE.setFireInfo(orangelog, 6, 20);


        RegistryHelper.registerBlock(gingerBlock, "gingerblock");
        RegistryHelper.registerBlock(giftBox, "giftbox");

        //Tree
        RegistryHelper.registerBlock(orangelog, "log_orange");
        RegistryHelper.registerBlock(orangeplank, "plank_orange");
        RegistryHelper.registerBlock(orangeleaf, "leaves_orange");
        RegistryHelper.registerBlock(orangesapling, "sapling_orange");

        OreDictionary.registerOre("logWood", orangelog);
        OreDictionary.registerOre("plankWood", orangeplank);
        OreDictionary.registerOre("treeLeaves", orangeleaf);
        OreDictionary.registerOre("sapling_orange", orangesapling);

        GameRegistry.registerTileEntity(TileEntityGiftBox.class, new ResourceLocation(Reference.MOD_ID, "giftbox"));


    }
}
