package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;

public class itemInfernalDiamondShears extends ShearsItem {

    public itemInfernalDiamondShears() {
        super(new Properties().group(Arcanum.arcanum).maxDamage(8000));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FORTUNE, 5);
            stack.addEnchantment(Enchantments.UNBREAKING, 10);
            stack.addEnchantment(Enchantments.MENDING, 1);
        }
    }
}
