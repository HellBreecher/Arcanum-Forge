package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class SapphireBeatingStickItem extends SwordItem {

    public SapphireBeatingStickItem() {
        super(EnumToolMaterial.SapphireBeatingStick, 1, -2.4F, new Properties().tab(Arcanum.arcanum));

    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3);
            stack.enchant(Enchantments.SMITE, 3);
            stack.enchant(Enchantments.KNOCKBACK, 3);
            stack.enchant(Enchantments.MOB_LOOTING, 3);
        }
    }
	
	public boolean canBeDepleted() {
		return false;
	}
	
}
