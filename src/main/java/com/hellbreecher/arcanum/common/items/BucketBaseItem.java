package com.hellbreecher.arcanum.common.items;

import java.util.function.Supplier;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;

public class BucketBaseItem extends BucketItem {

	public BucketBaseItem(Supplier<? extends Fluid> supplier, Properties builder) {
		super(supplier, new Item.Properties()
				.tab(Arcanum.arcanum)
				.stacksTo(1));
	}

}
