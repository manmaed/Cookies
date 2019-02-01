package net.manmaed.cookies.blocks;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.entity.tile.TEGiftBoxEntity;
import net.manmaed.cookies.libs.Textures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieBlocks {
    public static BlockCrops gingerBlock;
    public static Block giftBox;

    public static void load(){
        gingerBlock = new BlockGinger();
        giftBox = new TEGiftBox();

        Cookies.getRegistryHelper().registerBlock(gingerBlock);
        Cookies.getRegistryHelper().registerBlock(giftBox);
        GameRegistry.registerTileEntity(TEGiftBoxEntity.class, Textures.GIFT_BOX);

        gingerBlock.setRegistryName("gingerBlock");
        giftBox.setRegistryName("giftboxblock");

    }
}
