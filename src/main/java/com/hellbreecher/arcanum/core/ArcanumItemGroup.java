package com.hellbreecher.arcanum.core;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ArcanumItemGroup extends CreativeModeTab{

	public ArcanumItemGroup() {
		super("Arcanum");
	}

	public ItemStack makeIcon() {
		return new ItemStack(ArcanumItems.infernaldiamond.get());
	}


}
