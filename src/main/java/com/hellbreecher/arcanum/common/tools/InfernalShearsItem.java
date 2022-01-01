package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;

public class InfernalShearsItem extends ShearsItem {

    public InfernalShearsItem() {
        super(new Item.Properties().tab(Arcanum.arcanum).defaultDurability(-1));
    }
    
    //TODO: Infernal Shears drop rate increase
    /**
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Block block = state.getBlock();
        Random rand = worldIn.rand;
        ItemStack itemDropped = new ItemStack(block.getItemDropped(state, rand, 0));
        if (!worldIn.isRemote) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(itemDropped.getItem(), 10);
        } else {
            return false;
        }
        return false;
    }
	*/
    
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }
}
