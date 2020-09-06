package com.hellbreecher.arcanum.common.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArcanumItemGroup extends ItemGroup{

	public ArcanumItemGroup() {
		super("Arcanum");
	}

	public ItemStack createIcon() {
		return new ItemStack(ArcanumItems.infernaldiamond.get());
	}

}
