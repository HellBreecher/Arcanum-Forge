package com.hellbreecher.arcanum.common.blocks.container;

import com.hellbreecher.arcanum.common.blocks.tile.tileentityArcFurnace;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

public abstract class AbstractArcFurnaceContainer extends RecipeBookContainer<IInventory> {
    
	private final IInventory furnaceInv;
	private final IIntArray furnaceData;
	protected final World world;
	private final IRecipeType<? extends AbstractCookingRecipe> recipeType;
	private final RecipeBookCategory recipeCat;
	
    //server
    protected AbstractArcFurnaceContainer(ContainerType<?> arcfurnaceContainer, IRecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeCat, int index, PlayerInventory playerInv) {
    	this(arcfurnaceContainer, recipeType, recipeCat, index, playerInv, new Inventory(3), new IntArray(4));
    }

    //Client
    protected AbstractArcFurnaceContainer(ContainerType<?> arcfurnaceContainer, IRecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeCat, int index, PlayerInventory playerInv, IInventory furnaceInv, IIntArray fields) {
		super(arcfurnaceContainer, index);
    	this.recipeType = recipeType;
        this.recipeCat = recipeCat;
        assertInventorySize(furnaceInv, 2);
        assertIntArraySize(fields, 4);
        this.furnaceInv = furnaceInv;
        this.furnaceData = fields;
        this.world = playerInv.player.world;
		
        int startX = 8;
        int slotSizePlus2 = 18;
        
		//Hotbar
		int hotbarY = 142;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(playerInv, column, startX + (column * slotSizePlus2), hotbarY));
		}
		
		//Main Player Inventory
		final int startY = 84;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		
		//Furnace Slots
		this.addSlot(new Slot(furnaceInv, 0, 50, 35));
		this.addSlot(new FurnaceResultSlot(playerInv.player, furnaceInv, 1, 116, 35));
    }    
    
    public boolean canInteractWith(PlayerEntity playerIn) {
    	return this.furnaceInv.isUsableByPlayer(playerIn);
    }
    
    public int getOutputSlot() {
    	return 1;
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getSize() {
    	return 2;
    }

    public ItemStack transferStackinSlot(PlayerEntity playerIn, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()) {
        	final ItemStack slotStack = slot.getStack();
        	returnStack = slotStack.copy();
        	final int containerSlots = this.inventorySlots.size() - playerIn.inventory.mainInventory.size();
        	
        	if(index < containerSlots) {
        		if(!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {
        			return ItemStack.EMPTY;
        		}
        	}else if (!mergeItemStack(slotStack, 0, containerSlots, false)) return ItemStack.EMPTY;
        	
        	if(slotStack.getCount() == 0) slot.putStack(ItemStack.EMPTY);
        	else slot.onSlotChanged();
        	
        	if(slotStack.getCount() == returnStack.getCount()) return ItemStack.EMPTY;
        	
        	slot.onTake(playerIn, slotStack);
        }
        return returnStack;
    }

    protected boolean hasRecipe(ItemStack stack) {
    	return this.world.getRecipeManager().getRecipe((IRecipeType)this.recipeType, new Inventory(stack), this.world).isPresent();
    }
    
    protected boolean isFuel(ItemStack stack) {
    	return tileentityArcFurnace.isFuel(stack);
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getCookProgressionScaled() {
    	int i = this.furnaceData.get(2);
    	int j = this.furnaceData.get(3);
    	return j != 0 && i != 0 ? i * 24 / j : 0;
    }
    @OnlyIn(Dist.CLIENT)
    public int getBurnLeftScaled() {
    	int i = this.furnaceData.get(1);
    	if (i == 0) i = 200;
    	return this.furnaceData.get(0) * 13 / i;
    }
    @OnlyIn(Dist.CLIENT) 
    public boolean isBurning() {
    	return this.furnaceData.get(0) > 0;
    }
    
	public void fillStackedContents(RecipeItemHelper itemHelperIn) {
		if(this.furnaceInv instanceof IRecipeHelperPopulator) {
			((IRecipeHelperPopulator)this.furnaceInv).fillStackedContents(itemHelperIn);
		}
	}

	public void clear() {
		this.furnaceInv.clear();		
	}

	public boolean matches(IRecipe<? super IInventory> recipeIn) {
		return recipeIn.matches(this.furnaceInv, this.world);
	}

	public int getWidth() {
		return 1;
	}

	public int getHeight() {
		return 1;
	}
	
	@OnlyIn(Dist.CLIENT)
	public RecipeBookCategory func_241850_m() {
		return this.recipeCat;
	}
}
