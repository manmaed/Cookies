package net.manmaed.cookies.blocks;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.tile.TileEntityGiftBox;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

/**
 * Created by manmaed on 04/02/2019.
 */
//extends BlockContainer implements ITileEntityProvider
@SuppressWarnings("deprecation")
public class BlockGiftBox extends Block {

    public static final  int GUI_ID = 1;
    private static final AxisAlignedBB BOX = new AxisAlignedBB(0D, 0D, 0D, 1.0D, 0.5D, 1.0D);

    public BlockGiftBox() {
        super(Material.WOOD);
        setTranslationKey("giftbox");
        setHarvestLevel("pickaxe", 0);
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(Cookies.tabsCookies);

    }
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }


    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return BOX;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return BOX;
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof TileEntityGiftBox) {
            if(tileentity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
                IItemHandler itemHandler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                IntStream.range(0, itemHandler.getSlots()).forEach(slotCount -> InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemHandler.getStackInSlot(slotCount)));
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }
        super.breakBlock(worldIn, pos, state);
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOX;
    }
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityGiftBox();
    }

    /*@Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGiftBox();
    }*/

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof TileEntityGiftBox) {
                playerIn.openGui(Cookies.instance, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
                return true;
            }
            return false;
        }
        return true;
    }
}
