package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.common.weapons.itemBasicBeatingStick;
import com.hellbreecher.arcanum.common.weapons.itemInfernalBeatingStick;
import com.hellbreecher.arcanum.common.weapons.itemInfernalDiamondSword;
import com.hellbreecher.arcanum.common.weapons.itemInfernalSword;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumWeapons extends IRegistryHandler{
   
	public static final RegistryObject<SwordItem> greensapphiresword = WEAPONS.register("greensapphiresword", () -> 
	new SwordItem(EnumToolMaterial.GreenSapphireTool, 1, 0F, new Item.Properties().group(Arcanum.arcanum)));
	public static final RegistryObject<SwordItem> blooddiamondsword = WEAPONS.register("blooddiamondsword", () -> 
	new SwordItem(EnumToolMaterial.BloodDiamondTool, 1, 0F, new Item.Properties().group(Arcanum.arcanum)));    
	public static final RegistryObject<SwordItem> voiddiamondsword = WEAPONS.register("voiddiamondsword", () -> 
	new SwordItem(EnumToolMaterial.VoidDiamondTool, 1, 0F, new Item.Properties().group(Arcanum.arcanum)));
	public static final RegistryObject<SwordItem> infernaldiamondsword = WEAPONS.register("infernaldiamondsword", itemInfernalDiamondSword::new);
	public static final RegistryObject<SwordItem> infernalsword = WEAPONS.register("infernalsword", itemInfernalSword::new);
	
	public static final RegistryObject<Item> basicbeatingstick = WEAPONS.register("basicbeatingstick", itemBasicBeatingStick::new);
	public static final RegistryObject<Item> infernalbeatingstick = WEAPONS.register("infernalbeatingstick", itemInfernalBeatingStick::new);
}
