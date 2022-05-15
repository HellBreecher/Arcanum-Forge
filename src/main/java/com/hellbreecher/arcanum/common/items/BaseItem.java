package com.hellbreecher.arcanum.common.items;

import org.jetbrains.annotations.Nullable;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class BaseItem extends Item{

	public BaseItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.stacksTo(64)
				);
	}

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (itemStack.getItem() == ArcanumItems.greensapphirecoal.get()) {
            return 6400;
        }
        return 0;
    }
	
}
