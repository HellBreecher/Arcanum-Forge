package com.hellbreecher.arcanum.common.blocks;

import java.util.Random;

import com.hellbreecher.arcanum.common.blocks.tile.tileentityArcFurnace;
import com.hellbreecher.arcanum.common.core.ArcanumTileEntities;
import com.hellbreecher.arcanum.common.util.ArcanumItemHandler;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class blockArcFurnace extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	
    public blockArcFurnace() {
        super(AbstractBlock.Properties.create(Material.ROCK)
        		.hardnessAndResistance(5.0F, 4000.0F)
        		.harvestTool(ToolType.PICKAXE)
        		.harvestLevel(3)
        		);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
    }
    
    public boolean hasTileEntity(BlockState state) {
    	return true;
    }
    /**
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	return ArcanumTileEntities.arcfurnace_tile_entity.get().create();
    }*/
    
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
    	super.fillStateContainer(builder);
    	builder.add(FACING, LIT);
    }
    
    public BlockState rotate(BlockState state, Rotation rot) {
    	return state.with(FACING, rot.rotate(state.get(FACING)));
    }
    
    public int getLightValue(BlockState state) {
    	return state.get(LIT) ? 1 : 0;
    }
    
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    
	protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
	      TileEntity tileentity = new tileentityArcFurnace();
	      if (tileentity instanceof tileentityArcFurnace) {
	         player.openContainer((INamedContainerProvider)tileentity);
	         
	      }	
	}
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof tileentityArcFurnace) {
				((tileentityArcFurnace)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}
	
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}
	
	public int getComparatorInputOverride(BlockState state, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (stateIn.get(LIT)) {
			double d0 = (double)pos.getX() + 0.5D;
			double d1 = (double)pos.getY();
			double d2 = (double)pos.getZ() + 0.5D;
			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
			
			Direction direction = stateIn.get(FACING);
			Direction.Axis direction$axis = direction.getAxis();
			double d3 = 0.52D;
			double d4 = rand.nextDouble() * 0.6D - 0.3D;
			double d5 = direction$axis == Direction.Axis.X ? (double)direction.getXOffset() * d3 : d4;
			double d6 = rand.nextDouble() * 6.0D / 16.0D;
			double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getZOffset() * d3 : d4;
			worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
			worldIn.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	      if (worldIn.isRemote) {
	          return ActionResultType.SUCCESS;
	       } else {
	          this.interactWith(worldIn, pos, player);
	          return ActionResultType.CONSUME;
	       }
	}
}
