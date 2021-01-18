package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.fluids.BeerFluid;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumFluids extends IRegistryHandler {

	//public static RegistryObject<Fluid> BEER = FLUIDS.register("Beer", () -> new BeerFluid.Source());
	//public static RegistryObject<FlowingFluid> FLOWING_BEER = FLUIDS.register("Flowing_Beer", () ->new BeerFluid.Flowing());
	
}
