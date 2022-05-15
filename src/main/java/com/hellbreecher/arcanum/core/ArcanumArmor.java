package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.armor.InfernalArmorItem;
import com.hellbreecher.arcanum.common.armor.InfernalDiamondArmorItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumArmor extends IRegistryHandler{

    public static final RegistryObject<ArmorItem> greensapphirehelmet = ARMOR.register("greensapphirehelmet", () ->
    	new ArmorItem(EnumArmorMaterial.GreenSapphireArmor, EquipmentSlot.HEAD, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> greensapphirechestplate = ARMOR.register("greensapphirechestplate", () ->
		new ArmorItem(EnumArmorMaterial.GreenSapphireArmor, EquipmentSlot.CHEST, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> greensapphireleggings = ARMOR.register("greensapphireleggings", () ->
		new ArmorItem(EnumArmorMaterial.GreenSapphireArmor, EquipmentSlot.LEGS, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> greensapphireboots = ARMOR.register("greensapphireboots", () ->
		new ArmorItem(EnumArmorMaterial.GreenSapphireArmor, EquipmentSlot.FEET, new Item.Properties().tab(Arcanum.arcanum)));

    public static final RegistryObject<ArmorItem> blooddiamondhelmet = ARMOR.register("blooddiamondhelmet", () ->
    	new ArmorItem(EnumArmorMaterial.BloodDiamondArmor, EquipmentSlot.HEAD, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> blooddiamondchestplate = ARMOR.register("blooddiamondchestplate", () ->
		new ArmorItem(EnumArmorMaterial.BloodDiamondArmor, EquipmentSlot.CHEST, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> blooddiamondleggings = ARMOR.register("blooddiamondleggings", () ->
		new ArmorItem(EnumArmorMaterial.BloodDiamondArmor, EquipmentSlot.LEGS, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> blooddiamondboots = ARMOR.register("blooddiamondboots", () ->
		new ArmorItem(EnumArmorMaterial.BloodDiamondArmor, EquipmentSlot.FEET, new Item.Properties().tab(Arcanum.arcanum)));
    
    public static final RegistryObject<ArmorItem> voiddiamondhelmet = ARMOR.register("voiddiamondhelmet", () ->
		new ArmorItem(EnumArmorMaterial.VoidDiamondArmor, EquipmentSlot.HEAD, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> voiddiamondchestplate = ARMOR.register("voiddiamondchestplate", () ->
		new ArmorItem(EnumArmorMaterial.VoidDiamondArmor, EquipmentSlot.CHEST, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> VoidDiamondLeggings = ARMOR.register("voiddiamondleggings", () ->
		new ArmorItem(EnumArmorMaterial.VoidDiamondArmor, EquipmentSlot.LEGS, new Item.Properties().tab(Arcanum.arcanum)));
    public static final RegistryObject<ArmorItem> voiddiamondboots = ARMOR.register("voiddiamondboots", () ->
		new ArmorItem(EnumArmorMaterial.VoidDiamondArmor, EquipmentSlot.FEET, new Item.Properties().tab(Arcanum.arcanum)));
    
    public static final RegistryObject<ArmorItem> infernaldiamondhelmet = ARMOR.register("infernaldiamondhelmet", () -> new InfernalDiamondArmorItem(EquipmentSlot.HEAD));
    public static final RegistryObject<ArmorItem> infernaldiamondchestplate = ARMOR.register("infernaldiamondchestplate", () -> new InfernalDiamondArmorItem(EquipmentSlot.CHEST));
    public static final RegistryObject<ArmorItem> infernaldiamondleggings = ARMOR.register("infernaldiamondleggings", () -> new InfernalDiamondArmorItem(EquipmentSlot.LEGS));
    public static final RegistryObject<ArmorItem> infernaldiamondboots = ARMOR.register("infernaldiamondboots", () -> new InfernalDiamondArmorItem(EquipmentSlot.FEET));

    public static final RegistryObject<ArmorItem> infernalhelmet = ARMOR.register("infernalhelmet", () -> new InfernalArmorItem(EquipmentSlot.HEAD));
    public static final RegistryObject<ArmorItem> infernalchestplate = ARMOR.register("infernalchestplate", () -> new InfernalArmorItem(EquipmentSlot.CHEST));
    public static final RegistryObject<ArmorItem> infernalleggings = ARMOR.register("infernalleggings", () -> new InfernalArmorItem(EquipmentSlot.LEGS));
    public static final RegistryObject<ArmorItem> infernalboots = ARMOR.register("infernalboots", () -> new InfernalArmorItem(EquipmentSlot.FEET));
    
}
