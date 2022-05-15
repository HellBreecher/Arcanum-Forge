package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.core.ArcanumItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class MountainDewItem extends Item {

	public MountainDewItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.durability(10)
				.food(new FoodProperties.Builder()
						.nutrition(2*2)
						.saturationMod(5.0F)
						.build()
						)
				
				);
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
        if (level.isClientSide)
        {
        	player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*20, 10));
        }
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
