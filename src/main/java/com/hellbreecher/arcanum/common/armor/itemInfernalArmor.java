package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumArmor;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;

import net.minecraft.client.Minecraft;
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

public class itemInfernalArmor extends ArmorItem {

    public itemInfernalArmor(EquipmentSlotType slot) {
        super(EnumArmorMaterial.InfernalArmor, slot, new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
    }

	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 5);
            stack.addEnchantment(Enchantments.FIRE_PROTECTION, 5);
            stack.addEnchantment(Enchantments.PROTECTION, 5);
            stack.addEnchantment(Enchantments.BLAST_PROTECTION, 5);
            stack.addEnchantment(Enchantments.THORNS, 5);
            if(stack.equals(new ItemStack(ArcanumArmor.infernalhelmet.get()))){
            	stack.addEnchantment(Enchantments.AQUA_AFFINITY, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalchestplate.get()))) {
            	stack.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalleggings.get()))) {
            	stack.addEnchantment(Enchantments.DEPTH_STRIDER, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalboots.get()))) {
            	stack.addEnchantment(Enchantments.FEATHER_FALLING, 5);
            }

        }
    }
	
	@SuppressWarnings("resource")
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	PlayerEntity player = (PlayerEntity) entityIn.getEntity();
    	
    	Iterable<ItemStack> armorlist = entityIn.getArmorInventoryList();
    	//[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
    	
    	List<ItemStack> infernalarmor = new ArrayList<ItemStack>();
    	infernalarmor.add(new ItemStack(ArcanumArmor.infernalboots.get()));
    	infernalarmor.add(new ItemStack(ArcanumArmor.infernalleggings.get()));
    	infernalarmor.add(new ItemStack(ArcanumArmor.infernalchestplate.get()));
    	infernalarmor.add(new ItemStack(ArcanumArmor.infernalhelmet.get()));        
        //[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
    	
        if (armorlist.equals(infernalarmor) || armorlist.toString().equals(infernalarmor.toString())) {
            player.abilities.allowFlying = true;
            player.abilities.setFlySpeed(0.15F);
            player.getFoodStats().setFoodLevel(100);
            player.setHealth(100.0F);
            player.abilities.disableDamage = true;
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20*20, 15, true, false));
        	player.addPotionEffect(new EffectInstance(Effects.SPEED, 20*20, 10, true, false));
            if (worldIn.isRemote) {
                Minecraft.getInstance().gameSettings.field_243227_aN = 0.0F;
                Minecraft.getInstance().gameSettings.field_243226_aM = 0.0F;
            }
        } else {
            player.setInvisible(false);
            player.abilities.allowFlying = false;
            player.abilities.setFlySpeed(0.1F);
            player.abilities.disableDamage = false;
            player.getFoodStats().setFoodLevel(20);
            player.setHealth(20.0F);
            if (worldIn.isRemote) {
                Minecraft.getInstance().gameSettings.field_243227_aN = 1.0F;
                Minecraft.getInstance().gameSettings.field_243226_aM = 1.0F;
            }
        }
    }
}
