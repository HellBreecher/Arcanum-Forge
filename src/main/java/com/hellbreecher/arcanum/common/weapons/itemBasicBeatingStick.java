package com.hellbreecher.arcanum.common.weapons;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
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
            stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 3);
            stack.addEnchantment(Enchantments.SMITE, 3);
            stack.addEnchantment(Enchantments.KNOCKBACK, 3);
            stack.addEnchantment(Enchantments.LOOTING, 3);
        }
    }
}
