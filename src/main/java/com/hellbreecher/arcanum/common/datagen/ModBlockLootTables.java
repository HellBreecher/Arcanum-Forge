package com.hellbreecher.arcanum.common.datagen;

import java.util.Set;

import com.hellbreecher.arcanum.core.ArcanumBlocks;
import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}
	
	protected void generate() {
		//Ores
		add(ArcanumBlocks.greensapphireore_block.get(), 
				(block) -> createOreDrop(ArcanumBlocks.greensapphireore_block.get(), ArcanumItems.greensapphire.get()));
		add(ArcanumBlocks.blooddiamondore_block.get(), 
				(block) -> createOreDrop(ArcanumBlocks.blooddiamondore_block.get(), ArcanumItems.blooddiamond.get()));
		add(ArcanumBlocks.voiddiamondore_block.get(), 
				(block) -> createOreDrop(ArcanumBlocks.voiddiamondore_block.get(), ArcanumItems.voiddiamond.get()));
		add(ArcanumBlocks.voiddiamondore_block.get(), 
				(block) -> createOreDrop(ArcanumBlocks.voiddiamondore_block.get(), ArcanumItems.voiddiamond.get()));
		add(ArcanumBlocks.voiddiamondore_block.get(), 
				(block) -> createOreDrop(ArcanumBlocks.voiddiamondore_block.get(), ArcanumItems.voiddiamond.get()));
		//Ingot Blocks
		this.dropSelf(ArcanumBlocks.greensapphire_block.get());
		this.dropSelf(ArcanumBlocks.blooddiamond_block.get());
		this.dropSelf(ArcanumBlocks.voiddiamond_block.get());

	}
	
	protected Iterable<Block> getKnownBlocks() {
		return ArcanumBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
	
}
