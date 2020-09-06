package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.food.itemAppleCider;
import com.hellbreecher.arcanum.common.food.itemCortonWine;
import com.hellbreecher.arcanum.common.food.itemCrushedApple;
import com.hellbreecher.arcanum.common.food.itemFermentedBeer;
import com.hellbreecher.arcanum.common.food.itemMountainDew;
import com.hellbreecher.arcanum.common.food.itemToast;
import com.hellbreecher.arcanum.common.food.itemUnfermentedBeer;
import com.hellbreecher.arcanum.common.food.itemWarmAppleCider;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumFood extends IRegistryHandler{
	
	//Foods
	public static final RegistryObject<Item> crushedapple = FOODS.register("crushedapple", itemCrushedApple::new);
	public static final RegistryObject<Item> toast = FOODS.register("toast", itemToast::new);

	//Drinks
	public static final RegistryObject<Item> cortonwine = FOODS.register("cortonwine", itemCortonWine::new);
	public static final RegistryObject<Item> unfermentedbeer = FOODS.register("unfermentedbeer", itemUnfermentedBeer::new);
	public static final RegistryObject<Item> fermentedbeer = FOODS.register("fermentedbeer", itemFermentedBeer::new);
	public static final RegistryObject<Item> applecider = FOODS.register("applecider", itemAppleCider::new);
	public static final RegistryObject<Item> warmapplecider = FOODS.register("warmapplecider", itemWarmAppleCider::new);
    
    //Powder Mix
	public static final RegistryObject<Item> mountaindew = FOODS.register("mountaindew", itemMountainDew::new);
	 

}
