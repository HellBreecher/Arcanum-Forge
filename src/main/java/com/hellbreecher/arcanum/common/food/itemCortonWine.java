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

public class itemCortonWine extends Item {
	
	public itemCortonWine() {
		super(new Item.Properties()
				.group(Arcanum.arcanum)
				.maxDamage(10)
				.food(new Food.Builder()
						.setAlwaysEdible()
						.fastToEat()
						.hunger(2*3)
						.saturation(0.5F)
						.build()
					)
				);	
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if(!worldIn.isRemote) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.HUNGER, 20*15, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, 20*15, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 20*15, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.GLOWING, 20*15, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*15, 1));
		}
		if(this.getDamage(stack) == 10) {
			return new ItemStack(Items.GLASS_BOTTLE);
		}else if(!this.isDamaged(stack) || this.isDamaged(stack)) {
			this.setDamage(stack, this.getDamage(stack) + 1);
		}
		return stack;
	}
	
	public UseAction getUseAction(ItemStack stack) {
		return stack.getItem().isFood() ? UseAction.DRINK : UseAction.NONE;
	}
}
