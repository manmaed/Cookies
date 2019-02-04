package net.manmaed.cookies.blocks.giftbox;

import net.manmaed.cookies.Cookies;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by manmaed on 04/02/2019.
 */
public class GiftBoxContainer extends Block implements ITileEntityProvider {

    public static final  int GUI_ID = 1;

    public GiftBoxContainer() {
        super(Material.WOOD);
        setTranslationKey("testbox1");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GiftBoxContainerTileEntity();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote) {
            return true;
        }
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if(!(tileEntity instanceof GiftBoxContainerTileEntity)) {
            return false;
        }
        playerIn.openGui(Cookies.instance, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
