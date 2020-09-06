package com.hellbreecher.arcanum.common.blocks;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class blockItemBase extends BlockItem {

	public blockItemBase(Block blockIn) {
		super(blockIn, new Item.Properties().group(Arcanum.arcanum));
	}

    public int getBurnTime(ItemStack itemStack) {
        if (itemStack.getItem() == ArcanumBlocks.greensapphirecoal_block_item.get()) {
            return 57600;
        }
        else return 0;
    }
	
}
