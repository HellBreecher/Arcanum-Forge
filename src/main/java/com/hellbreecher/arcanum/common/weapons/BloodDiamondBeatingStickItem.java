package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class BloodDiamondBeatingStickItem extends SwordItem{

    public BloodDiamondBeatingStickItem() {
        super(EnumToolTier.BloodDiamondBeatingStick, 1, -2.4F, new Properties().defaultDurability(-1));
    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 5);
            stack.enchant(Enchantments.SMITE, 5);
            stack.enchant(Enchantments.KNOCKBACK, 5);
            stack.enchant(Enchantments.MOB_LOOTING, 5);
        }
    }
	
}
