package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfernalSwordItem extends SwordItem {

    public InfernalSwordItem() {
        super(EnumToolTier.InfernalTool, 1, -2.4F, new Properties().durability(-1));
    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.SHARPNESS, 10);
            stack.enchant(Enchantments.SMITE, 10);
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 10);
            stack.enchant(Enchantments.KNOCKBACK, 10);
            stack.enchant(Enchantments.FIRE_ASPECT, 10);
            stack.enchant(Enchantments.MOB_LOOTING, 10);
        }
    }
}
