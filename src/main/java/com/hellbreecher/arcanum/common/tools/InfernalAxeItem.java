package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfernalAxeItem extends AxeItem {

    public InfernalAxeItem() {
        super(EnumToolTier.InfernalTool, 6.0F, -3.1F, new Item.Properties().tab(Arcanum.arcanum));
    }
 /**
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Block block = state.getBlock();
        Random rand = worldIn.rand;
        if (!worldIn.isRemote && block.isToolEffective("axe", state)) {
            block.dropitem
        } else if (!worldIn.isRemote) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(itemDropped.getItem(),
                    block.quantityDropped(state, 0, rand));
        } else {
            return false;
        }
        return false;
    }*/
    
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }
}
