package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class InfernalDiamondSwordItem extends SwordItem {

    public InfernalDiamondSwordItem() {
        super(EnumToolMaterial.InfernalDiamondTool, 1, -2.4F, new Properties().tab(Arcanum.arcanum));
    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
            stack.enchant(Enchantments.MOB_LOOTING, 10);
        }
    }
}
