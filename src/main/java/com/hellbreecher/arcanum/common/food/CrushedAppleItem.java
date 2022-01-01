package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class CrushedAppleItem extends Item {
	
	public CrushedAppleItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.food(new Food.Builder()
						.nutrition(2)
						.saturationMod(2.0F)
						.alwaysEat()
						.build()
					)
				);
	}
	
	public UseAction getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAction.EAT : UseAction.NONE;
	}
}
