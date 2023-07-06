package com.hellbreecher.arcanum.common.weapons;

import net.minecraft.world.item.Item;

public class InfernalWandItem extends Item {

	//TODO: Infernal Wand make do something
	
    public InfernalWandItem() {
        super(new Properties());
    }
/**
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.SHARPNESS, 10);
            stack.enchant(Enchantments.SMITE, 10);
            stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 10);
            stack.enchant(Enchantments.KNOCKBACK, 10);
            stack.enchant(Enchantments.FIRE_ASPECT, 10);
            stack.enchant(Enchantments.MOB_LOOTING, 10);
        }
    }
	
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = world.getBlockState(blockpos);
		boolean flag = false;
		if (CampfireBlock.func_241470_h_(blockstate)) {
			world.setBlockState(blockpos, blockstate.with(CampfireBlock.LIT, Boolean.valueOf(true)));
			flag = true;
		} else {
			blockpos = blockpos.offset(context.getFace());
			if (AbstractFireBlock.func_241465_a_(world,  blockpos, context.getPlacementHorizontalFacing())) {
				world.setBlockState(blockpos, AbstractFireBlock.func_235326_a_(world, blockpos));
				flag = true;
			}
		}
		
		return ActionResultType.func_233537_a_(world.isRemote);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		BlockState looking = world.getBlockState(new BlockPos(player.getLookVec()));
		if(looking.isAir() || looking != null) {
			Vector3d vec3d = player.getLook(1.0F);
			double d1 = 4.0D;
			double d2 = player.getPosX() - (player.getPosX() + vec3d.x * d1);
			double d3 = vec3d.getY() * (0.5D) - (0.5D + vec3d.getY() * (0.5D));
			double d4 = player.getPosZ() - (player.getPosZ() + vec3d.z * d1);
			FireballEntity fireball = new FireballEntity(world, player, -d2, -d3, -d4);
			fireball.explosionPower = 2;
			fireball.setPosition(fireball.getPosX() + vec3d.x * 4.0D, player.getPosYHeight(0.5D) + vec3d.getY(), fireball.getPosZ() + vec3d.z * 4.0D);
			world.addEntity(fireball);
		}
		return ActionResult.resultPass(player.getHeldItem(hand));
	}*/

}
