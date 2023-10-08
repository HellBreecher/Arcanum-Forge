package com.hellbreecher.arcanum.common.tools;

import java.util.Map;
import java.util.WeakHashMap;

import com.hellbreecher.arcanum.common.lib.EnumToolTier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class InfernalPickaxeItem extends PickaxeItem {

    public InfernalPickaxeItem() {
        super(EnumToolTier.InfernalTool, 1, -2.8F, new Item.Properties().defaultDurability(-1));
    }

    public static final Map<Player, ItemStack> SMELTING_CACHE = new WeakHashMap<>();

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (world.isClientSide) {
            return super.mineBlock(stack, world, state, pos, miner);
        }
        
        // Handle the block breaking and tool damage server-side
        return super.mineBlock(stack, world, state, pos, miner);
    }

    public void onCraftedBy(ItemStack stack, Level level, Player player) {
    	
        // Set the Autosmelting tag to true
        stack.getOrCreateTag().putBoolean("Auto Smelting", true);
    	
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
            stack.enchant(Enchantments.UNBREAKING, 10);
            stack.enchant(Enchantments.MENDING, 1);
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
        }
    }
}
