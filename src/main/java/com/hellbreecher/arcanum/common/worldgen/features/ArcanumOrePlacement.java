package com.hellbreecher.arcanum.common.worldgen.features;

import java.util.List;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ArcanumOrePlacement {

    public static List<PlacementModifier> orePlacement(PlacementModifier mod1, PlacementModifier mod2) {
        return List.of(mod1, InSquarePlacement.spread(), mod2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int mod1, PlacementModifier mod2) {
        return orePlacement(CountPlacement.of(mod1), mod2);
    }

    public static List<PlacementModifier> rareOrePlacement(int mod1, PlacementModifier mod2) {
        return orePlacement(RarityFilter.onAverageOnceEvery(mod1), mod2);
    }	
	
}
