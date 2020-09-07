package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;

public class itemInfernalShears extends ShearsItem {

    public itemInfernalShears() {
        super(new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
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
    
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FORTUNE, 5);
            stack.addEnchantment(Enchantments.UNBREAKING, 10);
            stack.addEnchantment(Enchantments.MENDING, 1);
            stack.addEnchantment(Enchantments.FLAME, 5);
        }
    }
}
