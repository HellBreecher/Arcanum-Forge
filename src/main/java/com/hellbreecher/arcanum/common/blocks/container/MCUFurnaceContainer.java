package com.hellbreecher.arcanum.common.blocks.container;

public class MCUFurnaceContainer {
	
	/**
    private final IInventory tileMCUFurnace;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;

    public containerMCUFurnace(InventoryPlayer playerInventory, TileMCUFurnace furnaceInventory) {
        tileMCUFurnace = furnaceInventory;
        addSlotToContainer(new Slot(furnaceInventory, 0, 56, 17));
        addSlotToContainer(new Slot(furnaceInventory, 1, 56, 53));
        addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 2, 116, 35));
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (int x = 0; x < 9; x++) {
            addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, tileMCUFurnace);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        tileMCUFurnace.setField(id, data);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < listeners.size(); i++) {
            IContainerListener icontainerlistener = (IContainerListener) listeners.get(i);
            if (cookTime != tileMCUFurnace.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, tileMCUFurnace.getField(2));
            }
            if (furnaceBurnTime != tileMCUFurnace.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, tileMCUFurnace.getField(0));
            }
            if (currentItemBurnTime != tileMCUFurnace.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, tileMCUFurnace.getField(1));
            }
            if (totalCookTime != tileMCUFurnace.getField(3)) {
                icontainerlistener.sendWindowProperty(this, 3, tileMCUFurnace.getField(3));
            }
        }
        cookTime = tileMCUFurnace.getField(2);
        furnaceBurnTime = tileMCUFurnace.getField(0);
        currentItemBurnTime = tileMCUFurnace.getField(1);
        totalCookTime = tileMCUFurnace.getField(3);
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileMCUFurnace.isUsableByPlayer(playerIn);
    }

    public ItemStack transferStackinSlot(EntityPlayer playerIn, int index) {
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
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty()) {
                    if (!mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (TileMCUFurnace.isItemFuel(itemstack1)) {
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
    }*/
}
