package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumToolTier;
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

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumTools extends IRegistryHandler{
		
	public static final RegistryObject<PickaxeItem> greensapphirepickaxe = TOOLS.register("greensapphirepickaxe", () -> 
		new PickaxeItem(EnumToolTier.GreenSapphireTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> blooddiamondpickaxe = TOOLS.register("blooddiamondpickaxe", () -> 
		new PickaxeItem(EnumToolTier.BloodDiamondTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> voiddiamondpickaxe = TOOLS.register("voiddiamondpickaxe", () -> 
		new PickaxeItem(EnumToolTier.VoidDiamondTool, 1, -2.8F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<PickaxeItem> infernaldiamondpickaxe = TOOLS.register("infernaldiamondpickaxe", InfernalDiamondPickaxeItem::new);
	public static final RegistryObject<PickaxeItem> infernalpickaxe = TOOLS.register("infernalpickaxe", InfernalPickaxeItem::new);

	public static final RegistryObject<AxeItem> greensapphireaxe = TOOLS.register("greensapphireaxe", () ->
		new AxeItem(EnumToolTier.GreenSapphireTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> blooddiamondaxe = TOOLS.register("blooddiamondaxe", () ->
		new AxeItem(EnumToolTier.BloodDiamondTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> voiddiamondaxe = TOOLS.register("voiddiamondaxe", () ->
		new AxeItem(EnumToolTier.VoidDiamondTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<AxeItem> infernaldiamondaxe = TOOLS.register("infernaldiamondaxe", InfernalDiamondAxeItem::new);
	public static final RegistryObject<AxeItem> infernalaxe = TOOLS.register("infernalaxe", InfernalAxeItem::new);
    
	public static final RegistryObject<ShovelItem> greensapphireshovel = TOOLS.register("greensapphireshovel", () ->
		new ShovelItem(EnumToolTier.GreenSapphireTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<ShovelItem> blooddiamondshovel = TOOLS.register("blooddiamondshovel", () ->
		new ShovelItem(EnumToolTier.BloodDiamondTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<ShovelItem> voiddiamondshovel = TOOLS.register("voiddiamondshovel", () ->
		new ShovelItem(EnumToolTier.VoidDiamondTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
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
		new HoeItem(EnumToolTier.GreenSapphireTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> blooddiamondhoe = TOOLS.register("blooddiamondhoe", () ->
		new HoeItem(EnumToolTier.BloodDiamondTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> voiddiamondhoe = TOOLS.register("voiddiamondhoe", () ->
		new HoeItem(EnumToolTier.VoidDiamondTool, -2, -3.0F, new Item.Properties().tab(Arcanum.arcanum)));
	public static final RegistryObject<HoeItem> infernaldiamondhoe = TOOLS.register("infernaldiamondhoe", InfernalDiamondHoeItem::new);
	public static final RegistryObject<HoeItem> infernalhoe = TOOLS.register("infernalhoe", InfernalHoeItem::new);

	public static final RegistryObject<Item> arcwrench = TOOLS.register("arcwrench", ArcWrenchItem::new);
	//public static final RegistryObject<Item> infernalwand = TOOLS.register("infernalwand", InfernalWand::new);
}
