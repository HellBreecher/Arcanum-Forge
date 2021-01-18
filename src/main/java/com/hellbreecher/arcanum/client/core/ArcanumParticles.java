package com.hellbreecher.arcanum.client.core;

import com.hellbreecher.arcanum.client.handler.IClientRegistryHandler;
import com.hellbreecher.arcanum.client.particles.GreenFlameParticle;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumParticles extends IClientRegistryHandler {
	
	public static final RegistryObject<BasicParticleType> GreenFlame = PARTICLE.register("green_flame_particle", () -> new BasicParticleType(true));
	
	@SuppressWarnings("resource")
	public static void registerparticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(GreenFlame.get(), GreenFlameParticle.Factory::new);
	}
	
}
