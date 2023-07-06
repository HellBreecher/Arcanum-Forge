package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.common.armor.BaseArmorItem;
import com.hellbreecher.arcanum.common.armor.InfernalArmorItem;
import com.hellbreecher.arcanum.common.armor.InfernalDiamondArmorItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumArmor extends IRegistryHandler{

    public static final RegistryObject<ArmorItem> greensapphirehelmet = ARMOR.register("greensapphirehelmet", () ->
    	new BaseArmorItem(EnumArmorMaterial.GreenSapphireArmor, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> greensapphirechestplate = ARMOR.register("greensapphirechestplate", () ->
		new BaseArmorItem(EnumArmorMaterial.GreenSapphireArmor, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> greensapphireleggings = ARMOR.register("greensapphireleggings", () ->
		new BaseArmorItem(EnumArmorMaterial.GreenSapphireArmor, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> greensapphireboots = ARMOR.register("greensapphireboots", () ->
		new BaseArmorItem(EnumArmorMaterial.GreenSapphireArmor, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> blooddiamondhelmet = ARMOR.register("blooddiamondhelmet", () ->
    	new BaseArmorItem(EnumArmorMaterial.BloodDiamondArmor, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> blooddiamondchestplate = ARMOR.register("blooddiamondchestplate", () ->
		new BaseArmorItem(EnumArmorMaterial.BloodDiamondArmor, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> blooddiamondleggings = ARMOR.register("blooddiamondleggings", () ->
		new BaseArmorItem(EnumArmorMaterial.BloodDiamondArmor, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> blooddiamondboots = ARMOR.register("blooddiamondboots", () ->
		new BaseArmorItem(EnumArmorMaterial.BloodDiamondArmor, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<ArmorItem> voiddiamondhelmet = ARMOR.register("voiddiamondhelmet", () ->
		new BaseArmorItem(EnumArmorMaterial.VoidDiamondArmor, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> voiddiamondchestplate = ARMOR.register("voiddiamondchestplate", () ->
		new BaseArmorItem(EnumArmorMaterial.VoidDiamondArmor, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> voiddiamondleggings = ARMOR.register("voiddiamondleggings", () ->
		new BaseArmorItem(EnumArmorMaterial.VoidDiamondArmor, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> voiddiamondboots = ARMOR.register("voiddiamondboots", () ->
		new BaseArmorItem(EnumArmorMaterial.VoidDiamondArmor, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<ArmorItem> infernaldiamondhelmet = ARMOR.register("infernaldiamondhelmet", () -> new InfernalDiamondArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> infernaldiamondchestplate = ARMOR.register("infernaldiamondchestplate", () -> new InfernalDiamondArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> infernaldiamondleggings = ARMOR.register("infernaldiamondleggings", () -> new InfernalDiamondArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> infernaldiamondboots = ARMOR.register("infernaldiamondboots", () -> new InfernalDiamondArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistryObject<ArmorItem> infernalhelmet = ARMOR.register("infernalhelmet", () -> new InfernalArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<ArmorItem> infernalchestplate = ARMOR.register("infernalchestplate", () -> new InfernalArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ArmorItem> infernalleggings = ARMOR.register("infernalleggings", () -> new InfernalArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ArmorItem> infernalboots = ARMOR.register("infernalboots", () -> new InfernalArmorItem(ArmorItem.Type.BOOTS));
    
}
