package com.hellbreecher.arcanum.common.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CortonWineItem extends Item {
	
	public CortonWineItem() {
		super(new Item.Properties()
				.durability(10)
				.food(new FoodProperties.Builder()
						.alwaysEat()
						.fast()
						.nutrition(2*3)
						.saturationMod(0.5F)
						.build()
					)
				);	
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
		if(level.isClientSide) {
			player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20*15, 1));
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*15, 1));
			player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20*15, 1));
			player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20*15, 1));
			player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20*15, 1));
		}
		if(this.getDamage(stack) == 10) {
			return new ItemStack(Items.GLASS_BOTTLE);
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
	
	public UseAnim getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
	}
}
