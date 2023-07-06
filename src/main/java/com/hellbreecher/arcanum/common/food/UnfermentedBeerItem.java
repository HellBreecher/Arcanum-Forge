package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class UnfermentedBeerItem extends Item {

    public UnfermentedBeerItem() {
        super(new Item.Properties()
        		.durability(10)
        		.food(new FoodProperties.Builder()
        				.alwaysEat()
        				.fast()
        				.build()	
        			)
        		);
    }
    
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
		if(this.getDamage(stack) == 10) {
			return new ItemStack(ArcanumItems.emptycan.get());
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
    
	public UseAnim getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
	}
	
}
