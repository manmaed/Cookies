package net.manmaed.cookies.blocks;

import net.manmaed.cookies.blocks.giftbox.GiftBoxContainer;
import net.manmaed.cookies.blocks.giftbox.GiftBoxContainerTileEntity;
import net.manmaed.cookies.libs.Reference;
import net.manmaed.cookies.libs.RegistryHelper;
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

    public static void load(){
        gingerBlock = new BlockGinger();
        giftBox = new GiftBoxContainer();

        RegistryHelper.registerBlock(gingerBlock, "gingerBlock");
        RegistryHelper.registerBlock(giftBox, "giftbox");


       GameRegistry.registerTileEntity(GiftBoxContainerTileEntity.class, new ResourceLocation(Reference.MOD_ID, "giftbox"));


    }
}
