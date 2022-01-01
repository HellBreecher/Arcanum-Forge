package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

public class UnfermentedBeerItem extends Item {

    public UnfermentedBeerItem() {
        super(new Item.Properties()
        		.tab(Arcanum.arcanum)
        		.durability(10)
        		.food(new Food.Builder()
        				.alwaysEat()
        				.fast()
        				.build()	
        			)
        		);
    }
    
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if(this.getDamage(stack) == 10) {
			return new ItemStack(ArcanumItems.emptycan.get());
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
    
	public UseAction getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAction.DRINK : UseAction.NONE;
	}
	
}
