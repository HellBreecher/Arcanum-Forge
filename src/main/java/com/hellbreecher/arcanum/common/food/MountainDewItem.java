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

public class MountainDewItem extends Item {

	public MountainDewItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.durability(10)
				.food(new Food.Builder()
						.nutrition(2*2)
						.saturationMod(5.0F)
						.build()
						)
				
				);
	}
	
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (worldIn.isClientSide)
        {
            entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20*20, 10));
        }
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
