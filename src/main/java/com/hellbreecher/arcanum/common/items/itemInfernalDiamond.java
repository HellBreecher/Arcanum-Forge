package com.hellbreecher.arcanum.common.items;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.enchantment.Enchantment;
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

public class itemInfernalDiamond extends Item {
    
	public itemInfernalDiamond() {
    	super(new Item.Properties()
    			.group(Arcanum.arcanum)
    			.maxStackSize(1)
    			);    	
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(20), 5);
        }
    }

    public int getBurnTime(ItemStack itemStack) {
        if (itemStack.getItem() == ArcanumItems.infernaldiamond.get()) {
            return 99999999;
        }
        return 0;
    }
    
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (CampfireBlock.func_241470_h_(blockstate)) {
           world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
           world.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
           if (playerentity != null) {
              context.getItem().damageItem(1, playerentity, (p_219999_1_) -> {
                 p_219999_1_.sendBreakAnimation(context.getHand());
              });
           }

           return ActionResultType.func_233537_a_(world.isRemote());
        } else {
           BlockPos blockpos1 = blockpos.offset(context.getFace());
           if (AbstractFireBlock.func_241465_a_(world, blockpos1, context.getPlacementHorizontalFacing())) {
              world.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
              BlockState blockstate1 = AbstractFireBlock.func_235326_a_(world, blockpos1);
              world.setBlockState(blockpos1, blockstate1, 11);
              ItemStack itemstack = context.getItem();
              if (playerentity instanceof ServerPlayerEntity) {
                 CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
                 itemstack.damageItem(1, playerentity, (p_219998_1_) -> {
                    p_219998_1_.sendBreakAnimation(context.getHand());
                 });
              }

              return ActionResultType.func_233537_a_(world.isRemote());
           } else {
              return ActionResultType.FAIL;
           }
        }
     }
}
