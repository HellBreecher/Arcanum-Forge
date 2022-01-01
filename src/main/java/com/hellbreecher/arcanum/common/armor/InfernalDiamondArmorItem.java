package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumArmor;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class InfernalDiamondArmorItem extends ArmorItem {

    public InfernalDiamondArmorItem(EquipmentSlotType slot) {
        super(EnumArmorMaterial.InfernalDiamondArmor, slot, new Item.Properties().tab(Arcanum.arcanum));
    }

    public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
            stack.enchant(Enchantments.FIRE_PROTECTION, 5);
        }
    }
    
	@SubscribeEvent
	public static void onArmorEquipped(LivingEquipmentChangeEvent event) {
    	PlayerEntity player = (PlayerEntity) event.getEntity();
    	
    	Iterable<ItemStack> armorlist = player.getArmorSlots();
    	//[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
    	
    	List<ItemStack> infernaldiamondarmor = new ArrayList<ItemStack>();
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondboots.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondleggings.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondchestplate.get()));
    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondhelmet.get()));        
        //[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
    	
        if (armorlist.equals(infernaldiamondarmor) || armorlist.toString().equals(infernaldiamondarmor.toString())) {
        	player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*20, 1, true, false));
        	player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20*20, 1, true, false));
       }
    }
}
