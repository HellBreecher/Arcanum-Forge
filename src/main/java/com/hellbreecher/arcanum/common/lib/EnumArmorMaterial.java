package com.hellbreecher.arcanum.common.lib;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum EnumArmorMaterial implements ArmorMaterial {
	
	GreenSapphireArmor("arcanum:greensapphirearmor", 66, Util.make(new EnumMap<>(ArmorItem.Type.class), (gsdm) -> {
		gsdm.put(ArmorItem.Type.BOOTS, 4);
		gsdm.put(ArmorItem.Type.LEGGINGS, 5);
		gsdm.put(ArmorItem.Type.CHESTPLATE, 8);
		gsdm.put(ArmorItem.Type.HELMET, 5);
		}), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 20.0F, 0.0F, () -> {
			return Ingredient.of(ArcanumItems.greensapphire.get());
		}),
	BloodDiamondArmor("arcanum:blooddiamondarmor", 99, Util.make(new EnumMap<>(ArmorItem.Type.class), (bddm) -> {
		bddm.put(ArmorItem.Type.BOOTS, 6);
		bddm.put(ArmorItem.Type.LEGGINGS, 8);
		bddm.put(ArmorItem.Type.CHESTPLATE, 10);
		bddm.put(ArmorItem.Type.HELMET, 8);
		}), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 40.0F, 0.3F, () -> {
			return Ingredient.of(ArcanumItems.blooddiamond.get());
		}),
	VoidDiamondArmor("arcanum:voiddiamondarmor", 132, Util.make(new EnumMap<>(ArmorItem.Type.class), (vddm) -> {
		vddm.put(ArmorItem.Type.BOOTS, 10);
		vddm.put(ArmorItem.Type.LEGGINGS, 12);
		vddm.put(ArmorItem.Type.CHESTPLATE, 16);
		vddm.put(ArmorItem.Type.HELMET, 16);
		}), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 60.0F, 0.5F, () -> {
			return Ingredient.of(ArcanumItems.voiddiamond.get());
		}),
	InfernalDiamondArmor("arcanum:infernaldiamondarmor", 9000, Util.make(new EnumMap<>(ArmorItem.Type.class), (iddm) -> { 
		iddm.put(ArmorItem.Type.BOOTS, 50); 
		iddm.put(ArmorItem.Type.LEGGINGS, 50); 
		iddm.put(ArmorItem.Type.CHESTPLATE, 50); 
		iddm.put(ArmorItem.Type.HELMET, 50);
		}), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 80.0F, 1.0F, () -> {
			return Ingredient.of(ArcanumItems.infernaldiamond.get());
		}),
	InfernalArmor("arcanum:infernalarmor", 0, Util.make(new EnumMap<>(ArmorItem.Type.class), (idm) -> {
		idm.put(ArmorItem.Type.BOOTS, 0); 
		idm.put(ArmorItem.Type.LEGGINGS, 0);
		idm.put(ArmorItem.Type.CHESTPLATE, 0);
		idm.put(ArmorItem.Type.HELMET, 0); 
		}), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 9999.0F, 10.0F, () -> {
			return Ingredient.of(ArcanumItems.infernaldiamond.get());
		});
	
	private final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
	private final String name;
	private final int maxDamageFactor;
	private final EnumMap<Type, Integer> protectionFunctionForType;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockBackResistance;
	private final Supplier<Ingredient> repairMaterial;
	
	EnumArmorMaterial(String name, int maxDamageFactor, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantability, SoundEvent soundEvent, float toughness, float knockBackResistance, Supplier<Ingredient> repairMaterial){
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.protectionFunctionForType = protectionFunctionForType;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.knockBackResistance = knockBackResistance;
		this.repairMaterial = repairMaterial;
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

	public int getDurabilityForType(Type type) {
		return this.MAX_DAMAGE_ARRAY[type.getSlot().getIndex()] * this.maxDamageFactor;
	}

	public int getDefenseForType(Type type) {
		return this.protectionFunctionForType.get(type);
	}

}
