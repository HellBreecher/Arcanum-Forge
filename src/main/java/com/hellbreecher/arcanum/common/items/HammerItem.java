package com.hellbreecher.arcanum.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HammerItem extends Item {
    
	public HammerItem() {
    	super(new Item.Properties()
    			.stacksTo(1)
    			.durability(25)
    			);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return true;
    }
/** TODO: Fix Leave in Craftin Table
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
*/
}
