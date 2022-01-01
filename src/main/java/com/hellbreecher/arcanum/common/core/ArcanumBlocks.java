package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.BaseBlockItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumBlocks extends IRegistryHandler {

	//Ore Blocks
	public static final RegistryObject<OreBlock> greensapphireore_block = BLOCKS.register("greensapphireore", () -> new OreBlock(Block.Properties.of(Material.STONE)
			.sound(SoundType.STONE).strength(25.0F, 1000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.DIAMOND.getLevel()).requiresCorrectToolForDrops()));
	public static final RegistryObject<OreBlock> blooddiamondore_block = BLOCKS.register("blooddiamondore", () -> new OreBlock(Block.Properties.of(Material.STONE)
			.strength(35.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.GreenSapphireTool.getLevel()).requiresCorrectToolForDrops()));
	public static final RegistryObject<OreBlock> voiddiamondore_block = BLOCKS.register("voiddiamondore", () -> new OreBlock(Block.Properties.of(Material.STONE)
			.strength(45.0F, 36000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.BloodDiamondTool.getLevel()).requiresCorrectToolForDrops()));
	public static final RegistryObject<OreBlock> vanillarandomore_block = BLOCKS.register("vanillarandomore", () -> new OreBlock(Block.Properties.of(Material.STONE)
			.strength(4.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.VoidDiamondTool.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> modrandomore_block = BLOCKS.register("modrandomore", () -> new OreBlock(Block.Properties.of(Material.STONE)
    		.strength(4.0F, 2000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.VoidDiamondTool.getLevel()).requiresCorrectToolForDrops()));
    //Ore Blocks Items
    public static final RegistryObject<Item> greensapphireore_block_item = ITEMS.register("greensapphireore", () -> new BaseBlockItem(greensapphireore_block.get()));
    public static final RegistryObject<Item> blooddiamondore_block_item = ITEMS.register("blooddiamondore", () -> new BaseBlockItem(blooddiamondore_block.get()));
    public static final RegistryObject<Item> voiddiamondore_block_item = ITEMS.register("voiddiamondore", () -> new BaseBlockItem(voiddiamondore_block.get()));
    public static final RegistryObject<Item> vanillarandomore_block_item = ITEMS.register("vanillarandomore", () -> new BaseBlockItem(vanillarandomore_block.get()));
    public static final RegistryObject<Item> modrandomore_block_item = ITEMS.register("modrandomore", () -> new BaseBlockItem(modrandomore_block.get()));
    
    //Ingot Blocks
    public static final RegistryObject<Block> greensapphire_block = BLOCKS.register("greensapphireblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(25.0F, 9000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.DIAMOND.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> blooddiamond_block = BLOCKS.register("blooddiamondblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(35.0F, 18000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.GreenSapphireTool.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> voiddiamond_block = BLOCKS.register("voiddiamondblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(45.0F, 36000.0F).harvestTool(ToolType.PICKAXE).harvestLevel(EnumToolMaterial.BloodDiamondTool.getLevel()).requiresCorrectToolForDrops()));
    //Ingot Block Items
    public static final RegistryObject<Item> greensapphire_block_item = ITEMS.register("greensapphireblock", () -> new BaseBlockItem(greensapphire_block.get()));
    public static final RegistryObject<Item> blooddiamond_block_item = ITEMS.register("blooddiamondblock", () -> new BaseBlockItem(blooddiamond_block.get()));
    public static final RegistryObject<Item> voiddiamond_block_item = ITEMS.register("voiddiamondblock", () -> new BaseBlockItem(voiddiamond_block.get()));
    
    //Mob Drop Ores
    public static final RegistryObject<OreBlock> boneore_block = BLOCKS.register("boneore", () -> new OreBlock(Block.Properties.of(Material.STONE)
    		.strength(1.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> fleshore_block = BLOCKS.register("fleshore", () -> new OreBlock(Block.Properties.of(Material.STONE)
    		.strength(1.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> sulfurore_block = BLOCKS.register("sulfurore", () -> new OreBlock(Block.Properties.of(Material.STONE)
    		.strength(1.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));;
    //Mob Drop Ore Items
    public static final RegistryObject<Item> boneore_block_item = ITEMS.register("boneore", () -> new BaseBlockItem(boneore_block.get()));
    public static final RegistryObject<Item> fleshore_block_item = ITEMS.register("fleshore", () -> new BaseBlockItem(fleshore_block.get()));
    public static final RegistryObject<Item> sulfurore_block_item = ITEMS.register("sulfurore", () -> new BaseBlockItem(sulfurore_block.get()));
    
    //Mob Drop Blocks
    public static final RegistryObject<Block> bone_block = BLOCKS.register("boneblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(4.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> flesh_block = BLOCKS.register("fleshblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(4.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> sulfur_block = BLOCKS.register("sulfurblock", () -> new Block(Block.Properties.of(Material.METAL)
    		.strength(4.0F, 15.0F).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.WOOD.getLevel()).requiresCorrectToolForDrops()));
    //Mob Drop Block items
    public static final RegistryObject<Item> bone_block_item = ITEMS.register("boneblock", () -> new BaseBlockItem(bone_block.get()));
    public static final RegistryObject<Item> flesh_block_item = ITEMS.register("fleshblock", () -> new BaseBlockItem(flesh_block.get()));
    public static final RegistryObject<Item> sulfur_block_item = ITEMS.register("sulfurblock", () -> new BaseBlockItem(sulfur_block.get()));
    
    //Wall & Floor Blocks
    public static final RegistryObject<TorchBlock> greensapphiretorch_block = BLOCKS.register("greensapphiretorch", () -> new TorchBlock(AbstractBlock.Properties.of(Material.DECORATION)
    		.noCollission().instabreak().lightLevel((p_235469_0_) -> {return 14;}).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final RegistryObject<WallTorchBlock> wall_greensapphiretorch_block = BLOCKS.register("wall_greensapphiretorch", () -> new WallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION)
    		.noCollission().instabreak().lightLevel((p_235469_0_) -> {return 14;}).sound(SoundType.WOOD).dropsLike(greensapphiretorch_block.get()), ParticleTypes.FLAME));
    //Wall & Floor Block Items
    public static final RegistryObject<WallOrFloorItem> greensapphiretorch_block_item = ITEMS.register("greensapphiretorch", () -> new WallOrFloorItem(greensapphiretorch_block.get(), wall_greensapphiretorch_block.get(), (new Item.Properties().tab(Arcanum.arcanum))));

    //Misc Blocks
    public static final RegistryObject<Block> greensapphirecoal_block = BLOCKS.register("greensapphirecoalblock", () -> new Block(Block.Properties.of(Material.STONE)
    		.strength(20.0F, 9000.0F)));
    //Misc Block Items
    public static final RegistryObject<Item> greensapphirecoal_block_item = ITEMS.register("greensapphirecoalblock", () -> new BaseBlockItem(greensapphirecoal_block.get()));
    
    //FluidBlocks
   // @SuppressWarnings("deprecation")
	//public static final RegistryObject<Block> BEER = BLOCKS.register("beer", () -> new FlowingFluidBlock((FlowingFluid) ArcanumFluids.BEER.get(), AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    //Fluid Blocks Items
   // public static final RegistryObject<BucketItem> BEER_BUCKET = ITEMS.register("beer_bucket", () -> new BucketItemBase(ArcanumFluids.BEER, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(Arcanum.arcanum)));
    //Tile Entity
    //TileEntity Items

}
