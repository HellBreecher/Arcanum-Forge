package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumArmor;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class itemInfernalDiamondArmor extends ArmorItem {

    public itemInfernalDiamondArmor(EquipmentSlotType slot) {
        super(EnumArmorMaterial.InfernalDiamondArmor, slot, new Item.Properties().group(Arcanum.arcanum));
    }

    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 5);
            stack.addEnchantment(Enchantments.FIRE_PROTECTION, 5);
        }
    }

	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	PlayerEntity player = (PlayerEntity) entityIn.getEntity();
    	
    	Iterable<ItemStack> armorlist = entityIn.getArmorInventoryList();
    	//[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
    	
    	List<ItemStack> infernaldiamondarmor = new ArrayList<ItemStack>();
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondboots.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondleggings.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondchestplate.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondhelmet.get()));        
        //[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
    	
        if (armorlist.equals(infernaldiamondarmor) || armorlist.toString().equals(infernaldiamondarmor.toString())) {
        	player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*20, 1, true, false));
        	player.addPotionEffect(new EffectInstance(Effects.SPEED, 20*20, 1, true, false));
       }
    }
}
