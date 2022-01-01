package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class InfernalBeatingStickItem extends SwordItem {

    public InfernalBeatingStickItem() {
        super(EnumToolMaterial.InfernalTool, 1, -2.4F, new Properties().tab(Arcanum.arcanum).defaultDurability(-1));
    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 10);
            stack.enchant(Enchantments.SMITE, 10);
            stack.enchant(Enchantments.KNOCKBACK, 10);
            stack.enchant(Enchantments.MOB_LOOTING, 10);
            stack.enchant(Enchantments.FIRE_ASPECT, 10);
        }
    }
}
