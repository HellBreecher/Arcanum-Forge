package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ArcWrenchItem extends Item {
	
    public ArcWrenchItem() {
        super(new Item.Properties().tab(Arcanum.arcanum).stacksTo(1));
    }

    public ActionResultType useOn(ItemUseContext context) {
        BlockState block = context.getLevel().getBlockState(context.getClickedPos());
        PlayerEntity player = context.getPlayer();
        IWorld world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState newBlock = block.rotate(context.getLevel(), context.getClickedPos(), Rotation.CLOCKWISE_90);
        Block.updateOrDestroy(block, newBlock, world, pos, getEnchantmentValue());;
        player.swing(context.getHand());
        if (block == newBlock) return ActionResultType.SUCCESS;
        else return ActionResultType.FAIL;
    }
    
}
