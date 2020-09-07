package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class itemInfernalDiamondSword extends SwordItem {

    public itemInfernalDiamondSword() {
        super(EnumToolMaterial.InfernalDiamondTool, 1, 0F, new Properties().group(Arcanum.arcanum));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 5);
            stack.addEnchantment(Enchantments.LOOTING, 10);
        }
    }
}
