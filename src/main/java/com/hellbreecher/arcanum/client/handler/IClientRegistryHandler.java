package com.hellbreecher.arcanum.client.handler;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IClientRegistryHandler {

	public static final DeferredRegister<ParticleType<?>> PARTICLE = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Reference.MODID);
	
	public static void registryInit() {
		Arcanum.Logger.info("Arcanum: Particles Registered");
	}
}
