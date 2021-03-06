package net.manmaed.cookiesplus.items;

import net.manmaed.cookiesplus.Cookies;
import net.manmaed.cookiesplus.blocks.CookieBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
 * Created by manmaed on 05/02/2019.
 */
public class Ginger extends Item implements IPlantable {
    public Ginger() {
        super();
        setTranslationKey("ginger");
        setCreativeTab(Cookies.tabsCookies);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        if(facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP ,this) && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), CookieBlocks.gingerBlock.getDefaultState());
            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else return EnumActionResult.FAIL;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return CookieBlocks.gingerBlock.getDefaultState();
    }
}
