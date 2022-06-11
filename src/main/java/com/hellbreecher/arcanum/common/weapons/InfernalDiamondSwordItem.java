package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfernalDiamondSwordItem extends SwordItem {

    public InfernalDiamondSwordItem() {
        super(EnumToolTier.InfernalDiamondTool, 1, -2.4F, new Properties().tab(Arcanum.arcanum));
    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
            stack.enchant(Enchantments.MOB_LOOTING, 10);
        }
    }
}
