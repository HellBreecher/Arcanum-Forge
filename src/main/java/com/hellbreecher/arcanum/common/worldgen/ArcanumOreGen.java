package com.hellbreecher.arcanum.common.worldgen;

import java.util.List;

import com.hellbreecher.arcanum.common.worldgen.features.ArcanumPlacedFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ArcanumOreGen {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ArcanumPlacedFeatures.greensapphireoreplaced);
        base.add(ArcanumPlacedFeatures.blooddiamondoreplaced);
        base.add(ArcanumPlacedFeatures.voiddiamondoreplaced);
        
        base.add(ArcanumPlacedFeatures.vanillarandomoreplaced);
        base.add(ArcanumPlacedFeatures.modrandomoreplaced);
        
        base.add(ArcanumPlacedFeatures.fleshoreplaced);
        base.add(ArcanumPlacedFeatures.boneoreplaced);
        base.add(ArcanumPlacedFeatures.sulfuroreplaced);

    }
	
}
