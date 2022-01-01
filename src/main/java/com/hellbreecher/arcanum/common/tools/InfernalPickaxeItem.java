package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfernalPickaxeItem extends PickaxeItem {

    public InfernalPickaxeItem() {
        super(EnumToolMaterial.InfernalTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum).defaultDurability(-1));
    }
    
    public ActionResultType useOn(ItemUseContext context) {
    	BlockItemUseContext BlockContext = new BlockItemUseContext(context);
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState regTorch = ArcanumBlocks.greensapphiretorch_block_item.get().getBlock().getStateForPlacement(BlockContext);  
        BlockState wallTorch = ArcanumBlocks.wall_greensapphiretorch_block.get().getBlock().getStateForPlacement(BlockContext);
        BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
        if (world.isClientSide) {
        	if(context.getClickedFace() == context.getClickedFace().UP || context.getClickedFace() == context.getClickedFace().DOWN) world.setBlock(blockpos1, regTorch, 1);
        	else world.setBlock(blockpos1, wallTorch, 1);
        	return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
        	return ActionResultType.FAIL;
        }
     }
/**
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Random rand = worldIn.rand;
        Block block = state.getBlock();
        ItemStack preSmelt = new ItemStack(block.asItem());
        ItemStack postSmelt = ((IRecipe<ISidedInventory>) recipe).getCraftingResult(this);
        float exp = stack.getItem().getSmeltingExperience(stack) * 5.0F;
        if (!worldIn.isRemote && block.isToolEffective(state, ToolType.PICKAXE)) {
            if (postSmelt.getItem() != null && postSmelt.getItem() != preSmelt.getItem() && postSmelt.getItem() != Items.REDSTONE) {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(postSmelt.getItem(), 10);
                Minecraft.getMinecraftGame().player.addExperience((int) exp);
            } else if (block == Blocks.LAPIS_ORE || block == Blocks.REDSTONE_ORE) {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(block.getItemDropped(state, rand, 0), 10);
                Minecraft.getMinecraftGame().player.addExperience((int) exp);
            } else {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(preSmelt.getItem(), block.quantityDropped(state, 0, rand));
            }
        } else if (!worldIn.isRemote) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(preSmelt.getItem(), block.quantityDropped(state, 0, rand));
        } else {
            return false;
        }
        return false;
    }*/

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }
}
