package com.hellbreecher.arcanum.common.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreWorldGen {
	
	public static void generateOres(final BiomeLoadingEvent event) {
		//Mod Ingot Ores
		blooddiamondore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.blooddiamondore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.blooddiamondore_block.get().getDefaultState(), 4/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 16/**max y*/)).func_242728_a().func_242731_b(2/**veincount*/)));
		voiddiamondore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.voiddiamondore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.voiddiamondore_block.get().getDefaultState(), 4/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 12/**max y*/)).func_242728_a().func_242731_b(1/**veincount*/)));
		
		//Random Ores
		vanillarandomore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.vanillarandomore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.vanillarandomore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		modrandomore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.modrandomore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.modrandomore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(2/**veincount*/)));
		
		//Mob Drop Ores
		boneore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.boneore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.boneore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		fleshore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.fleshore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.fleshore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		sulfurore_feature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ArcanumBlocks.sulfurore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.sulfurore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));

		for(OreType ore : OreType.values()) {
			OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
					OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
			
			// bottom Offset (min height)
			// maximum (minHeight + max = top level, vertical height expansion)
			// topOffset (subtract from max to get actual top)
			// ore exists from bottom offset to (bottom offset + max - top offset)
			ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configured(
					new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));
			
			ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
			
			event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
					
		}
		
	}
	
	private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(), Feature.ORE.configured(oreFeatureConfig).place(ISeedReader reader, null, null, null));
	}

}
