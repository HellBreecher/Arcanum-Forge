package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

public class itemUnfermentedBeer extends Item {

    public itemUnfermentedBeer() {
        super(new Item.Properties()
        		.group(Arcanum.arcanum)
        		.maxDamage(10)
        		.food(new Food.Builder()
        				.setAlwaysEdible()
        				.fastToEat()
        				.build()	
        			)
        		);
    }
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if(this.getDamage(stack) == 10) {
			return new ItemStack(ArcanumItems.emptycan.get());
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
    
	public UseAction getUseAction(ItemStack stack) {
		return stack.getItem().isFood() ? UseAction.DRINK : UseAction.NONE;
	}
	
}
