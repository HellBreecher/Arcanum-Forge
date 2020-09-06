package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;

public class itemInfernalDiamondShears extends ShearsItem {

    public itemInfernalDiamondShears() {
        super(new Properties().group(Arcanum.arcanum).maxDamage(8000));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(16), 5);
            stack.addEnchantment(Enchantment.getEnchantmentByID(20), 10);
        }
    }
}
