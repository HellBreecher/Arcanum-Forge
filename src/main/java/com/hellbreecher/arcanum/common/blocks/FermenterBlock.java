package com.hellbreecher.arcanum.common.blocks;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FermenterBlock extends AbstractFurnaceBlock{

	protected FermenterBlock() {
		super(BlockBehaviour.Properties.of()
	    		.sound(SoundType.STONE)
	    		.strength(1.0F, 15.0F)
	    		.requiresCorrectToolForDrops()
	    		);
	}



	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void openContainer(Level p_48690_, BlockPos p_48691_, Player p_48692_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected MapCodec<? extends AbstractFurnaceBlock> codec() {
		// TODO Auto-generated method stub
		return null;
	}}
