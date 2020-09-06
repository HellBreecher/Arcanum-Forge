package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class itemToast extends Item{

	public itemToast() {
		super(new Item.Properties()
				.group(Arcanum.arcanum)
				.food(new Food.Builder()
						.hunger(10)
						.saturation(10.0F)
						.build()
					)
				);
	}

}
