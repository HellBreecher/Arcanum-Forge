package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfernalDiamondAxeItem extends AxeItem {
 
    public InfernalDiamondAxeItem() {
        super(EnumToolTier.InfernalDiamondTool, 6.0F, -3.1F, new Item.Properties());
    }

	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
        }
    }
}
