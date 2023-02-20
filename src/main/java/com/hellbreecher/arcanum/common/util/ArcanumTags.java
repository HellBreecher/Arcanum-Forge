package com.hellbreecher.arcanum.common.util;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ArcanumTags {
	
	public static class RegisterBlockTags {
		
		public static final TagKey<Block> NEEDS_GREENSAPPHIRE_TOOL = create("needs_greensapphire_tool");
		public static final TagKey<Block> NEEDS_BLOODDIAMOND_TOOL = create("needs_blooddiamond_tool");
		public static final TagKey<Block> NEEDS_VOIDDIAMOND_TOOL = create("needs_voiddiamond_tool");
		public static final TagKey<Block> NEEDS_INFERNALDIAMOND_TOOL = create("needs_infernaldiamond_tool");
		public static final TagKey<Block> NEEDS_INFERNAL_TOOL = create("needs_infernal_tool");
		
		
		private static TagKey<Block> create(String name) {
			return BlockTags.create(new ResourceLocation(Reference.MODID, name));
		}

		public static TagKey<Block> createForge(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
		
	}
	
	public static class Items {
		
	}
	
    public static TagKey<Block> getTagFromArcanumTier(EnumToolTier tier)
    {
        return switch(tier)
                {
                    case GreenSapphireTool -> ArcanumTags.RegisterBlockTags.NEEDS_GREENSAPPHIRE_TOOL;
                    case BloodDiamondTool -> Tags.Blocks.NEEDS_GOLD_TOOL;
                    case VoidDiamondTool -> BlockTags.NEEDS_STONE_TOOL;
                    case InfernalDiamondTool -> BlockTags.NEEDS_IRON_TOOL;
                    case InfernalTool -> BlockTags.NEEDS_DIAMOND_TOOL;
                    default -> ArcanumTags.RegisterBlockTags.NEEDS_GREENSAPPHIRE_TOOL;
                };
    }
}
