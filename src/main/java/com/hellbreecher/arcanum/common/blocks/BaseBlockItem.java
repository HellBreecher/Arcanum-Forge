package com.hellbreecher.arcanum.common.blocks;

import org.jetbrains.annotations.Nullable;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.core.ArcanumBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class BaseBlockItem extends BlockItem {

	public BaseBlockItem(Block blockIn) {
		super(blockIn, new Item.Properties().tab(Arcanum.arcanum));
	}

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (itemStack.getItem() == ArcanumBlocks.greensapphirecoal_block_item.get()) {
            return 57600;
        }
        else return 0;
    }
	
}
