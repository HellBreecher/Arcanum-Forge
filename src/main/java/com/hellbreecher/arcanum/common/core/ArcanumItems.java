package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.items.itemBase;
import com.hellbreecher.arcanum.common.items.itemHammer;
import com.hellbreecher.arcanum.common.items.itemInfernalDiamond;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumItems extends IRegistryHandler {

	//Ingots
	public static final RegistryObject<Item> greensapphire = ITEMS.register("greensapphire", itemBase::new);
	public static final RegistryObject<Item> blooddiamond = ITEMS.register("blooddiamond", itemBase::new);
	public static final RegistryObject<Item> voiddiamond = ITEMS.register("voiddiamond", itemBase::new);
	
	//Magical Ingots
	public static final RegistryObject<Item> infernaldiamond = ITEMS.register("infernaldiamond", itemInfernalDiamond::new);

	//Misc
    public static final RegistryObject<Item> quartzstick = ITEMS.register("quartzstick", itemBase::new);
    public static final RegistryObject<Item> blooddiamondstick = ITEMS.register("blooddiamondstick", itemBase::new);
    public static final RegistryObject<Item> emptycan = ITEMS.register("emptycan", itemBase::new);
    public static final RegistryObject<Item> redcup = ITEMS.register("redcup", itemBase::new);
    public static final RegistryObject<Item> mountaindewmix = ITEMS.register("mountaindewmix", itemBase::new);
    
    //Crafting Tools
    public static final RegistryObject<Item> hammer = ITEMS.register("hammer", itemHammer::new);

    //Fuels
    public static final RegistryObject<Item> greensapphirecoal = ITEMS.register("greensapphirecoal", itemBase::new);

    
}
