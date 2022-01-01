package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.common.tools.ArcWrenchItem;
import com.hellbreecher.arcanum.common.tools.InfernalAxeItem;
import com.hellbreecher.arcanum.common.tools.InfernalDiamondAxeItem;
import com.hellbreecher.arcanum.common.tools.InfernalDiamondHoeItem;
import com.hellbreecher.arcanum.common.tools.InfernalDiamondPickaxeItem;
import com.hellbreecher.arcanum.common.tools.InfernalDiamondShearsItem;
import com.hellbreecher.arcanum.common.tools.InfernalDiamondShovelItem;
import com.hellbreecher.arcanum.common.tools.InfernalHoeItem;
import com.hellbreecher.arcanum.common.tools.InfernalPickaxeItem;
import com.hellbreecher.arcanum.common.tools.InfernalShearsItem;
import com.hellbreecher.arcanum.common.tools.InfernalShovelItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumTools extends IRegistryHandler{
		
	public static final RegistryObject<PickaxeItem> greensapphirepickaxe = TOOLS.register("greensapphirepickaxe", () -> 
		new PickaxeItem(EnumToolMaterial.GreenSapphireTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> blooddiamondpickaxe = TOOLS.register("blooddiamondpickaxe", () -> 
		new PickaxeItem(EnumToolMaterial.BloodDiamondTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> voiddiamondpickaxe = TOOLS.register("voiddiamondpickaxe", () -> 
		new PickaxeItem(EnumToolMaterial.VoidDiamondTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> infernaldiamondpickaxe = TOOLS.register("infernaldiamondpickaxe", InfernalDiamondPickaxeItem::new);
	public static final RegistryObject<PickaxeItem> infernalpickaxe = TOOLS.register("infernalpickaxe", InfernalPickaxeItem::new);

	public static final RegistryObject<AxeItem> greensapphireaxe = TOOLS.register("greensapphireaxe", () ->
		new AxeItem(EnumToolMaterial.GreenSapphireTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> blooddiamondaxe = TOOLS.register("blooddiamondaxe", () ->
		new AxeItem(EnumToolMaterial.BloodDiamondTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> voiddiamondaxe = TOOLS.register("voiddiamondaxe", () ->
		new AxeItem(EnumToolMaterial.VoidDiamondTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> infernaldiamondaxe = TOOLS.register("infernaldiamondaxe", InfernalDiamondAxeItem::new);
	public static final RegistryObject<AxeItem> infernalaxe = TOOLS.register("infernalaxe", InfernalAxeItem::new);
    
	public static final RegistryObject<ShovelItem> greensapphireshovel = TOOLS.register("greensapphireshovel", () ->
		new ShovelItem(EnumToolMaterial.GreenSapphireTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<ShovelItem> blooddiamondshovel = TOOLS.register("blooddiamondshovel", () ->
		new ShovelItem(EnumToolMaterial.BloodDiamondTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<ShovelItem> voiddiamondshovel = TOOLS.register("voiddiamondshovel", () ->
		new ShovelItem(EnumToolMaterial.VoidDiamondTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<ShovelItem> infernaldiamondshovel = TOOLS.register("infernaldiamondshovel", InfernalDiamondShovelItem::new);
	public static final RegistryObject<ShovelItem> infernalshovel = TOOLS.register("infernalshovel", InfernalShovelItem::new);
    
	public static final RegistryObject<ShearsItem> greensapphireshears = TOOLS.register("greensapphireshears", () ->
		new ShearsItem(new Item.Properties().tab(Arcanum.arcanum).durability(1500)));
	public static final RegistryObject<ShearsItem> blooddiamondshears = TOOLS.register("blooddiamondshears", () ->
		new ShearsItem(new Item.Properties().tab(Arcanum.arcanum).durability(3000)));
	public static final RegistryObject<ShearsItem> voiddimaondshears = TOOLS.register("voiddiamondshears", () ->
		new ShearsItem(new Item.Properties().tab(Arcanum.arcanum).durability(6000)));
	public static final RegistryObject<ShearsItem> infernaldiamondshears = TOOLS.register("infernaldiamondshears", InfernalDiamondShearsItem::new);
	public static final RegistryObject<ShearsItem> infernalshears = TOOLS.register("infernalshears", InfernalShearsItem::new);
    
	public static final RegistryObject<HoeItem> greensapphirehoe = TOOLS.register("greensapphirehoe", () ->
		new HoeItem(EnumToolMaterial.GreenSapphireTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> blooddiamondhoe = TOOLS.register("blooddiamondhoe", () ->
		new HoeItem(EnumToolMaterial.BloodDiamondTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> voiddiamondhoe = TOOLS.register("voiddiamondhoe", () ->
		new HoeItem(EnumToolMaterial.VoidDiamondTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> infernaldiamondhoe = TOOLS.register("infernaldiamondhoe", InfernalDiamondHoeItem::new);
	public static final RegistryObject<HoeItem> infernalhoe = TOOLS.register("infernalhoe", InfernalHoeItem::new);

	public static final RegistryObject<Item> arcwrench = TOOLS.register("arcwrench", ArcWrenchItem::new);
	//public static final RegistryObject<Item> infernalwand = TOOLS.register("infernalwand", InfernalWand::new);
}
