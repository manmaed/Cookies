package net.manmaed.cookies.blocks;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.blocks.tile.TileEntityGiftBox;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by manmaed on 30/01/2019.
 */
public class BlockGiftBox extends BlockContainer {

    public BlockGiftBox() {
        super(Material.WOOD);
        setTranslationKey("giftboxblock");
        setCreativeTab(Cookies.tabsCookies);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGiftBox();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return super.hasTileEntity(state);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

   /* @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0D,0D,0D,0D,0D,0D);
        //(up/down left/right f/b , x y f/b);
    }*/

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return new AxisAlignedBB(1D,1D,1D,1D,1D,1D);
    }
}
