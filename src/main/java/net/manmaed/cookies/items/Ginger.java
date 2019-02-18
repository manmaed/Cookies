package net.manmaed.cookies.items;

import net.manmaed.cookies.blocks.CookieBlocks;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;

public class Ginger extends Item  {

    private final BlockState crop;

    public Ginger(Settings settings) {
        super(settings);
        this.crop = CookieBlocks.gingerBlockCrop.getDefaultState();
    }

    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        IWorld iWorld_1 = itemUsageContext_1.getWorld();
        BlockPos blockPos_1 = itemUsageContext_1.getBlockPos().up();
        if (itemUsageContext_1.getFacing() == Direction.UP && iWorld_1.isAir(blockPos_1) && this.crop.canPlaceAt(iWorld_1, blockPos_1)) {
            iWorld_1.setBlockState(blockPos_1, this.crop, 11);
//            iWorld_1.playSound((PlayerEntity)null, blockPos_1, this.field_17542, SoundCategory.BLOCK, 1.0F, 1.0F);
            ItemStack itemStack_1 = itemUsageContext_1.getItemStack();
            PlayerEntity playerEntity_1 = itemUsageContext_1.getPlayer();
            if (playerEntity_1 instanceof ServerPlayerEntity) {
                Criterions.PLACED_BLOCK.handle((ServerPlayerEntity)playerEntity_1, blockPos_1, itemStack_1);
            }

            itemStack_1.subtractAmount(1);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }
}
