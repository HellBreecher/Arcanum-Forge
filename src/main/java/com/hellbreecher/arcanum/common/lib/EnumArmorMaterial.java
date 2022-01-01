package com.hellbreecher.arcanum.common.lib;

import java.util.function.Supplier;

import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum EnumArmorMaterial implements IArmorMaterial {
	
	GreenSapphireArmor("arcanum:greensapphirearmor", 66, new int[] { 4, 8, 5, 5 }, 30, SoundEvents.ARMOR_EQUIP_GENERIC, 20.0F, 0.0F, () -> {return Ingredient.of(ArcanumItems.greensapphire.get());}),
	BloodDiamondArmor("arcanum:blooddiamondarmor", 99, new int[] { 6, 10, 8, 8 }, 30, SoundEvents.ARMOR_EQUIP_GENERIC, 40.0F, 0.3F, () -> {return Ingredient.of(ArcanumItems.blooddiamond.get());}),
	VoidDiamondArmor("arcanum:voiddiamondarmor", 132, new int[] { 10, 12, 16, 16 }, 30, SoundEvents.ARMOR_EQUIP_GENERIC, 60.0F, 0.5F, () -> {return Ingredient.of(ArcanumItems.voiddiamond.get());}),
	InfernalDiamondArmor("arcanum:infernaldiamondarmor", 9000, new int[] { 50, 50, 50, 50 }, 30, SoundEvents.ARMOR_EQUIP_GENERIC, 80.0F, 1.0F, () -> {return Ingredient.of(ArcanumItems.infernaldiamond.get());}),
	InfernalArmor("arcanum:infernalarmor", 9999, new int[] { 9999, 9999, 9999, 9999 }, 30, SoundEvents.ARMOR_EQUIP_GENERIC, 9999.0F, 10.0F, () -> {return Ingredient.of(ArcanumItems.infernaldiamond.get());});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockBackResistance;
	private final Supplier<Ingredient> repairMaterial;
	
	EnumArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockBackResistance, Supplier<Ingredient> repairMaterial){
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.knockBackResistance = knockBackResistance;
		this.repairMaterial = repairMaterial;
	}
	
	public int getDurabilityForSlot(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDefenseForSlot(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockBackResistance;
	}

}
