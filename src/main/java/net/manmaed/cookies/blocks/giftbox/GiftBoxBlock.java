package net.manmaed.cookies.blocks.giftbox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by manmaed on 13/01/2019.
 */
public class GiftBoxBlock extends Block {
    public GiftBoxBlock() {
        super(Material.WOOD);
        setUnlocalizedName("giftbox");
    }

    /*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            playerIn.openGui(Cookies.instance, Reference.GUI_GIFTBOX, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
        GiftBoxTileEntity tileEntity = (GiftBoxTileEntity)world.getTileEntity(pos);
        //InventoryHelper.dropInventoryItems(world,pos);
        super.onBlockDestroyedByPlayer(world, pos, state);
    }

    *//*@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(stack.hasDisplayName()){
            TileEntity tileEntity = world.getTileEntity(pos);
            if(tileEntity instanceof GiftBoxTileEntity) {
                ((GiftBoxTileEntity)tileEntity)..setCustomName(stack.getDisplayName());
            }
        }
    }*//*

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GiftBoxTileEntity();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }*/
}
