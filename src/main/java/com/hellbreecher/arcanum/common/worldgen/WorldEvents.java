package com.hellbreecher.arcanum.common.worldgen;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class WorldEvents {

	@SubscribeEvent
	public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
		
		OreWorldGen.generateOres(event);
		
		Arcanum.Logger.info("Arcanum: Biome Events Loaded");
	}
	
	
}
