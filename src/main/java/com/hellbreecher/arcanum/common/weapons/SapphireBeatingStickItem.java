package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class SapphireBeatingStickItem extends SwordItem {

    public SapphireBeatingStickItem() {
        super(EnumToolMaterial.SapphireBeatingStick, 1, -2.4F, new Properties().tab(Arcanum.arcanum));

    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
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
