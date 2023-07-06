package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class VoidDiamondBeatingStickItem extends SwordItem{
	
    public VoidDiamondBeatingStickItem() {
        super(EnumToolTier.VoidDiamondBeatingStick, 1, -2.4F, new Properties());

    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
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
