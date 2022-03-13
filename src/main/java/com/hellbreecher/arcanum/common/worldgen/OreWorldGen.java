package com.hellbreecher.arcanum.common.worldgen;

import java.util.Arrays;

import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreWorldGen {
	
	public static void generateOres(final BiomeLoadingEvent event) {
		spawnOreInAllBiomes(OreType.GreenSapphireOre, event, Dimension.OVERWORLD.toString());
		spawnOreInAllBiomes(OreType.BloodDiamondOre, event, Dimension.OVERWORLD.toString());
		spawnOreInAllBiomes(OreType.VoidDiamondOre, event, Dimension.OVERWORLD.toString());

		spawnOreInAllBiomes(OreType.VanillaRandOre, event, Dimension.OVERWORLD.toString());
		spawnOreInAllBiomes(OreType.ModRandomOre, event, Dimension.OVERWORLD.toString());
		
		spawnOreInAllBiomes(OreType.FleshOre, event, Dimension.OVERWORLD.toString());
		spawnOreInAllBiomes(OreType.SulfureOre, event, Dimension.OVERWORLD.toString());
		spawnOreInAllBiomes(OreType.BoneOre, event, Dimension.OVERWORLD.toString());


	}
	
	private static OreFeatureConfig getOverworldFeatureConfig(OreType ore) { 
		return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
	}
	
	private static OreFeatureConfig getNetherFeatureConfig(OreType ore) { 
		return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
				ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
	}
	
	private static OreFeatureConfig getEndFeatureConfig(OreType ore) { 
		return new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
				ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
	}
	
	//vanilla dimension
	private static ConfiguredFeature<?, ?> makeOreFeature(OreType ore, String dimensionToSpawnIn) {
		OreFeatureConfig oreFeatureConfig = null;
		
		if(dimensionToSpawnIn.equals(Dimension.OVERWORLD.toString())) {
			oreFeatureConfig = getOverworldFeatureConfig(ore);
		}else if(dimensionToSpawnIn.equals(Dimension.NETHER.toString())) {
			oreFeatureConfig = getNetherFeatureConfig(ore);
		}else if(dimensionToSpawnIn.equals(Dimension.END.toString())) {
			oreFeatureConfig = getEndFeatureConfig(ore);
		}
		
		ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configured(
				new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));
		
		return registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
	}


    private static void spawnOreInOverworldInGivenBiomes(OreType ore, final BiomeLoadingEvent event, Biome... biomesToSpawnIn) {
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());

        ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configured(
				new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

        ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

        if (Arrays.stream(biomesToSpawnIn).anyMatch(b -> b.getRegistryName().equals(event.getName()))) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
        }
    }

    private static void spawnOreInOverworldInAllBiomes(OreType ore, final BiomeLoadingEvent event) {
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());

        ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configured(
				new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

        ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
    }

    private static void spawnOreInSpecificModBiome(Biome biomeToSpawnIn, OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
        if(event.getName().toString().contains(biomeToSpawnIn.getRegistryName().toString())) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
        }
    }

    private static void spawnOreInSpecificBiome(RegistryKey<Biome> biomeToSpawnIn, OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
        if(event.getName().toString().contains(biomeToSpawnIn.getRegistryName().toString())) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
        }
    }

    private static void spawnOreInAllBiomes(OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                makeOreFeature(currentOreType, dimension));
    }

    private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                Feature.ORE.configured(oreFeatureConfig).decorated(configuredPlacement)
                        .squared().count(ore.getVeinsPerChunk()));
    }
}
