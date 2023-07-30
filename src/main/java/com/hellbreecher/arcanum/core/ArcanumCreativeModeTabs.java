package com.hellbreecher.arcanum.core;

import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArcanumCreativeModeTabs extends IRegistryHandler{	
	
	public static final RegistryObject<CreativeModeTab> ArcanumTab = ARCANUMTABS.register("arcanum",() -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(ArcanumItems.infernaldiamond.get()))
			.title(Component.translatable(new String("Arcanum")))
			.displayItems((parameters, output) -> {
			//Armor
				//GreenSapphire
				output.accept(ArcanumArmor.greensapphirehelmet.get());
				output.accept(ArcanumArmor.greensapphirechestplate.get());
				output.accept(ArcanumArmor.greensapphireleggings.get());
				output.accept(ArcanumArmor.greensapphireboots.get());
				//BloodDiamond
				output.accept(ArcanumArmor.blooddiamondhelmet.get());
				output.accept(ArcanumArmor.blooddiamondchestplate.get());
				output.accept(ArcanumArmor.blooddiamondleggings.get());
				output.accept(ArcanumArmor.blooddiamondboots.get());
				//VoidDiamond
				output.accept(ArcanumArmor.voiddiamondhelmet.get());
				output.accept(ArcanumArmor.voiddiamondchestplate.get());
				output.accept(ArcanumArmor.voiddiamondleggings.get());
				output.accept(ArcanumArmor.voiddiamondboots.get());
				//InfernalDiamond
				output.accept(ArcanumArmor.infernaldiamondhelmet.get());
				output.accept(ArcanumArmor.infernaldiamondchestplate.get());
				output.accept(ArcanumArmor.infernaldiamondleggings.get());
				output.accept(ArcanumArmor.infernaldiamondboots.get());
				//Infernal
				output.accept(ArcanumArmor.infernalhelmet.get());
				output.accept(ArcanumArmor.infernalchestplate.get());
				output.accept(ArcanumArmor.infernalleggings.get());
				output.accept(ArcanumArmor.infernalboots.get());
			//Blocks
				//Ores
				output.accept(ArcanumBlocks.greensapphireore_block.get());
				output.accept(ArcanumBlocks.blooddiamondore_block.get());
				output.accept(ArcanumBlocks.voiddiamondore_block.get());
				output.accept(ArcanumBlocks.vanillarandomore_block.get());
				output.accept(ArcanumBlocks.modrandomore_block.get());
				output.accept(ArcanumBlocks.deepslategreensapphireore_block.get());
				output.accept(ArcanumBlocks.deepslateblooddiamondore_block.get());
				output.accept(ArcanumBlocks.deepslatevoiddiamondore_block.get());
				output.accept(ArcanumBlocks.deepslatevanillarandomore_block.get());
				output.accept(ArcanumBlocks.deepslatemodrandomore_block.get());
				
				//Ingot
				output.accept(ArcanumBlocks.greensapphire_block.get());
				output.accept(ArcanumBlocks.blooddiamond_block.get());
				output.accept(ArcanumBlocks.voiddiamond_block.get());
				
				//Mob Drop
				output.accept(ArcanumBlocks.boneore_block.get());
				output.accept(ArcanumBlocks.fleshore_block.get());
				output.accept(ArcanumBlocks.sulfurore_block.get());
				output.accept(ArcanumBlocks.bone_block.get());
				output.accept(ArcanumBlocks.flesh_block.get());
				output.accept(ArcanumBlocks.sulfur_block.get());
				
				//Fuel
				output.accept(ArcanumBlocks.greensapphirecoal_block.get());
				
				//Wall & Floor
				output.accept(ArcanumBlocks.greensapphiretorch_block.get());
			//Food
				//Eat
				output.accept(ArcanumFood.crushedapple.get());
				output.accept(ArcanumFood.toast.get());
				//Drinks
				output.accept(ArcanumFood.cortonwine.get());
				output.accept(ArcanumFood.unfermentedbeer.get());
				output.accept(ArcanumFood.fermentedbeer.get());
				output.accept(ArcanumFood.applecider.get());
				output.accept(ArcanumFood.warmapplecider.get());
				//Mix
				output.accept(ArcanumFood.mountaindew.get());
			//Items
				//ingots
				output.accept(ArcanumItems.greensapphire.get());
				output.accept(ArcanumItems.blooddiamond.get());
				output.accept(ArcanumItems.voiddiamond.get());
				
				//Magical Ingots
				output.accept(ArcanumItems.infernaldiamond.get());
				
				//Misc
				output.accept(ArcanumItems.quartzstick.get());
				output.accept(ArcanumItems.blooddiamondstick.get());
				output.accept(ArcanumItems.emptycan.get());
				output.accept(ArcanumItems.redcup.get());
				output.accept(ArcanumItems.mountaindewmix.get());
				
				//Crafting
				output.accept(ArcanumItems.hammer.get());
				
				//Fuels
				output.accept(ArcanumItems.greensapphirecoal.get());
			//Tools
				//Pickaxe
				output.accept(ArcanumTools.greensapphirepickaxe.get());
				output.accept(ArcanumTools.blooddiamondpickaxe.get());
				output.accept(ArcanumTools.voiddiamondpickaxe.get());
				output.accept(ArcanumTools.infernaldiamondpickaxe.get());
				output.accept(ArcanumTools.infernalpickaxe.get());
				//Axe
				output.accept(ArcanumTools.greensapphireaxe.get());
				output.accept(ArcanumTools.blooddiamondaxe.get());
				output.accept(ArcanumTools.voiddiamondaxe.get());
				output.accept(ArcanumTools.infernaldiamondaxe.get());
				output.accept(ArcanumTools.infernalaxe.get());
				//Shovel
				output.accept(ArcanumTools.greensapphireshovel.get());
				output.accept(ArcanumTools.blooddiamondshovel.get());
				output.accept(ArcanumTools.voiddiamondshovel.get());
				output.accept(ArcanumTools.infernaldiamondshovel.get());
				output.accept(ArcanumTools.infernalshovel.get());
				//Shears
				output.accept(ArcanumTools.greensapphireshears.get());
				output.accept(ArcanumTools.blooddiamondshears.get());
				output.accept(ArcanumTools.voiddiamondshears.get());
				output.accept(ArcanumTools.infernaldiamondshears.get());
				output.accept(ArcanumTools.infernalshears.get());
				//Hoe
				output.accept(ArcanumTools.greensapphirehoe.get());
				output.accept(ArcanumTools.blooddiamondhoe.get());
				output.accept(ArcanumTools.voiddiamondhoe.get());
				output.accept(ArcanumTools.infernaldiamondhoe.get());
				output.accept(ArcanumTools.infernalhoe.get());
				//Misc
				output.accept(ArcanumTools.arcwrench.get());
			//Weapons
				//Swords
				output.accept(ArcanumWeapons.greensapphiresword.get());
				output.accept(ArcanumWeapons.blooddiamondsword.get());
				output.accept(ArcanumWeapons.voiddiamondsword.get());
				output.accept(ArcanumWeapons.infernaldiamondsword.get());
				output.accept(ArcanumWeapons.infernalsword.get());
				//BeatingStick
				output.accept(ArcanumWeapons.sapphirebeatingstick.get());
				output.accept(ArcanumWeapons.blooddiamondbeatingstick.get());
				output.accept(ArcanumWeapons.voiddiamondbeatingstick.get());
				output.accept(ArcanumWeapons.infernalbeatingstick.get());
			}).build());
	
}
	