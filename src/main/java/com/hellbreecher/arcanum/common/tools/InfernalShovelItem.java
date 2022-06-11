package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InfernalShovelItem extends ShovelItem {

    public InfernalShovelItem() {
        super(EnumToolTier.InfernalTool, 1.5F, -3.0F, new Item.Properties().tab(Arcanum.arcanum).defaultDurability(-1));
    }
    //TODO: Infernal Shovel drop rate increase
    /**
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Block block = state.getBlock();
        Random rand = worldIn.rand;
        ItemStack itemDropped = new ItemStack(block.getItemDropped(state, rand, 0));
        if (!worldIn.isRemote && block.isToolEffective("shovel", state)) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(itemDropped.getItem(), 10);
        } else if (!worldIn.isRemote) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(itemDropped.getItem(),
                    block.quantityDropped(state, 0, rand));
        } else {
            return false;
        }
        return false;
    }
	*/
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }
}
