package com.hellbreecher.arcanum.common;

import com.hellbreecher.arcanum.common.handler.IProxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CommonProxy implements IProxy{

    public void init() {
    	
    }

	public World getClientWorld() {
		throw new IllegalStateException("This should be Client Side only!");
	}

	public PlayerEntity getClientPlayer() {
		throw new IllegalStateException("This should be Client Side only!");
	}
    
}
