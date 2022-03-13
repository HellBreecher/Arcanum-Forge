package com.hellbreecher.arcanum.common.worldgen;

import com.hellbreecher.arcanum.common.core.ArcanumBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

	//Ingot Ores
	GreenSapphireOre(Lazy.of(ArcanumBlocks.greensapphireore_block), 4, 0, 256, 8),
	BloodDiamondOre(Lazy.of(ArcanumBlocks.blooddiamondore_block), 4, 0, 16, 4),
	VoidDiamondOre(Lazy.of(ArcanumBlocks.voiddiamondore_block), 2, 0, 12, 2),
	VanillaRandOre(Lazy.of(ArcanumBlocks.vanillarandomore_block), 8, 0, 256, 5),
	ModRandomOre(Lazy.of(ArcanumBlocks.modrandomore_block), 8, 0, 16, 3),
	
	//Mob Drop Ores
	SulfureOre(Lazy.of(ArcanumBlocks.sulfurore_block), 4, 0, 256, 5),
	BoneOre(Lazy.of(ArcanumBlocks.boneore_block), 4, 0, 256, 5), 
	FleshOre(Lazy.of(ArcanumBlocks.fleshore_block), 4, 0, 256, 5);
	
	private final Lazy<OreBlock> block;
	private final int maxVeinSize;
	private final int minHeight;
	private final int maxHeight;
	private final int veinsPerChunk;
	
	OreType(Lazy<OreBlock> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
		this.block = block;
		this.maxVeinSize = maxVeinSize;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.veinsPerChunk = veinsPerChunk;
	}
	
	public int getVeinsPerChunk() {
		return veinsPerChunk;
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
