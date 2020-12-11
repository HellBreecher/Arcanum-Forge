package com.hellbreecher.arcanum.common.handler;

import javax.annotation.Nonnull;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.tile.tileentityArcFurnace;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IRegistryHandler {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> WEAPONS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Reference.MODID);
	public static final DeferredRegister<TileEntityType<?>> TILEENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MODID);




	public static void registryInit() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Items Registered");
		FOODS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Foods Registered");
		TOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Tools Registered");
		WEAPONS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Weapons Registered");
		ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Armor Registered");
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Blocks Registered");
		
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: Containers Registered");
		TILEENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
		Arcanum.Logger.info("Arcanum: TileEntities Registered");

	}
}
