package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.blocks.tile.tileentityArcFurnace;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumTileEntities extends IRegistryHandler {

	//Furnace Tile Entities
	//public static final RegistryObject<TileEntityType<tileentityArcFurnace>> arcfurnace_tile_entity = TILEENTITY
			//.register("arcfurnace_tile_entity", () -> TileEntityType.Builder.create(tileentityArcFurnace::new, ArcanumBlocks.arcfurnace_block.get()).build(null));
	
}
