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

public class AppleCiderItem extends Item {
	
	public AppleCiderItem() {
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
            entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 20*8, 5));
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
