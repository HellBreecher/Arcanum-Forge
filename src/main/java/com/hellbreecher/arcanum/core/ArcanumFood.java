package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.food.AppleCiderItem;
import com.hellbreecher.arcanum.common.food.CortonWineItem;
import com.hellbreecher.arcanum.common.food.FermentedBeerItem;
import com.hellbreecher.arcanum.common.food.MountainDewItem;
import com.hellbreecher.arcanum.common.food.UnfermentedBeerItem;
import com.hellbreecher.arcanum.common.food.WarmAppleCiderItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumFood extends IRegistryHandler{
	
	//Foods
	public static final RegistryObject<Item> crushedapple = FOODS.register("crushedapple", () -> new Item(new Item
			.Properties().tab(Arcanum.arcanum)
			.food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationMod(2.0F)
					.build())));
	public static final RegistryObject<Item> toast = FOODS.register("toast", () -> new Item(new Item
			.Properties().tab(Arcanum.arcanum)
			.food(new FoodProperties.Builder()
					.nutrition(10)
					.saturationMod(10.0F)
					.build())));

	//Drinks
	public static final RegistryObject<Item> cortonwine = FOODS.register("cortonwine", CortonWineItem::new);
	public static final RegistryObject<Item> unfermentedbeer = FOODS.register("unfermentedbeer", UnfermentedBeerItem::new);
	public static final RegistryObject<Item> fermentedbeer = FOODS.register("fermentedbeer", FermentedBeerItem::new);
	public static final RegistryObject<Item> applecider = FOODS.register("applecider", AppleCiderItem::new);
	public static final RegistryObject<Item> warmapplecider = FOODS.register("warmapplecider", WarmAppleCiderItem::new);
    
    //Powder Mix
	public static final RegistryObject<Item> mountaindew = FOODS.register("mountaindew", MountainDewItem::new);
	 

}
