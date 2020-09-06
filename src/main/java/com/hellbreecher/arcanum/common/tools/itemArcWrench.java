package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Item;

public class itemArcWrench extends Item {

    public itemArcWrench() {
        super(new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
    }

    //TODO: Arc Wrench rotation capability
    /**
    public EnumActionResult onItemUseFirst(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        int direction = MathHelper.floor(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        Block block = worldIn.getBlockState(pos).getBlock();
        if (!worldIn.isRemote) {
            if (direction == 0) {
                block.rotateBlock(worldIn, pos, EnumFacing.UP);
            }
            if (direction == 1) {
                block.rotateBlock(worldIn, pos, EnumFacing.DOWN);
            }
            if (direction == 2) {
                block.rotateBlock(worldIn, pos, EnumFacing.SOUTH);
            }
            if (direction == 3) {
                block.rotateBlock(worldIn, pos, EnumFacing.NORTH);
            }
            if (direction == 4) {
                block.rotateBlock(worldIn, pos, EnumFacing.EAST);
            }
            if (direction == 5) {
                block.rotateBlock(worldIn, pos, EnumFacing.WEST);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
    */
}
