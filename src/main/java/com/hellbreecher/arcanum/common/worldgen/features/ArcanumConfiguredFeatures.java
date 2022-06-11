package com.hellbreecher.arcanum.common.worldgen.features;

import java.util.List;

import com.hellbreecher.arcanum.core.ArcanumBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ArcanumConfiguredFeatures {

	//ingot ores
	public static final List<OreConfiguration.TargetBlockState> overworldgreensapphireore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.greensapphireore_block.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ArcanumBlocks.deepslategreensapphireore_block.get().defaultBlockState())
			);

	public static final List<OreConfiguration.TargetBlockState> overworldblooddiamondore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.blooddiamondore_block.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ArcanumBlocks.deepslateblooddiamondore_block.get().defaultBlockState())
			);

	public static final List<OreConfiguration.TargetBlockState> overworldvoiddiamondore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.voiddiamondore_block.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ArcanumBlocks.deepslatevoiddiamondore_block.get().defaultBlockState())
			);
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> greensapphireore = FeatureUtils.register("greensapphireore", Feature.ORE, new OreConfiguration(overworldgreensapphireore, 8));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> blooddiamondore = FeatureUtils.register("blooddiamondore", Feature.ORE, new OreConfiguration(overworldblooddiamondore, 8));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> voiddiamodnore = FeatureUtils.register("voiddiamondore", Feature.ORE, new OreConfiguration(overworldvoiddiamondore, 8));

	//random ores
	public static final List<OreConfiguration.TargetBlockState> overworldvanillarandomore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.vanillarandomore_block.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ArcanumBlocks.deepslatevanillarandomore_block.get().defaultBlockState())
			);

	public static final List<OreConfiguration.TargetBlockState> overworldmodrandomore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.modrandomore_block.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ArcanumBlocks.deepslatemodrandomore_block.get().defaultBlockState())
			);
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> vanillarandomore = FeatureUtils.register("vanillarandomore", Feature.ORE, new OreConfiguration(overworldvanillarandomore, 5));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> modrandomore = FeatureUtils.register("modrandomore", Feature.ORE, new OreConfiguration(overworldmodrandomore, 5));

	//mob drop ores
	public static final List<OreConfiguration.TargetBlockState> overworldfleshore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.fleshore_block.get().defaultBlockState())
			);
	public static final List<OreConfiguration.TargetBlockState> overworldboneore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.boneore_block.get().defaultBlockState())
			);
	public static final List<OreConfiguration.TargetBlockState> overworldsulfurore = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ArcanumBlocks.sulfurore_block.get().defaultBlockState())
			);
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> fleshore = FeatureUtils.register("fleshore", Feature.ORE, new OreConfiguration(overworldfleshore, 5));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> boneore = FeatureUtils.register("boneore", Feature.ORE, new OreConfiguration(overworldboneore, 5));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> sulfurore = FeatureUtils.register("sulfurore", Feature.ORE, new OreConfiguration(overworldsulfurore, 5));

}
