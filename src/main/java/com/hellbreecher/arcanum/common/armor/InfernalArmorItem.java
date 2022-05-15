package com.hellbreecher.arcanum.common.armor;

import java.util.ArrayList;
import java.util.List;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumArmorMaterial;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.core.ArcanumArmor;

import net.minecraft.client.Minecraft;
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
public class InfernalArmorItem extends ArmorItem {

	static boolean arceffect;

	public InfernalArmorItem(EquipmentSlot slot) {
        super(EnumArmorMaterial.InfernalArmor, slot, new Item.Properties().tab(Arcanum.arcanum).durability(-1));
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

		if(event.getEntity() instanceof Player) {
            Minecraft instance = Minecraft.getInstance();
            Player player = (Player) event.getEntity();
        	Iterable<ItemStack> armorlist = player.getArmorSlots();
        	//[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
            Level level =  player.level;
            int inf = Integer.MAX_VALUE;
            
        	List<ItemStack> infernalarmor = new ArrayList<ItemStack>();
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalboots.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalleggings.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalchestplate.get()));
        	infernalarmor.add(new ItemStack(ArcanumArmor.infernalhelmet.get()));        
            //[1 infernalboots, 1 infernalleggings, 1 infernalchestplate, 1 infernalhelmet]
        	
			if (armorlist.equals(infernalarmor) || armorlist.toString().equals(infernalarmor.toString())) {
                player.getAbilities().mayfly = true;
                player.getAbilities().flying = true;
                player.getAbilities().setFlyingSpeed(0.15F);
                player.getFoodData().setFoodLevel(20);
                player.setHealth(player.getMaxHealth());
                player.getAbilities().invulnerable = true;
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, inf, 15, true, false));
            	player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, inf, 10, true, false));
                if (level.isClientSide) {
                    instance.options.fovEffectScale = 0.0F;
                    instance.options.screenEffectScale = 0.0F;
                }
                arceffect = true;
            } else if(arceffect) {
                if (!player.isCreative()) 
                player.getAbilities().mayfly = false;
                player.getAbilities().setFlyingSpeed(0.1F);
                player.removeEffect(MobEffects.JUMP);
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
                player.getAbilities().invulnerable = false;
                if (level.isClientSide) {
                    instance.options.fovEffectScale = 1.0F;
                    instance.options.screenEffectScale = 1.0F;
                }
                arceffect = false;
            }
        }

		
	}
}
