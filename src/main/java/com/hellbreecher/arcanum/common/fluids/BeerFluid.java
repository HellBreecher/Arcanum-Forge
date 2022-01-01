package com.hellbreecher.arcanum.common.fluids;

import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.core.ArcanumFluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class BeerFluid{
/**
	public Fluid getFlowingFluid() {
		return ArcanumFluids.FLOWING_BEER.get();
	}

	public Fluid getStillFluid() {
		return ArcanumFluids.BEER.get();
	}

	protected boolean canSourcesMultiply() {
		return false;
	}

	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
		Block.spawnDrops(state, worldIn, pos, tileentity);
	}

	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 2;
	}

	public Item getFilledBucket() {
		return null;
	}

	protected boolean canDisplace(FluidState state, IBlockReader reader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}

	public int getTickRate(IWorldReader reader) {
		return 5;
	}

	protected float getExplosionResistance() {
		return 100.0F;
	}

	protected BlockState getBlockState(FluidState state) {
		return ArcanumBlocks.BEER.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	public boolean isSource(FluidState state) {
		return false;
	}

	public int getLevel(FluidState state) {
		return 8;
	}

	public static class Flowing extends BeerFluid {
		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		public int getLevel(FluidState p_207192_1_) {
			return p_207192_1_.get(LEVEL_1_8);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
	
	public static class Source extends BeerFluid {
		public int getLevel(FluidState p_207192_1_) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}
*/
}
