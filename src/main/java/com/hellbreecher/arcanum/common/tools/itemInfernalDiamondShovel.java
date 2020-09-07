package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.world.World;

public class itemInfernalDiamondShovel extends ShovelItem {

    public itemInfernalDiamondShovel() {
        super(EnumToolMaterial.InfernalDiamondTool, 1.5F, -15F, new Item.Properties().group(Arcanum.arcanum));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FORTUNE, 5);
            stack.addEnchantment(Enchantments.UNBREAKING, 10);
            stack.addEnchantment(Enchantments.MENDING, 1);
        }
    }
}
