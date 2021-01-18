package com.hellbreecher.arcanum.common.handler;

import net.minecraftforge.common.Tags;

public class IDictionaryRegistry {
	/**
    public static void blankDictionaryRegistry(String name, Item item) {
        Tags.registerOre(name, item);
    }

    public static void blockDictionaryRegistry(String name, Block block) {
        OreDictionary.registerOre("block" + name, block);
    }

    public static void foodDictionaryRegistry(String name, Item food) {
        OreDictionary.registerOre("food" + name, food);
    }

    public static void gemDictionaryRegistry(String name, Item gem) {
        OreDictionary.registerOre("gem" + name, gem);
    }

    public static void ingotDictionaryRegistry(String name, Item ingot) {
        OreDictionary.registerOre("ingot" + name, ingot);
    }

    public static void itemDictionaryRegistry(String name, Item item) {
        OreDictionary.registerOre("item" + name, item);
    }

    public static void materialDictionaryRegistry(String name, Item material) {
        OreDictionary.registerOre("material" + name, material);
    }

    public static void oreDictionaryRegistry(String name, Block ore) {
        OreDictionary.registerOre("ore" + name, ore);
    }

    public static void registerBlocks() {
        blockDictionaryRegistry("GreenSapphire", ArcanumBlocks.blockGreenSapphire);
        blockDictionaryRegistry("BloodDiamond", ArcanumBlocks.blockBloodDiamond);
        blockDictionaryRegistry("VoidDiamond", ArcanumBlocks.blockVoidDiamond);

        oreDictionaryRegistry("Bone", ArcanumBlocks.blockBoneOre);
        oreDictionaryRegistry("Flesh", ArcanumBlocks.blockFleshOre);
        oreDictionaryRegistry("Sulfur", ArcanumBlocks.blockSulfurOre);

        blockDictionaryRegistry("Bone", ArcanumBlocks.blockBone);
        blockDictionaryRegistry("Flesh", ArcanumBlocks.blockFlesh);
        blockDictionaryRegistry("Sulfur", ArcanumBlocks.blockSulfur);

        materialDictionaryRegistry("Torch", Item.getItemFromBlock(ArcanumBlocks.blockGSTorch));
        blankDictionaryRegistry("Torch", Item.getItemFromBlock(ArcanumBlocks.blockGSTorch));
        blockDictionaryRegistry("Coal", ArcanumBlocks.blockGreenSapphireCoal);
    }

    public static void registerFood() {
        foodDictionaryRegistry("CrushedApple", ArcanumFood.itemCrushedApple);
        foodDictionaryRegistry("Toast", ArcanumFood.itemToast);
        foodDictionaryRegistry("Bread", ArcanumFood.itemToast);
    }

    public static void registerItem() {
        gemDictionaryRegistry("GreenSapphire", ArcanumItems.itemGreenSapphire);
        gemDictionaryRegistry("Sapphire", ArcanumItems.itemGreenSapphire);
        gemDictionaryRegistry("BloodDiamond", ArcanumItems.itemBloodDiamond);
        gemDictionaryRegistry("VoidDiamond", ArcanumItems.itemVoidDiamond);

        materialDictionaryRegistry("Stick", ArcanumItems.itemQuartzStick);
        materialDictionaryRegistry("Stick", ArcanumItems.itemBloodDiamondStick);
        materialDictionaryRegistry("Coal", ArcanumItems.itemGSCoal);
        materialDictionaryRegistry("Hammer", ArcanumItems.itemHammer);
        materialDictionaryRegistry("EmptyCan", ArcanumItems.itemEmptyCan);
        materialDictionaryRegistry("bottle", ArcanumItems.itemEmptyCan);
        materialDictionaryRegistry("Cup", ArcanumItems.itemRedCup);

        itemDictionaryRegistry("Coal", ArcanumItems.itemGSCoal);
        itemDictionaryRegistry("Hammer", ArcanumItems.itemHammer);
        itemDictionaryRegistry("EmptyCan", ArcanumItems.itemEmptyCan);
        itemDictionaryRegistry("bottle", ArcanumItems.itemEmptyCan);
        itemDictionaryRegistry("Cup", ArcanumItems.itemRedCup);
    }*/
}
