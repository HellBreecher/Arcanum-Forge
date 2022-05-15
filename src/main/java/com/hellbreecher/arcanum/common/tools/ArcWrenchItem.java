package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;

public class ArcWrenchItem extends Item {
	
    public ArcWrenchItem() {
        super(new Item.Properties().tab(Arcanum.arcanum).stacksTo(1));
    }

    public InteractionResult useOn(UseOnContext context) {
        BlockState block = context.getLevel().getBlockState(context.getClickedPos());
        Player player = context.getPlayer();
        LevelAccessor level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState newBlock = block.rotate(level, context.getClickedPos(), Rotation.CLOCKWISE_90);
        Block.updateOrDestroy(block, newBlock, context.getLevel(), pos, getEnchantmentValue());;
        player.swing(context.getHand());
        if (block == newBlock) return InteractionResult.SUCCESS;
        else return InteractionResult.FAIL;
    }
    
}