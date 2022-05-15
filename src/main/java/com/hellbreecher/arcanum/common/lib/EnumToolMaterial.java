package com.hellbreecher.arcanum.common.lib;

import java.util.function.Supplier;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;

import com.hellbreecher.arcanum.core.ArcanumItems;

public enum EnumToolMaterial implements Tier{
	
	GreenSapphireTool(5, 1500, 10.0F, 10.0F, 30, () -> {return Ingredient.of(ArcanumItems.greensapphire.get());}),
	BloodDiamondTool(8, 3000, 20.0F, 50.0F, 30, () -> {return Ingredient.of(ArcanumItems.blooddiamond.get());}),
	VoidDiamondTool(10, 6000, 50.0F, 75.0F, 30, () -> {return Ingredient.of(ArcanumItems.voiddiamond.get());}),
	InfernalDiamondTool(12, 8000, 100.0F, 100.0F, 30, () -> {return Ingredient.of(ArcanumItems.infernaldiamond.get());}),
	InfernalTool(9999, 1, 500.0F, 100000F, 30, () -> {return Ingredient.of(ArcanumItems.infernaldiamond.get());}),
	
	SapphireBeatingStick(0, 1500, 0.0F, 10.0F, 30, () -> {return Ingredient.of(ArcanumItems.greensapphire.get());}),
	BloodDiamondBeatingStick(0, 2000, 0.0F, 25.0F, 30, () -> {return Ingredient.of(ArcanumItems.blooddiamond.get());}),
	VoidDiamondBeatingStick(0, 2500, 0.0F, 50.0F, 30, () -> {return Ingredient.of(ArcanumItems.voiddiamond.get());}),
	InfernalBeatingStick(0, 3000, 0.0F, 100.0F, 30, () -> {return Ingredient.of(ArcanumItems.infernaldiamond.get());});


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
	
	public int getUses() {
		return maxUses;
	}

	public float getSpeed() {
		return efficiency;
	}

	public float getAttackDamageBonus() {
		return attackDamage;
	}

	public int getLevel() {
		return harvestLevel;
	}

	public int getEnchantmentValue() {
		return enchantability;
	}

	public Ingredient getRepairIngredient() {
		return repairMaterial.get();
	}

}
