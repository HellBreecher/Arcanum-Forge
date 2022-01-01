package com.hellbreecher.arcanum.common.worldgen;

import com.hellbreecher.arcanum.common.core.ArcanumBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

	//Ingot Ores
	GreenSapphireOre(Lazy.of(ArcanumBlocks.greensapphireore_block), 8, 0, 256),
	BloodDiamondOre(Lazy.of(ArcanumBlocks));
	
	private final Lazy<OreBlock> block;
	private final int maxVeinSize;
	private final int minHeight;
	private final int maxHeight;
	
	OreType(Lazy<OreBlock> block, int maxVeinSize, int minHeight, int maxHeight) {
		this.block = block;
		this.maxVeinSize = maxVeinSize;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	
	public Lazy<OreBlock> getBlock() {
		return block;
	}
	
	public int getMaxVeinSize() {
		return maxVeinSize;
	}
	
	public int getMinHeight() {
		return minHeight;
	}
	
	public int getMaxHeight() {
		return maxHeight;
	}
	
	public static OreType get(Block block) {
		for (OreType ore : values()) {
			if(block == ore.block) {
				return ore;
			}
		}
		return null;
	}
	
}
