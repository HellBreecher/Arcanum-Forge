package com.hellbreecher.arcanum.common.blocks;

import java.util.Random;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.tile.TileMCUFurnace;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.core.ArcanumItemGroups;
import com.hellbreecher.arcanum.common.handler.IGuiHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class blockMCUFurnace extends BlockContainer implements ITileEntityProvider {
    private static final String name = "MCUFurnace";
    public static final PropertyDirection FACING = PropertyDirection.create("facing",
            EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool BURNING = PropertyBool.create("burning");

    public static void setState(boolean active, World world, BlockPos pos) {
        IBlockState iblockstate = world.getBlockState(pos);
        TileEntity tileentity = world.getTileEntity(pos);
        if (active)
        {
            world.setBlockState(pos, ArcanumBlocks.blockMCUFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, ArcanumBlocks.blockMCUFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            world.setBlockState(pos, ArcanumBlocks.blockMCUFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, ArcanumBlocks.blockMCUFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(pos, tileentity);
        }
    }

    public blockMCUFurnace() {
        super(Material.ROCK);
        setCreativeTab(ArcanumItemGroups.Arcanum);
        setRegistryName(name);
        setUnlocalizedName(name);
        setResistance(5.0F);
        setHardness(4000.0F);
        setHarvestLevel("pickaxe", 3);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING,
                Boolean.valueOf(false)));
        if (BURNING.equals(Boolean.valueOf(true))) {
            setLightLevel(1.0F);
        } else {
            setLightLevel(0.0F);
        }
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public boolean hasComparatorInputOverride(IBlockState state) {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMCUFurnace();
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public void setDefaultFacing(World world, BlockPos pos, IBlockState state) {
        if (!world.isRemote)
        {
            IBlockState iblockstate = world.getBlockState(pos.north());
            IBlockState iblockstate1 = world.getBlockState(pos.south());
            IBlockState iblockstate2 = world.getBlockState(pos.west());
            IBlockState iblockstate3 = world.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            world.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(Arcanum.instance, IGuiHandler.MCUFurnaceID, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ArcanumBlocks.blockMCUFurnace);
    }

    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer(this, new IProperty[] { BURNING, FACING });
    }

    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileMCUFurnace tileentity = (TileMCUFurnace) world.getBlockState(pos);
        InventoryHelper.dropInventoryItems(world, pos, tileentity);
        super.breakBlock(world, pos, state);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer render() {
        return BlockRenderLayer.SOLID;
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ArcanumBlocks.blockMCUFurnace);
    }

    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public boolean isFUllCube(IBlockState state) {
        return false;
    }
}
