package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class BloodDiamondBeatingStickItem extends SwordItem{

    public BloodDiamondBeatingStickItem() {
        super(EnumToolMaterial.BloodDiamondBeatingStick, 1, -2.4F, new Properties().tab(Arcanum.arcanum).defaultDurability(-1));
    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 5);
            stack.enchant(Enchantments.SMITE, 5);
            stack.enchant(Enchantments.KNOCKBACK, 5);
            stack.enchant(Enchantments.MOB_LOOTING, 5);
        }
    }
	
}
