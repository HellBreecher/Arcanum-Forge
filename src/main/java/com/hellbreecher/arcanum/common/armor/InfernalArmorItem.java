package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.core.ArcanumArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
public class InfernalArmorItem extends ArmorItem {

	static boolean arceffect;

	public InfernalArmorItem(Type slot) {
        super(EnumArmorMaterial.InfernalArmor, slot, new Item.Properties());
    }

    public void onCraftedBy(ItemStack stack, Level level, Player player) {
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
		Level level = event.getEntity().level();
		if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
        	Iterable<ItemStack> armorlist = player.getArmorSlots();
        	//[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
            int inf = Integer.MAX_VALUE;
            
        	List<ItemStack> infernalarmor = new ArrayList<ItemStack>();
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalboots.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalleggings.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalchestplate.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalhelmet.get()));        
            //[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
        	
			if (armorlist.equals(infernalarmor) || armorlist.toString().equals(infernalarmor.toString())) {
                addAbilities(player);
                player.getFoodData().setFoodLevel(20);
                player.setHealth(player.getMaxHealth());
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, inf, 6, true, false));
            	player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, inf, 6, true, false));
                if (level.isClientSide) {
                    Minecraft instance = Minecraft.getInstance();
                    instance.options.fovEffectScale().set(0.0);
                    instance.options.screenEffectScale().set(0.0);
                }
                arceffect = true;
            } else if(arceffect) {
                if (!player.isCreative()) 
                	removeAbilities(player);
                	player.removeEffect(MobEffects.JUMP);
                	player.removeEffect(MobEffects.MOVEMENT_SPEED);
                if (level.isClientSide) {
                    Minecraft instance = Minecraft.getInstance();
                    instance.options.fovEffectScale().set(1.0);
                    instance.options.screenEffectScale().set(1.0);
                }
                arceffect = false;
            }
        }	
	}
	
	private static void addAbilities(Player player) {
		if(!player.isCreative() && !player.isSpectator()) {
			player.getAbilities().mayfly = true;
			player.getAbilities().setFlyingSpeed(0.15F);
			player.getAbilities().invulnerable = true;
			player.onUpdateAbilities();
		}
	}
	
	private static void removeAbilities(Player player) {
		if(!player.isCreative() && !player.isSpectator()) {
        	player.getAbilities().mayfly = false;
        	player.getAbilities().setFlyingSpeed(0.1F);
        	player.getAbilities().invulnerable = false;
			player.onUpdateAbilities();
		}
	}
	
}
