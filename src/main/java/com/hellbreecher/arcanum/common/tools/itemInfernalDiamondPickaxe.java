package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class itemInfernalDiamondPickaxe extends PickaxeItem {

    public itemInfernalDiamondPickaxe() {
        super(EnumToolMaterial.InfernalDiamondTool, 1, -10F, new Properties().group(Arcanum.arcanum));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(16), 5);
            stack.addEnchantment(Enchantment.getEnchantmentByID(20), 10);
        }
    }
}
