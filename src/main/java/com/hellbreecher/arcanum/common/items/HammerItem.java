package com.hellbreecher.arcanum.common.items;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HammerItem extends Item {
    
	public HammerItem() {
    	super(new Item.Properties()
    			.tab(Arcanum.arcanum)
    			.stacksTo(1)
    			.durability(25)
    			);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack damageStack = stack.copy();
        damageStack.setDamageValue(damageStack.getDamageValue() + 1);
        System.out.println(stack.getDamageValue() + "over" + damageStack.getDamageValue());
    	if(damageStack.getDamageValue() < 25) return damageStack;
    	else return ItemStack.EMPTY;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
