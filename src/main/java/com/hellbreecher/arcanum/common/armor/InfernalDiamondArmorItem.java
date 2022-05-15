package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.core.ArcanumArmor;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class InfernalDiamondArmorItem extends ArmorItem {

	static boolean arceffect;
	
    public InfernalDiamondArmorItem(EquipmentSlot slot) {
        super(EnumArmorMaterial.InfernalDiamondArmor, slot, new Item.Properties().tab(Arcanum.arcanum));
    }

    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
            stack.enchant(Enchantments.FIRE_PROTECTION, 5);
        }
    }
    
	@SubscribeEvent
	public static void onArmorEquipped(LivingEquipmentChangeEvent event) {
		
		
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();

			int inf = Integer.MAX_VALUE;
	    	Iterable<ItemStack> armorlist = player.getArmorSlots();
	    	//[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
	    	
	    	List<ItemStack> infernaldiamondarmor = new ArrayList<ItemStack>();
	    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondboots.get()));
	    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondleggings.get()));
	    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondchestplate.get()));
	    	infernaldiamondarmor.add(new ItemStack(ArcanumArmor.infernaldiamondhelmet.get()));        
	        //[1 infernaldiamondboots, 1 infernaldiamondleggings, 1 infernaldiamondchestplate, 1 infernaldiamondhelmet]
	    	
	        if (armorlist.equals(infernaldiamondarmor) || armorlist.toString().equals(infernaldiamondarmor.toString())) {
	        	player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, inf, 1, true, false));
	        	player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, inf, 1, true, false));
	        	arceffect = true;
	        }else if(arceffect) {
				player.removeEffect(MobEffects.FIRE_RESISTANCE);
				player.removeEffect(MobEffects.MOVEMENT_SPEED);
				arceffect = false;
	        }
		}
    }
}
