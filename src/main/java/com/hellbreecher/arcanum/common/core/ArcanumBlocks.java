package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.blockItemBase;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumBlocks extends IRegistryHandler {

	//Ore Blocks
	public static final RegistryObject<OreBlock> greensapphireore_block = BLOCKS.register("greensapphireore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
			.sound(SoundType.STONE).hardnessAndResistance(40.0F, 1000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
	public static final RegistryObject<OreBlock> blooddiamondore_block = BLOCKS.register("blooddiamondore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(4.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
	public static final RegistryObject<OreBlock> voiddiamondore_block = BLOCKS.register("voiddiamondore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(45.0F, 36000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(8)));
	public static final RegistryObject<OreBlock> vanillarandomore_block = BLOCKS.register("vanillarandomore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(4.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(10)));
    public static final RegistryObject<OreBlock> modrandomore_block = BLOCKS.register("modrandomore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
    		.hardnessAndResistance(4.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(10)));
    //Ore Blocks Items
    public static final RegistryObject<Item> greensapphireore_block_item = ITEMS.register("greensapphireore", () -> new blockItemBase(greensapphireore_block.get()));
    public static final RegistryObject<Item> blooddiamondore_block_item = ITEMS.register("blooddiamondore", () -> new blockItemBase(blooddiamondore_block.get()));
    public static final RegistryObject<Item> voiddiamondore_block_item = ITEMS.register("voiddiamondore", () -> new blockItemBase(voiddiamondore_block.get()));
    public static final RegistryObject<Item> vanillarandomore_block_item = ITEMS.register("vanillarandomore", () -> new blockItemBase(vanillarandomore_block.get()));
    public static final RegistryObject<Item> modrandomore_block_item = ITEMS.register("modrandomore", () -> new blockItemBase(modrandomore_block.get()));
    
    //Ingot Blocks
    public static final RegistryObject<Block> greensapphire_block = BLOCKS.register("greensapphireblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(1.0F, 9000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).func_235838_a_((p_235469_0_) -> {return 2;})));
    public static final RegistryObject<Block> blooddiamond_block = BLOCKS.register("blooddiamondblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(20.0F, 18000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
    public static final RegistryObject<Block> voiddiamond_block = BLOCKS.register("voiddiamondblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(45.0F, 36000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(8)));
    //Ingot Block Items
    public static final RegistryObject<Item> greensapphire_block_item = ITEMS.register("greensapphireblock", () -> new blockItemBase(greensapphire_block.get()));
    public static final RegistryObject<Item> blooddiamond_block_item = ITEMS.register("blooddiamondblock", () -> new blockItemBase(blooddiamond_block.get()));
    public static final RegistryObject<Item> voiddiamond_block_item = ITEMS.register("voiddiamondblock", () -> new blockItemBase(voiddiamond_block.get()));
    
    //Mob Drop Ores
    public static final RegistryObject<OreBlock> boneore_block = BLOCKS.register("boneore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
    		.hardnessAndResistance(1.0F, 15.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<OreBlock> fleshore_block = BLOCKS.register("fleshore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
    		.hardnessAndResistance(1.0F, 15.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<OreBlock> sulfurore_block = BLOCKS.register("sulfurore", () -> new OreBlock(Block.Properties.create(Material.ROCK)
    		.hardnessAndResistance(1.0F, 15.0F).harvestTool(ToolType.PICKAXE)));;
    //Mob Drop Ore Items
    public static final RegistryObject<Item> boneore_block_item = ITEMS.register("boneore", () -> new blockItemBase(boneore_block.get()));
    public static final RegistryObject<Item> fleshore_block_item = ITEMS.register("fleshore", () -> new blockItemBase(fleshore_block.get()));
    public static final RegistryObject<Item> sulfurore_block_item = ITEMS.register("sulfurore", () -> new blockItemBase(sulfurore_block.get()));
    
    //Mob Drop Blocks
    public static final RegistryObject<Block> bone_block = BLOCKS.register("boneblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(4.0F, 15.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> flesh_block = BLOCKS.register("fleshblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(4.0F, 15.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> sulfur_block = BLOCKS.register("sulfurblock", () -> new Block(Block.Properties.create(Material.IRON)
    		.hardnessAndResistance(4.0F, 15.0F).harvestTool(ToolType.PICKAXE)));
    //Mob Drop Block items
    public static final RegistryObject<Item> bone_block_item = ITEMS.register("boneblock", () -> new blockItemBase(bone_block.get()));
    public static final RegistryObject<Item> flesh_block_item = ITEMS.register("fleshblock", () -> new blockItemBase(flesh_block.get()));
    public static final RegistryObject<Item> sulfur_block_item = ITEMS.register("sulfurblock", () -> new blockItemBase(sulfur_block.get()));
    
    //Wall & Floor Blocks
    public static final RegistryObject<TorchBlock> greensapphiretorch_block = BLOCKS.register("greensapphiretorch", () -> new TorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
    		.doesNotBlockMovement().zeroHardnessAndResistance().func_235838_a_((p_235469_0_) -> {return 14;}).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final RegistryObject<WallTorchBlock> wall_greensapphiretorch_block = BLOCKS.register("wall_greensapphiretorch", () -> new WallTorchBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
    		.doesNotBlockMovement().zeroHardnessAndResistance().func_235838_a_((p_235469_0_) -> {return 14;}).sound(SoundType.WOOD).lootFrom(greensapphiretorch_block.get()), ParticleTypes.FLAME));
    //Wall & Floor Block Items
    public static final RegistryObject<WallOrFloorItem> greensapphiretorch_block_item = ITEMS.register("greensapphiretorch", () -> new WallOrFloorItem(greensapphiretorch_block.get(), wall_greensapphiretorch_block.get(), (new Item.Properties().group(Arcanum.arcanum))));

    //Misc Blocks
    public static final RegistryObject<Block> greensapphirecoal_block = BLOCKS.register("greensapphirecoalblock", () -> new Block(Block.Properties.create(Material.ROCK)
    		.hardnessAndResistance(20.0F, 9000.0F)));
    //Misc Block Items
    public static final RegistryObject<Item> greensapphirecoal_block_item = ITEMS.register("greensapphirecoalblock", () -> new blockItemBase(greensapphirecoal_block.get()));
    
    /**
    public static Block blockArcFurnace = new blockArcFurnace();
    public static Block blockMCUFurnace = new blockMCUFurnace();

    public static Block blockFermenter = new blockFermenter(); */
}
