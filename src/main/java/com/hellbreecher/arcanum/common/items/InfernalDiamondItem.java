package com.hellbreecher.arcanum.common.items;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfernalDiamondItem extends Item {
    
	public InfernalDiamondItem() {
    	super(new Item.Properties()
    			.tab(Arcanum.arcanum)
    			.stacksTo(1)
    			);    	
    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }

    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack newStack = stack.copy();
        return newStack;
    }
	
    public int getBurnTime(ItemStack itemStack) {
        if (itemStack.getItem() == ArcanumItems.infernaldiamond.get()) {
            double time = Double.POSITIVE_INFINITY;
        	return (int) time;
        }
        return 0;
    }
    
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (!CampfireBlock.isLitCampfire(blockstate)) {
           world.playSound(playerentity, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
           world.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
           return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
           BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
           if (AbstractFireBlock.canBePlacedAt(world, blockpos1, context.getHorizontalDirection())) {
              world.playSound(playerentity, blockpos1, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
              BlockState blockstate1 = AbstractFireBlock.getState(world, blockpos1);
              world.setBlock(blockpos1, blockstate1, 11);
              ItemStack itemstack = context.getItemInHand();
              if (playerentity instanceof ServerPlayerEntity) {
                 CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
              }

              return ActionResultType.sidedSuccess(world.isClientSide);
           } else {
              return ActionResultType.FAIL;
           }
        }
     }
}
