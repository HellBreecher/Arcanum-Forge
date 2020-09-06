package com.hellbreecher.arcanum.common.blocks.tile;

import com.hellbreecher.arcanum.common.blocks.blockArcFurnace;
import com.hellbreecher.arcanum.common.core.ArcanumBlocks;
import com.hellbreecher.arcanum.common.core.ArcanumItems;
import com.hellbreecher.arcanum.common.handler.IConfigHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class TileMCUFurnace extends TileEntity implements IInventory, ITickable, ISidedInventory {
    private static final int[] SLOTS_TOP = { 0 };
    private static final int[] SLOTS_BOTTOM = { 2, 1 };
    private static final int[] SLOTS_SIDES = { 1 };
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;
    private ItemStackHandler handler = new ItemStackHandler(3);
    private ItemStack smelting = ItemStack.EMPTY;
    IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
    IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
    IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);
    
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        else return false;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
        return super.getCapability(capability, facing);
    }
    
    public boolean hasCustomName() 
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
    public void setCustomName(String customName) 
    {
        this.furnaceCustomName = customName;
    }
    
    @Override
    public ITextComponent getDisplayName() 
    {
        return this.hasCustomName() ? new TextComponentString(this.furnaceCustomName) : new TextComponentTranslation("MCU Furnace");
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime((ItemStack)this.handler.getStackInSlot(1));
        
        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) 
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.furnaceBurnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        compound.setTag("Inventory", this.handler.serializeNBT());
        
        if(this.hasCustomName()) compound.setString("CustomName", this.furnaceCustomName);
        return compound;
    }
    
    public boolean isBurning() 
    {
        return this.furnaceBurnTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isBurning(TileMCUFurnace tileMCUFurnace) 
    {
        return tileMCUFurnace.getField(0) > 0;
    }
    
    public void update() 
    {   
        if(this.isBurning())
        {
            --this.furnaceBurnTime;
            blockArcFurnace.setState(true, world, pos);
        }
        
        ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(0)};
        ItemStack fuel = this.handler.getStackInSlot(1);
        
        if(this.isBurning() || !fuel.isEmpty() && !this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty())
        {
            if(!this.isBurning() && this.canSmelt())
            {
                this.furnaceBurnTime = getItemBurnTime(fuel);
                this.currentItemBurnTime = furnaceBurnTime;
                
                if(this.isBurning() && !fuel.isEmpty())
                {
                    Item item = fuel.getItem();
                    fuel.shrink(1);
                    
                    if(fuel.isEmpty())
                    {
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.handler.setStackInSlot(2, item1);
                    }
                }
            }
        }
        
        if(this.isBurning() && this.canSmelt() && cookTime > 0)
        {
            cookTime++;
            if(cookTime == totalCookTime)
            {
                if(handler.getStackInSlot(1).getCount() > 0)
                {
                    handler.getStackInSlot(1).grow(1);
                }
                else
                {
                    handler.insertItem(1, smelting, false);
                }
                
                smelting = ItemStack.EMPTY;
                cookTime = 0;
                return;
            }
        }
        else
        {
            if(this.canSmelt() && this.isBurning())
            {
                ItemStack output = FurnaceRecipes.instance().getSmeltingResult(inputs[0]);
                if(!output.isEmpty())
                {
                    smelting = output;
                    cookTime++;
                    inputs[0].shrink(1);
                    handler.setStackInSlot(0, inputs[0]);
                }
            }
        }
    }
    
    private boolean canSmelt() 
    {
        if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty()) return false;
        else 
        {
            ItemStack result = FurnaceRecipes.instance().getSmeltingResult((ItemStack)this.handler.getStackInSlot(0));  
            if(result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.handler.getStackInSlot(2);
                if(output.isEmpty()) return true;
                if(!output.isItemEqual(result)) return false;
                int res = output.getCount() + IConfigHandler.getInt("Mech", "MCU Furnace Smelt Count");
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }
    
    public static int getItemBurnTime(ItemStack stack) {
        if (stack.getItem().equals(ArcanumItems.itemGSCoal)) {
            return 6400;
        }
        if (stack.getItem().equals(Item.getItemFromBlock(ArcanumBlocks.blockGreenSapphireCoal))) {
            return 57600;
        }
        return 0;  
    }
        
    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }
    
    public boolean isUsableByPlayer(EntityPlayer player) 
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public int getField(int id) 
    {
        switch(id) 
        {
        case 0:
            return this.furnaceBurnTime;
        case 1:
            return this.currentItemBurnTime;
        case 2:
            return this.cookTime;
        case 3:
            return this.totalCookTime;
        default:
            return 0;
        }
    }

    public void setField(int id, int value) 
    {
        switch(id) 
        {
        case 0:
            this.furnaceBurnTime = value;
            break;
        case 1:
            this.currentItemBurnTime = value;
            break;
        case 2:
            this.cookTime = value;
            break;
        case 3:
            this.totalCookTime = value;
        }
    }

    public int[] getSlotsForFace(EnumFacing side) {
        if(side == EnumFacing.DOWN) {
            return SLOTS_BOTTOM;
        }
        return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if(direction == EnumFacing.DOWN && index == 2) {
            return true;
        }
        return false;
    }

    public int getSizeInventory() {
        return furnaceItemStacks.size();
    }

    public boolean isEmpty() {
        for (ItemStack itemstack : this.furnaceItemStacks){
            if (!itemstack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public ItemStack getStackInSlot(int index) {
        return ItemStackHelper.getAndRemove(furnaceItemStacks, index);
    }

    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.furnaceItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.furnaceItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 1 && !flag)
        {
            this.totalCookTime = this.cookTime;
            this.cookTime = 0;
            this.markDirty();
        } 
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void openInventory(EntityPlayer player) {}
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 1) {
            return false;
        } else return FurnaceRecipes.instance().getSmeltingResult(stack) != null && index == 0;
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        this.furnaceItemStacks.clear();
    }

    public String getName() {
        return this.hasCustomName() ? this.furnaceCustomName : "MCU Furnace";
    }
}
