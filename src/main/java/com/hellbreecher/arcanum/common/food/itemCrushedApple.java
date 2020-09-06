package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class itemCrushedApple extends Item {
	
	public itemCrushedApple() {
		super(new Item.Properties()
				.group(Arcanum.arcanum)
				.food(new Food.Builder()
						.hunger(2)
						.saturation(2.0F)
						.setAlwaysEdible()
						.build()
					)
				);
	}
}
