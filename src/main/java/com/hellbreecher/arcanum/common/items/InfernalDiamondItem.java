package com.hellbreecher.arcanum.common.items;

import org.jetbrains.annotations.Nullable;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

public class InfernalDiamondItem extends Item {
    
	public InfernalDiamondItem() {
    	super(new Item.Properties()
    			.tab(Arcanum.arcanum)
    			.stacksTo(1)
    			.fireResistant()
    			);    	
    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }

    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack newStack = stack.copy();
        return newStack;
    }
	
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (itemStack.getItem() == ArcanumItems.infernaldiamond.get()) {
            double time = Double.POSITIVE_INFINITY;
        	return (int) time;
        }
        return 0;
    }
    
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
           BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
           if (BaseFireBlock.canBePlacedAt(level, blockpos1, context.getHorizontalDirection())) {
              level.playSound(player, blockpos1, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
              BlockState blockstate1 = BaseFireBlock.getState(level, blockpos1);
              level.setBlock(blockpos1, blockstate1, 11);
              level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
              ItemStack itemstack = context.getItemInHand();
              if (player instanceof ServerPlayer) {
                 CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos1, itemstack);
                 itemstack.hurtAndBreak(1, player, (p_41300_) -> {
                    p_41300_.broadcastBreakEvent(context.getHand());
                 });
              }

              return InteractionResult.sidedSuccess(level.isClientSide());
           } else {
              return InteractionResult.FAIL;
           }
        } else {
           level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
           level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
           level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
           if (player != null) {
        	   context.getItemInHand().hurtAndBreak(1, player, (p_41303_) -> {
                 p_41303_.broadcastBreakEvent(context.getHand());
              });
           }

           return InteractionResult.sidedSuccess(level.isClientSide());
        }
     }
}
