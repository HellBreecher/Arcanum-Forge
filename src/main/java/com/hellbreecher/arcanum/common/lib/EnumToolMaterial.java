package com.hellbreecher.arcanum.common.lib;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

public enum EnumToolMaterial implements IItemTier{
	
	GreenSapphireTool(5, 1500, 10.0F, 10.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.greensapphire.get());}),
	BloodDiamondTool(8, 3000, 20.0F, 50.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.blooddiamond.get());}),
	VoidDiamondTool(10, 6000, 50.0F, 75.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.voiddiamond.get());}),
	InfernalDiamondTool(12, 8000, 100.0F, 100.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.infernaldiamond.get());}),
	InfernalTool(9999, 1, 500.0F, 100000F, 30, () -> {return Ingredient.fromItems(ArcanumItems.infernaldiamond.get());}),
	
	SapphireBeatingStick(0, 1500, 0.0F, 10.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.greensapphire.get());}),
	BloodDiamondBeatingStick(0, 2000, 0.0F, 25.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.blooddiamond.get());}),
	VoidDiamondBeatingStick(0, 2500, 0.0F, 50.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.voiddiamond.get());}),
	InfernalBeatingStick(0, 3000, 0.0F, 100.0F, 30, () -> {return Ingredient.fromItems(ArcanumItems.infernaldiamond.get());});


	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairMaterial;
	
	EnumToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}
	
	public int getMaxUses() {
		return maxUses;
	}

	public float getEfficiency() {
		return efficiency;
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	public int getEnchantability() {
		return enchantability;
	}

	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

}
