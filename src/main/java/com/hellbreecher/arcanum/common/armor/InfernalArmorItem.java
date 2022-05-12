package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.core.ArcanumArmor;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;

import net.minecraft.client.Minecraft;
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
public class InfernalArmorItem extends ArmorItem {

	static boolean arceffect;

	public InfernalArmorItem(EquipmentSlotType slot) {
        super(EnumArmorMaterial.InfernalArmor, slot, new Item.Properties().tab(Arcanum.arcanum).durability(-1));
    }

	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 5);
            stack.enchant(Enchantments.FIRE_PROTECTION, 5);
            stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
            stack.enchant(Enchantments.BLAST_PROTECTION, 5);
            stack.enchant(Enchantments.THORNS, 5);
            if(stack.equals(new ItemStack(ArcanumArmor.infernalhelmet.get()))){
            	stack.enchant(Enchantments.AQUA_AFFINITY, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalchestplate.get()))) {
            	stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalleggings.get()))) {
            	stack.enchant(Enchantments.DEPTH_STRIDER, 5);
            }else if (stack.equals(new ItemStack(ArcanumArmor.infernalboots.get()))) {
            	stack.enchant(Enchantments.FALL_PROTECTION, 5);
            }

        }
    }
	
	@SubscribeEvent
	public static void onEquipped(LivingEquipmentChangeEvent event) {

		if(event.getEntity() instanceof PlayerEntity) {
            Minecraft instance = Minecraft.getInstance();
            PlayerEntity player = (PlayerEntity) event.getEntity();
        	Iterable<ItemStack> armorlist = player.getArmorSlots();
        	//[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
            World worldIn =  player.level;
            int inf = Integer.MAX_VALUE;
            
        	List<ItemStack> infernalarmor = new ArrayList<ItemStack>();
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalboots.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalleggings.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalchestplate.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalhelmet.get()));        
            //[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
        	
			if (armorlist.equals(infernalarmor) || armorlist.toString().equals(infernalarmor.toString())) {
                player.abilities.flying = true;
                player.abilities.setFlyingSpeed(0.15F);
                player.getFoodData().setFoodLevel(20);
                player.setHealth(player.getMaxHealth());
                player.abilities.invulnerable = true;
                player.addEffect(new EffectInstance(Effects.JUMP, inf, 15, true, false));
            	player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, inf, 10, true, false));
                if (worldIn.isClientSide) {
                    instance.options.fovEffectScale = 0.0F;
                    instance.options.screenEffectScale = 0.0F;
                }
                arceffect = true;
            } else if(arceffect) {
                if (!player.isCreative()) player.abilities.flying = false;
                player.abilities.setFlyingSpeed(0.1F);
                player.removeEffect(Effects.JUMP);
                player.removeEffect(Effects.MOVEMENT_SPEED);
                player.abilities.invulnerable = false;
                if (worldIn.isClientSide) {
                    instance.options.fovEffectScale = 1.0F;
                    instance.options.screenEffectScale = 1.0F;
                }
                arceffect = false;
            }
        }

		
	}
}
