package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class VoidDiamondBeatingStickItem extends SwordItem{
	
    public VoidDiamondBeatingStickItem() {
        super(EnumToolMaterial.VoidDiamondBeatingStick, 1, -2.4F, new Properties().tab(Arcanum.arcanum));

    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 7);
            stack.enchant(Enchantments.SMITE, 7);
            stack.enchant(Enchantments.KNOCKBACK, 7);
            stack.enchant(Enchantments.MOB_LOOTING, 7);
        }
    }
	
	public boolean canBeDepleted() {
		return false;
	}
}
