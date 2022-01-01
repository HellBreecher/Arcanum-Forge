package com.hellbreecher.arcanum.common.items;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BaseItem extends Item{

	public BaseItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.stacksTo(64)
				);
	}

    public int getBurnTime(ItemStack itemStack) {
        if (itemStack.getItem() == ArcanumItems.greensapphirecoal.get()) {
            return 6400;
        }
        return 0;
    }
	
}
