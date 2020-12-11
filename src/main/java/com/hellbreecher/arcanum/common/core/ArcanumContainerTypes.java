package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.blocks.container.containerArcFurnace;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumContainerTypes extends IRegistryHandler {
	
	//Container Types
	public static final RegistryObject<ContainerType<containerArcFurnace>> arcfurnace = CONTAINERS
			.register("arcfurnace_container", () -> new ContainerType<>(containerArcFurnace::createArcFurnace));
	
}
