package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.items.BaseItem;
import com.hellbreecher.arcanum.common.items.HammerItem;
import com.hellbreecher.arcanum.common.items.InfernalDiamondItem;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumItems extends IRegistryHandler {

	//Ingots
	public static final RegistryObject<Item> greensapphire = ITEMS.register("greensapphire", BaseItem::new);
	public static final RegistryObject<Item> blooddiamond = ITEMS.register("blooddiamond", BaseItem::new);
	public static final RegistryObject<Item> voiddiamond = ITEMS.register("voiddiamond", BaseItem::new);
	
	//Magical Ingots
	public static final RegistryObject<Item> infernaldiamond = ITEMS.register("infernaldiamond", InfernalDiamondItem::new);

	//Misc
    public static final RegistryObject<Item> quartzstick = ITEMS.register("quartzstick", BaseItem::new);
    public static final RegistryObject<Item> blooddiamondstick = ITEMS.register("blooddiamondstick", BaseItem::new);
    public static final RegistryObject<Item> emptycan = ITEMS.register("emptycan", BaseItem::new);
    public static final RegistryObject<Item> redcup = ITEMS.register("redcup", BaseItem::new);
    public static final RegistryObject<Item> mountaindewmix = ITEMS.register("mountaindewmix", BaseItem::new);
    
    //Crafting Tools
    public static final RegistryObject<Item> hammer = ITEMS.register("hammer", HammerItem::new);

    //Fuels
    public static final RegistryObject<Item> greensapphirecoal = ITEMS.register("greensapphirecoal", BaseItem::new);

    
}
