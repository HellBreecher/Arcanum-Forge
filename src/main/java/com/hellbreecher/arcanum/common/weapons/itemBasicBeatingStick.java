package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class itemBasicBeatingStick extends SwordItem {

    public itemBasicBeatingStick() {
        super(EnumToolMaterial.GreenSapphireTool, 1, 0F, new Properties().group(Arcanum.arcanum).maxDamage(-1));

    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(18), 3);
            stack.addEnchantment(Enchantment.getEnchantmentByID(19), 3);
            stack.addEnchantment(Enchantment.getEnchantmentByID(17), 3);
            stack.addEnchantment(Enchantment.getEnchantmentByID(21), 3);
        }
    }
}
