package com.hellbreecher.arcanum.common.tools;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.lib.EnumToolMaterial;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class itemInfernalPickaxe extends PickaxeItem {

    public itemInfernalPickaxe() {
        super(EnumToolMaterial.InfernalTool, 1, -200F, new Item.Properties().group(Arcanum.arcanum).maxDamage(-1));
    }
  //TODO: Infernal Pick Auto Smelting & Torch Placement
    /**
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Random rand = worldIn.rand;
        Block block = state.getBlock();
        ItemStack preSmelt = new ItemStack(block.asItem());
        ItemStack postSmelt = IRecipe.
        float exp = stack.getItem().getSmeltingExperience(stack) * 5.0F;
        if (!worldIn.isRemote && block.isToolEffective(state, ToolType.PICKAXE)) {
            if (postSmelt.getItem() != null && postSmelt.getItem() != preSmelt.getItem() && postSmelt.getItem() != Items.REDSTONE) {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(postSmelt.getItem(), 10);
                Minecraft.getMinecraftGame().player.addExperience((int) exp);
            } else if (block == Blocks.LAPIS_ORE || block == Blocks.REDSTONE_ORE) {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(block.getItemDropped(state, rand, 0), 10);
                Minecraft.getMinecraftGame().player.addExperience((int) exp);
            } else {
                worldIn.destroyBlock(pos, false);
                entityLiving.dropItem(preSmelt.getItem(), block.quantityDropped(state, 0, rand));
            }
        } else if (!worldIn.isRemote) {
            worldIn.destroyBlock(pos, false);
            entityLiving.dropItem(preSmelt.getItem(), block.quantityDropped(state, 0, rand));
        } else {
            return false;
        }
        return false;
    }

    public EnumActionResult func_180614_a(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing.equals(EnumFacing.DOWN) && world.func_175623_d(pos.func_177977_b())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177977_b(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        if (facing.equals(EnumFacing.UP) && world.func_175623_d(pos.func_177984_a())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177984_a(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        if (facing.equals(EnumFacing.NORTH) && world.func_175623_d(pos.func_177978_c())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177978_c(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        if (facing.equals(EnumFacing.SOUTH) && world.func_175623_d(pos.func_177968_d())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177968_d(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        if (facing.equals(EnumFacing.WEST) && world.func_175623_d(pos.func_177976_e())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177976_e(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        if (facing.equals(EnumFacing.EAST) && world.func_175623_d(pos.func_177974_f())) {
            world.func_184133_a(player, pos, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0F,
                    field_77697_d.nextFloat() * 0.4F + 0.8F);
            world.func_175656_a(pos.func_177974_f(), ArcanumBlocks.blockGSTorch.getStateForPlacement(world, pos, facing,
                    hitX, hitY, hitZ, 0, player, hand));
        }
        return EnumActionResult.PASS;
    }
     */
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FORTUNE, 5);
            stack.addEnchantment(Enchantments.UNBREAKING, 10);
            stack.addEnchantment(Enchantments.MENDING, 1);
            stack.addEnchantment(Enchantments.FLAME, 5);
        }
    }
}
