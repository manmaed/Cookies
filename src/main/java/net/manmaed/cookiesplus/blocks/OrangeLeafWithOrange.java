package net.manmaed.cookiesplus.blocks;

import net.manmaed.cookiesplus.Cookies;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by manmaed on 19/02/2019.
 */
public class OrangeLeafWithOrange extends BlockLeaves {

    public OrangeLeafWithOrange(String name){
        setCreativeTab(Cookies.tabsCookies);
        setTranslationKey (name);
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
    }
}
