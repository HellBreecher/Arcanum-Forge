package com.hellbreecher.arcanum.common.blocks.container;

import com.hellbreecher.arcanum.common.blocks.tile.TileArcFurnace;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.datafix.fixes.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class containerArcFurnace extends AbstractFurnaceContainer {
    private final IInventory furnaceInventory;
    private final IIntArray furnacedata;
    protected final World world;
    private final IRecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipeBookCategory category;
    
    protected containerArcFurnace(ContainerType<?> furnaceCont, IRecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeCategory, int field4, PlayerInventory playerInv) {
    	this(furnaceCont, recipeType, recipeCategory, field4, playerInv, new Inventory(2), new IntArray(4));
    }
    
    protected containerArcFurnace(ContainerType<?> furnaceCont, IRecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeCategory, int field4, PlayerInventory playerInv, IInventory slots, IIntArray fields) {
        super(furnaceCont, recipeType, recipeCategory, field4, playerInv, slots, fields);
        this.recipeType = recipeType;
        this.category = recipeCategory;
        assertInventorySize(slots, 2);
        assertIntArraySize(fields, 4);
        this.furnaceInventory = slots;
        this.furnacedata = fields;
        this.world = playerInv.player.world;
        
        this.addSlot(new Slot(slots, 0, 50, 35));
        this.addSlot(new FurnaceResultSlot(playerInv.player, slots, 1, 116, 35));
        
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (int x = 0; x < 9; x++) {
            this.addSlot(new Slot(playerInv, x, 8 + x * 18, 142));
        }
        
        this.trackIntArray(fields);
    }

    
    public int getOutputSlot() {
    	return 1;
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getSize() {
    	return 2;
    }

    public ItemStack transferStackinSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot) inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2) {
                if (!mergeItemStack(itemstack1, 3, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1 && index != 0) {
                if (this.hasRecipe(itemstack1)) {
                    if (!mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (TileArcFurnace.isFuel(itemstack1)) {
                    if (!mergeItemStack(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 3 && index < 30) {
                    if (!mergeItemStack(itemstack1, 30, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 30 && index < 39 && !mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(itemstack1, 3, 38, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }
}
