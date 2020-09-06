package com.hellbreecher.arcanum.common.items;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemHammer extends Item {
    public itemHammer() {
    	super(new Item.Properties()
    			.group(Arcanum.arcanum)
    			.maxStackSize(1)
    			);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack newStack = stack.copy();
        return newStack;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
