package com.hellbreecher.arcanum.common.core;

import com.hellbreecher.arcanum.common.handler.IRecipeHandler;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ArcanumSmelting extends IRecipeHandler {
        
    private static ItemStack AppleCider = new ItemStack(ArcanumFood.itemAppleCider);
    private static ItemStack WarmAppleCider = new ItemStack(ArcanumFood.itemWarmAppleCider);
    private static ItemStack Toast = new ItemStack(ArcanumFood.itemToast);
    private static ItemStack Bread = new ItemStack(Items.BREAD);
    private static ItemStack GreenSapphireOre = new ItemStack(ArcanumBlocks.blockGreenSapphireOre);
    private static ItemStack BloodDiamondOre = new ItemStack(ArcanumBlocks.blockBloodDiamondOre);
    private static ItemStack VoidDiamondOre = new ItemStack(ArcanumBlocks.blockVoidDiamondOre);
    private static ItemStack GreenSapphire = new ItemStack(ArcanumItems.itemGreenSapphire);
    private static ItemStack BloodDiamond = new ItemStack(ArcanumItems.itemBloodDiamond);
    private static ItemStack VoidDiamond = new ItemStack(ArcanumItems.itemVoidDiamond);

    public static void foodSmelting() {
        addFurnaceRecipeItem(AppleCider.getItem(), WarmAppleCider, 1.0F);
        addFurnaceRecipeItem(Bread.getItem(), Toast, 1.0F);
    }

    public static void oreSmelting() {
        addFurnaceRecipeItem(GreenSapphireOre.getItem(), GreenSapphire, 1.0F);
        addFurnaceRecipeItem(BloodDiamondOre.getItem(), BloodDiamond, 1.0F);
        addFurnaceRecipeItem(VoidDiamondOre.getItem(), VoidDiamond, 1.0F);
    }
}
