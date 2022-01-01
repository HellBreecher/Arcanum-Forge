package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.food.AppleCiderItem;
import com.hellbreecher.arcanum.common.food.CortonWineItem;
import com.hellbreecher.arcanum.common.food.CrushedAppleItem;
import com.hellbreecher.arcanum.common.food.FermentedBeerItem;
import com.hellbreecher.arcanum.common.food.MountainDewItem;
import com.hellbreecher.arcanum.common.food.ToastItem;
import com.hellbreecher.arcanum.common.food.UnfermentedBeerItem;
import com.hellbreecher.arcanum.common.food.WarmAppleCiderItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumFood extends IRegistryHandler{
	
	//Foods
	public static final RegistryObject<Item> crushedapple = FOODS.register("crushedapple", CrushedAppleItem::new);
	public static final RegistryObject<Item> toast = FOODS.register("toast", ToastItem::new);

	//Drinks
	public static final RegistryObject<Item> cortonwine = FOODS.register("cortonwine", CortonWineItem::new);
	public static final RegistryObject<Item> unfermentedbeer = FOODS.register("unfermentedbeer", UnfermentedBeerItem::new);
	public static final RegistryObject<Item> fermentedbeer = FOODS.register("fermentedbeer", FermentedBeerItem::new);
	public static final RegistryObject<Item> applecider = FOODS.register("applecider", AppleCiderItem::new);
	public static final RegistryObject<Item> warmapplecider = FOODS.register("warmapplecider", WarmAppleCiderItem::new);
    
    //Powder Mix
	public static final RegistryObject<Item> mountaindew = FOODS.register("mountaindew", MountainDewItem::new);
	 

}
