package com.hellbreecher.arcanum.common.blocks.tile;

import javax.annotation.Nullable;

import com.hellbreecher.arcanum.common.blocks.container.containerArcFurnace;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class tileentityArcFurnace extends AbstractFurnaceTileEntity {
    private static final int[] SLOTS_TOP = { 0 };
    private static final int[] SLOTS_BOTTOM = { 1 };
    private static final int[] SLOTS_SIDES = { 0 };
    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    private int furnaceBurnTime;
    private int recipesUsed;
    private int cookTime;
    private int totalCookTime = 4;
    private String furnaceCustomName = "Arc Furnace";
    
    public tileentityArcFurnace() {
        super(TileEntityType.FURNACE, IRecipeType.SMELTING);
    }
    
    protected final IIntArray furnaceData = new IIntArray() {
        public int get(int index) {
           switch(index) {
           case 0: 
        	   return tileentityArcFurnace.this.furnaceBurnTime;
           case 1: 
        	   return tileentityArcFurnace.this.recipesUsed;
           case 2:
              return tileentityArcFurnace.this.cookTime;
           case 3:
              return tileentityArcFurnace.this.totalCookTime;
           default:
              return 0;
           }
        }

        public void set(int index, int value) {
           switch(index) {
           case 0:
        	   tileentityArcFurnace.this.furnaceBurnTime = value;
              break;
           case 1:
        	   tileentityArcFurnace.this.recipesUsed = value;
              break;
           case 2:
        	   tileentityArcFurnace.this.cookTime = value;
              break;
           case 3:
        	   tileentityArcFurnace.this.totalCookTime = value;
           }

        }

        public int size() {
           return 4;
        }
     };
     
    public boolean hasCustomName() {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
    public void setCustomName(String customName) {
        this.furnaceCustomName = customName;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return ITextComponent.func_244388_a("Arc Furnace");
    }
    
    private boolean isBurning() {
        return this.furnaceBurnTime > 0;
     }
    
    public void tick() {
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
           --this.furnaceBurnTime;
        }

        if (!this.world.isRemote) {
           ItemStack itemstack = this.items.get(1);
           if (this.isBurning() || !this.items.get(0).isEmpty()) {
              IRecipe<?> irecipe = this.world.getRecipeManager().getRecipe((IRecipeType<AbstractCookingRecipe>)this.recipeType, this, this.world).orElse(null);
              if (!this.isBurning() && this.canSmelt(irecipe)) {
                 this.furnaceBurnTime = this.getBurnTime(itemstack);
                 this.recipesUsed = this.furnaceBurnTime;
                 if (this.isBurning()) {
                    flag1 = true;
                    if (itemstack.hasContainerItem())
                        this.items.set(1, itemstack.getContainerItem());
                    else
                    if (!itemstack.isEmpty()) {
                       Item item = itemstack.getItem();
                       itemstack.shrink(1);
                       if (itemstack.isEmpty()) {
                          this.items.set(1, itemstack.getContainerItem());
                       }
                    }
                 }
              }

              if (this.isBurning() && this.canSmelt(irecipe)) {
                 ++this.cookTime;
                 if (this.cookTime == this.totalCookTime) {
                    this.cookTime = 0;
                    this.totalCookTime = this.getCookTime();
                    this.smelt(irecipe);
                    flag1 = true;
                 }
              } else {
                 this.cookTime = 0;
              }
           } else if (!this.isBurning() && this.cookTime > 0) {
              this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
           }

           if (flag != this.isBurning()) {
              flag1 = true;
              this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(AbstractFurnaceBlock.LIT, Boolean.valueOf(this.isBurning())), 3);
           }
        }

        if (flag1) {
           this.markDirty();
        }

     }
    
    protected boolean canSmelt(@Nullable IRecipe<?> recipeIn) 
    {
        if(!this.items.get(0).isEmpty() && recipeIn != null) {
        	ItemStack result = recipeIn.getRecipeOutput();
        	ItemStack output = this.items.get(1).getStack();
        	if(result.isEmpty()) {return false;}
        	else {
        		int res = output.getCount() + 16;
        		//int res = output.getCount() + IConfigHandler.getInt("Mech", "Arc Furnace Smelt Count");
        		if(output.isEmpty()) return true;
        		else if(!output.isItemEqual(result)) return false;
        		else return res <= 64 && res <= output.getMaxStackSize();
        	}
        }else return false;
    }
    
    private void smelt(@Nullable IRecipe<?> recipe) {
        if (recipe != null && this.canSmelt(recipe)) {
           ItemStack itemstack = this.items.get(0);
           ItemStack itemstack1 = recipe.getRecipeOutput();
           ItemStack itemstack2 = this.items.get(1);
           if (itemstack2.isEmpty()) {
              this.items.set(2, itemstack1.copy());
           } else if (itemstack2.getItem() == itemstack1.getItem()) {
              itemstack2.grow(itemstack1.getCount());
           }

           if (!this.world.isRemote) {
              this.setRecipeUsed(recipe);
           }

           if (itemstack.getItem() == Blocks.WET_SPONGE.asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) {
              this.items.set(1, new ItemStack(Items.WATER_BUCKET));
           }

           itemstack.shrink(1);
        }
     }
    
    protected int getBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {return 0;}
        else return 999;    
    }
        
    public static boolean isFuel(ItemStack fuel) {
        return true;
    }

    protected int getCookTime() {
    	//return IConfigHandler.getInt("Mech", "Arc Furnace Smelt Time")
    	return 1;
    }
    
    public int[] getSlotsForFace(Direction side) {
        if(side == Direction.DOWN) {
            return SLOTS_BOTTOM;
        }
        return side == Direction.UP ? SLOTS_TOP : SLOTS_SIDES;
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        if(direction == Direction.DOWN && index == 2) {
            return true;
        }
        return false;
    }

    public int getSizeInventory() {
        return this.items.size();
    }
    
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items){
            if (!itemstack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.items.get(slot);
    }

    public ItemStack decrStackSize(int slot, int count) {
        return ItemStackHelper.getAndSplit(this.items, slot, count);
    }

    public ItemStack removeStackFromSlot(int slot) {
        return ItemStackHelper.getAndRemove(this.items, slot);
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        ItemStack itemstack = this.items.get(slot);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.items.set(slot, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (slot == 0 && !flag)
        {
            this.totalCookTime = this.cookTime;
            this.cookTime = 0;
            this.markDirty();
        } 
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 1) {
            return false;
        } else return index == 0;
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        this.items.clear();
    }

    public ITextComponent getName() {
        return ITextComponent.func_244388_a("Arc Furnace");
    }

	protected ITextComponent getDefaultName() {
		return ITextComponent.func_244388_a("Arc Furnace");
	}

	protected Container createMenu(int id, PlayerInventory playerInv) {
		return new containerArcFurnace(null, recipeType, null, id, playerInv, this, this.furnaceData);
	}
}
