package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class itemArcWrench extends Item {
	
	//TODO: Figure out block rotation
	
    public itemArcWrench() {
        super(new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World worldIn = context.getWorld();
        BlockPos pos = new BlockPos(context.getPos());
        Block block = worldIn.getBlockState(pos).getBlock();
        if (!worldIn.isRemote) {
            if(block!= Blocks.AIR) {
            	block.getDefaultState().getBlockState().rotate(worldIn, pos, Rotation.CLOCKWISE_90);
            }

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }
}
