package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class ToastItem extends Item{

	public ToastItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.food(new Food.Builder()
						.nutrition(10)
						.saturationMod(10.0F)
						.build()
					)
				);
	}

	public UseAction getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAction.DRINK : UseAction.NONE;
	}
	
}
