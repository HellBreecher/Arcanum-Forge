package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class InfernalSword extends SwordItem {

    public InfernalSword() {
        super(EnumToolMaterial.InfernalTool, 1, 0F, new Properties().group(Arcanum.arcanum));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(16), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(17), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(18), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(19), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(20), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(21), 10);
        }
    }
}
