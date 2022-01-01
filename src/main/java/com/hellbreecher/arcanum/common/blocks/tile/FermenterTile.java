package com.hellbreecher.arcanum.common.blocks.tile;

public class FermenterTile  {
	
	/**
    private static final int[] SLOTS_TOP = { 0 };
    private static final int[] SLOTS_BOTTOM = { 1 };
    private static final int[] SLOTS_SIDES = { 0 };
    private ItemStackHandler handler = new ItemStackHandler(2);
    private NonNullList<ItemStack> fermenterItemStacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
    private ItemStack fermenting = ItemStack.EMPTY;
    private int fermentingTime;
    private int currentItemFermentTime;
    private int fermentTime;
    private int totalFermentTime = 4;
    private String fermenterCustomName;

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
        return this.fermenterCustomName != null && !this.fermenterCustomName.isEmpty();
    }
    
    public void setCustomName(String customName) 
    {
        this.fermenterCustomName = customName;
    }
    
    @Override
    public ITextComponent getDisplayName() 
    {
        return this.hasCustomName() ? new TextComponentString(this.fermenterCustomName) : new TextComponentTranslation("Fermenter");
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.fermentingTime = compound.getInteger("FermentingTime");
        this.fermentTime = compound.getInteger("FermentTime");
        this.totalFermentTime = compound.getInteger("FermentTimeTotal");
        this.currentItemFermentTime = getItemFermentTime((ItemStack)this.handler.getStackInSlot(0));
        
        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) 
    {
        super.writeToNBT(compound);
        compound.setInteger("FermentingTime", (short)this.fermentingTime);
        compound.setInteger("FermentTime", (short)this.fermentTime);
        compound.setInteger("FermentTimeTotal", (short)this.totalFermentTime);
        compound.setTag("Inventory", this.handler.serializeNBT());
        
        if(this.hasCustomName()) compound.setString("CustomName", this.fermenterCustomName);
        return compound;
    }
    
    public boolean isFermenting() 
    {
        return this.fermentTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isFermenting(TileFermenter te) 
    {
        return te.getField(0) > 0;
    }
    
    public void update() 
    {   
        if(this.isFermenting())
        {
            --this.fermentingTime;
            blockFermenter.setState(true, world, pos);
        }
        
        ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(0)};
        ItemStack toFerment = this.handler.getStackInSlot(0);
        
        if(this.isFermenting() || !toFerment.isEmpty() && !this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty())
        {
            if(!this.isFermenting() && this.canFerment())
            {
                this.fermentingTime = getItemFermentTime(toFerment);
                this.currentItemFermentTime = fermentingTime;
                
                if(this.isFermenting() && !toFerment.isEmpty())
                {
                    Item item = toFerment.getItem();
                    toFerment.shrink(1);
                    
                    if(toFerment.isEmpty())
                    {
                        ItemStack item1 = item.getContainerItem(toFerment);
                        this.handler.setStackInSlot(0, item1);
                    }
                }
            }
        }
        
        if(this.isFermenting() && this.canFerment() && fermentTime > 0)
        {
            fermentTime++;
            if(fermentTime == totalFermentTime)
            {
                if(handler.getStackInSlot(0).getCount() > 0)
                {
                    handler.getStackInSlot(1).grow(1);
                }
                else
                {
                    handler.insertItem(1, fermenting, false);
                }
                
                fermenting = ItemStack.EMPTY;
                fermentTime = 0;
                return;
            }
        }
        else
        {
            if(this.canFerment() && this.isFermenting())
            {
                ItemStack output = IFermenterRecipeHandler.instance().getFermentingResult(inputs[0]);
                if(!output.isEmpty())
                {
                    fermenting = output;
                    fermentTime++;
                    inputs[0].shrink(1);
                    handler.setStackInSlot(0, inputs[0]);
                }
            }
        }
    }
    
    private boolean canFerment() 
    {
        if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty()) return false;
        else 
        {
            ItemStack result = IFermenterRecipeHandler.instance().getFermentingResult((ItemStack)this.handler.getStackInSlot(0));  
            if(result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.handler.getStackInSlot(1);
                if(output.isEmpty()) return true;
                if(!output.isItemEqual(result)) return false;
                int res = output.getCount() + 1;
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }
    
    public static int getItemFermentTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        }else return 300;    }
        
    public static boolean isItemFuel(ItemStack fuel)
    {
        return true;
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
            return this.fermentingTime;
        case 1:
            return this.currentItemFermentTime;
        case 2:
            return this.fermentTime;
        case 3:
            return this.totalFermentTime;
        default:
            return 0;
        }
    }

    public void setField(int id, int value) 
    {
        switch(id) 
        {
        case 0:
            this.fermentingTime = value;
            break;
        case 1:
            this.currentItemFermentTime = value;
            break;
        case 2:
            this.fermentTime = value;
            break;
        case 3:
            this.totalFermentTime = value;
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
        if(direction == EnumFacing.DOWN && index == 1) {
            return true;
        }
        return false;
    }

    public int getSizeInventory() {
        return fermenterItemStacks.size();
    }

    public boolean isEmpty() {
        for (ItemStack itemstack : this.fermenterItemStacks){
            if (!itemstack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public ItemStack getStackInSlot(int index) {
        return ItemStackHelper.getAndRemove(fermenterItemStacks, index);
    }

    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.fermenterItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.fermenterItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.fermenterItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.fermenterItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.totalFermentTime = this.fermentTime;
            this.fermentTime = 0;
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
        } else return IFermenterRecipeHandler.instance().getFermentingResult(stack) != null && index == 0;
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        this.fermenterItemStacks.clear();
    }

    public String getName() {
        return this.hasCustomName() ? this.fermenterCustomName : "Fermenter";
    } */
}
