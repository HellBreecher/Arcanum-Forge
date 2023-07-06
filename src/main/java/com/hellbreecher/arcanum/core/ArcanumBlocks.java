package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.common.blocks.BaseBlockItem;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumBlocks extends IRegistryHandler {

	//Ore Blocks
	public static final RegistryObject<Block> greensapphireore_block = BLOCKS.register("greensapphireore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(25.0F, 100.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> blooddiamondore_block = BLOCKS.register("blooddiamondore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(35.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> voiddiamondore_block = BLOCKS.register("voiddiamondore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(45.0F, 360.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> vanillarandomore_block = BLOCKS.register("vanillarandomore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(4.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> modrandomore_block = BLOCKS.register("modrandomore", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.STONE).strength(4.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    
	public static final RegistryObject<Block> deepslategreensapphireore_block = BLOCKS.register("deepslate_greensapphireore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(25.0F, 100.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> deepslateblooddiamondore_block = BLOCKS.register("deepslate_blooddiamondore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(35.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> deepslatevoiddiamondore_block = BLOCKS.register("deepslate_voiddiamondore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(45.0F, 360.0F).destroyTime(3f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> deepslatevanillarandomore_block = BLOCKS.register("deepslate_vanillarandomore", () -> new Block(BlockBehaviour.Properties.of()
			.sound(SoundType.STONE).strength(4.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> deepslatemodrandomore_block = BLOCKS.register("deepslate_modrandomore", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.STONE).strength(4.0F, 200.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    //Ore Blocks Items
    public static final RegistryObject<Item> greensapphireore_block_item = ITEMS.register("greensapphireore", () -> new BaseBlockItem(greensapphireore_block.get()));
    public static final RegistryObject<Item> blooddiamondore_block_item = ITEMS.register("blooddiamondore", () -> new BaseBlockItem(blooddiamondore_block.get()));
    public static final RegistryObject<Item> voiddiamondore_block_item = ITEMS.register("voiddiamondore", () -> new BaseBlockItem(voiddiamondore_block.get()));
    public static final RegistryObject<Item> vanillarandomore_block_item = ITEMS.register("vanillarandomore", () -> new BaseBlockItem(vanillarandomore_block.get()));
    public static final RegistryObject<Item> modrandomore_block_item = ITEMS.register("modrandomore", () -> new BaseBlockItem(modrandomore_block.get()));
    
    public static final RegistryObject<Item> deepslategreensapphireore_block_item = ITEMS.register("deepslate_greensapphireore", () -> new BaseBlockItem(deepslategreensapphireore_block.get()));
    public static final RegistryObject<Item> deepslateblooddiamondore_block_item = ITEMS.register("deepslate_blooddiamondore", () -> new BaseBlockItem(deepslateblooddiamondore_block.get()));
    public static final RegistryObject<Item> deepslatevoiddiamondore_block_item = ITEMS.register("deepslate_voiddiamondore", () -> new BaseBlockItem(deepslatevoiddiamondore_block.get()));
    public static final RegistryObject<Item> deepslatevanillarandomore_block_item = ITEMS.register("deepslate_vanillarandomore", () -> new BaseBlockItem(deepslatevanillarandomore_block.get()));
    public static final RegistryObject<Item> deepslatemodrandomore_block_item = ITEMS.register("deepslate_modrandomore", () -> new BaseBlockItem(deepslatemodrandomore_block.get()));
    
    //Ingot Blocks
    public static final RegistryObject<Block> greensapphire_block = BLOCKS.register("greensapphireblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(25.0F, 900.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> blooddiamond_block = BLOCKS.register("blooddiamondblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(35.0F, 180.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> voiddiamond_block = BLOCKS.register("voiddiamondblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(45.0F, 360.0F).destroyTime(3f).requiresCorrectToolForDrops()));
    //Ingot Block Items
    public static final RegistryObject<Item> greensapphire_block_item = ITEMS.register("greensapphireblock", () -> new BaseBlockItem(greensapphire_block.get()));
    public static final RegistryObject<Item> blooddiamond_block_item = ITEMS.register("blooddiamondblock", () -> new BaseBlockItem(blooddiamond_block.get()));
    public static final RegistryObject<Item> voiddiamond_block_item = ITEMS.register("voiddiamondblock", () -> new BaseBlockItem(voiddiamond_block.get()));
    
    //Mob Drop Ores
    public static final RegistryObject<Block> boneore_block = BLOCKS.register("boneore", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.STONE).strength(1.0F, 15.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> fleshore_block = BLOCKS.register("fleshore", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.STONE).strength(1.0F, 15.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> sulfurore_block = BLOCKS.register("sulfurore", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.STONE).strength(1.0F, 15.0F).requiresCorrectToolForDrops()));;
    //Mob Drop Ore Items
    public static final RegistryObject<Item> boneore_block_item = ITEMS.register("boneore", () -> new BaseBlockItem(boneore_block.get()));
    public static final RegistryObject<Item> fleshore_block_item = ITEMS.register("fleshore", () -> new BaseBlockItem(fleshore_block.get()));
    public static final RegistryObject<Item> sulfurore_block_item = ITEMS.register("sulfurore", () -> new BaseBlockItem(sulfurore_block.get()));
    
    //Mob Drop Blocks
    public static final RegistryObject<Block> bone_block = BLOCKS.register("boneblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(4.0F, 15.0F).instabreak()));
    public static final RegistryObject<Block> flesh_block = BLOCKS.register("fleshblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(4.0F, 15.0F).instabreak()));
    public static final RegistryObject<Block> sulfur_block = BLOCKS.register("sulfurblock", () -> new Block(BlockBehaviour.Properties.of()
    		.sound(SoundType.METAL).strength(4.0F, 15.0F).instabreak()));
    //Mob Drop Block items
    public static final RegistryObject<Item> bone_block_item = ITEMS.register("boneblock", () -> new BaseBlockItem(bone_block.get()));
    public static final RegistryObject<Item> flesh_block_item = ITEMS.register("fleshblock", () -> new BaseBlockItem(flesh_block.get()));
    public static final RegistryObject<Item> sulfur_block_item = ITEMS.register("sulfurblock", () -> new BaseBlockItem(sulfur_block.get()));
    
    //Wall & Floor Blocks
    public static final RegistryObject<TorchBlock> greensapphiretorch_block = BLOCKS.register("greensapphiretorch", () -> new TorchBlock(BlockBehaviour.Properties.of()
    		.noCollission().instabreak().lightLevel((p_50886_) -> {return 14;}).sound(SoundType.WOOD), ParticleTypes.FLAME));
    public static final RegistryObject<WallTorchBlock> wall_greensapphiretorch_block = BLOCKS.register("wall_greensapphiretorch", () -> new WallTorchBlock(BlockBehaviour.Properties.of()
    		.noCollission().instabreak().lightLevel((p_50886_) -> {return 14;}).sound(SoundType.WOOD).dropsLike(greensapphiretorch_block.get()).pushReaction(PushReaction.DESTROY), ParticleTypes.FLAME));

    //Standing & Wall Block Items
    public static final RegistryObject<StandingAndWallBlockItem> greensapphiretorch_block_item = ITEMS.register("greensapphiretorch", () -> new StandingAndWallBlockItem(greensapphiretorch_block.get(), wall_greensapphiretorch_block.get(), new Item.Properties(), Direction.DOWN));
    
    //Misc Blocks
    public static final RegistryObject<Block> greensapphirecoal_block = BLOCKS.register("greensapphirecoalblock", () -> new Block(BlockBehaviour.Properties.of()
    		.strength(20.0F, 50.0F).destroyTime(1f).requiresCorrectToolForDrops())) ;
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
