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
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreWorldGen {

	// Mod Ingot Ores
	private static ConfiguredFeature<?, ?> greensapphireore_feature, blooddiamondore_feature, voiddiamondore_feature;
	//Random Ores
	private static ConfiguredFeature<?, ?> vanillarandomore_feature, modrandomore_feature;
	//Mob Drop Ores
	private static ConfiguredFeature<?, ?> boneore_feature, fleshore_feature, sulfurore_feature;
	
	public static void init() {
		//Mod Ingot Ores
		greensapphireore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.greensapphireore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.greensapphireore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		blooddiamondore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.blooddiamondore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.blooddiamondore_block.get().getDefaultState(), 4/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 16/**max y*/)).func_242728_a().func_242731_b(2/**veincount*/)));
		voiddiamondore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.voiddiamondore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.voiddiamondore_block.get().getDefaultState(), 4/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 12/**max y*/)).func_242728_a().func_242731_b(1/**veincount*/)));
		
		//Random Ores
		vanillarandomore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.vanillarandomore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.vanillarandomore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		modrandomore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.modrandomore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.modrandomore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(2/**veincount*/)));
		
		//Mob Drop Ores
		boneore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.boneore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.boneore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		fleshore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.fleshore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.fleshore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));
		sulfurore_feature = Registry.register(WorldGenRegistries.field_243653_e, ArcanumBlocks.sulfurore_block.getId(), Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ArcanumBlocks.sulfurore_block.get().getDefaultState(), 8/**vein size*/)).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(0, 0, 256/**max y*/)).func_242728_a().func_242731_b(4/**veincount*/)));

	}
	
	public static void setupGeneralWorldGen() {
		for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.field_243657_i.func_239659_c_()) {
			if(!biome.getValue().getCategory().equals(Biome.Category.NETHER) && !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
				//Mod Ingot Ores
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						greensapphireore_feature);
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						blooddiamondore_feature);
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						voiddiamondore_feature);
				
				//Random Ores
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						vanillarandomore_feature);
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						modrandomore_feature);
				
				//Mob Drop Ores
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						boneore_feature);
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						fleshore_feature);
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, 
						sulfurore_feature);
			}
		}
	}
	
	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> feature) {
		List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(biome.func_242440_e().func_242498_c());
		while (biomeFeatures.size() <= decoration.ordinal()) {
			biomeFeatures.add(Lists.newArrayList());
		}
		List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
		features.add(() -> feature);
		biomeFeatures.set(decoration.ordinal(), features);
		
		ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.func_242440_e(), biomeFeatures, "field_242484_f");
	}
}
