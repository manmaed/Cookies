package net.manmaed.cookies.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemProvider;
import net.manmaed.cookies.items.CookieItems;

public class BlockGingerCrop extends CropBlock {

    public BlockGingerCrop(Block.Settings settings) {
        super(settings);
    }


//    @Override
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        tooltip.add("This is not the Ginger you are looking for!");
//    }
//
//    @Override
//    protected Item getSeed() {
//        return CookieItems.ginger;
//    }

    @Override
    protected ItemProvider getCropItem() {
        return () -> CookieItems.ginger;
    }

    protected Item getCrop() {
        return CookieItems.ginger;
    }

//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
//        return ginger[state.getValue(this.getAgeProperty())];
//    }
}
