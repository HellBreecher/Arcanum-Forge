package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.world.World;

public class itemInfernalShovel extends ShovelItem {

    public itemInfernalShovel() {
        super(EnumToolMaterial.InfernalTool, 1.5F, -250F, new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
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
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(16), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(17), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(18), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(19), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(20), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(21), 10);
            stack.addEnchantment(Enchantment.getEnchantmentByID(35), 10);
        }
    }
}
