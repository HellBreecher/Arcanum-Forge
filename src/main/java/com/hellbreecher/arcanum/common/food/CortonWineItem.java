package com.hellbreecher.arcanum.common.food;

import com.hellbreecher.arcanum.Arcanum;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class CortonWineItem extends Item {
	
	public CortonWineItem() {
		super(new Item.Properties()
				.tab(Arcanum.arcanum)
				.durability(10)
				.food(new Food.Builder()
						.alwaysEat()
						.fast()
						.nutrition(2*3)
						.saturationMod(0.5F)
						.build()
					)
				);	
	}
	
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if(worldIn.isClientSide) {
			entityLiving.addEffect(new EffectInstance(Effects.HUNGER, 20*15, 1));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*15, 1));
			entityLiving.addEffect(new EffectInstance(Effects.BLINDNESS, 20*15, 1));
			entityLiving.addEffect(new EffectInstance(Effects.GLOWING, 20*15, 1));
			entityLiving.addEffect(new EffectInstance(Effects.CONFUSION, 20*15, 1));
		}
		if(this.getDamage(stack) == 10) {
			return new ItemStack(Items.GLASS_BOTTLE);
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
	
	public UseAction getUseAnimation(ItemStack stack) {
		return stack.getItem().isEdible() ? UseAction.DRINK : UseAction.NONE;
	}
}
