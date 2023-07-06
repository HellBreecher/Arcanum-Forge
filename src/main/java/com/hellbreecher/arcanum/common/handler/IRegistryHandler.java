package com.hellbreecher.arcanum.common.handler;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.ForgeRegistry;

public class IRegistryHandler {
	
	public static final DeferredRegister<CreativeModeTab> ARCANUMTABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MODID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> WEAPONS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);
	
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Reference.MODID);
		
	//public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Reference.MODID);
	
	//public static final DeferredRegister<TileEntityType<?>> TILEENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MODID);

	public void registryInit() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ARCANUMTABS.register(modEventBus);
		
		ITEMS.register(modEventBus);
		Arcanum.Logger.info("Arcanum: Items Registered");
		FOODS.register(modEventBus);
		Arcanum.Logger.info("Arcanum: Foods Registered");
		TOOLS.register(modEventBus);
		Arcanum.Logger.info("Arcanum: Tools Registered");
		WEAPONS.register(modEventBus);
		Arcanum.Logger.info("Arcanum: Weapons Registered");
		ARMOR.register(modEventBus);
		Arcanum.Logger.info("Arcanum: Armor Registered");
		
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Blocks Registered");
		
		FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Fluids Registered");
		
		MinecraftForge.EVENT_BUS.register(this);
		
		//CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		//Arcanum.Logger.info("Arcanum: Containers Registered");
		
		//TILEENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
		//Arcanum.Logger.info("Arcanum: TileEntities Registered");
	}
}
