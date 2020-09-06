package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumItems;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class itemMountainDew extends Item {

	public itemMountainDew() {
		super(new Item.Properties()
				.group(Arcanum.arcanum)
				.maxDamage(10)
				.food(new Food.Builder()
						.hunger(2*2)
						.saturation(5.0F)
						.build()
						)
				
				);
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote)
        {
            entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 20*20, 10));
        }
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
