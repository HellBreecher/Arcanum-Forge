package com.hellbreecher.arcanum.common.screen.inventory;

public class GuiMCUFurnace {
	
	/**
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(
            "arcanum:textures/gui/mcufurnace.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileMCUFurnace tileMCUFurnace;

    public GuiMCUFurnace(InventoryPlayer invPlayer, TileMCUFurnace tileEntityFurnace) {
        super(new containerMCUFurnace(invPlayer, tileEntityFurnace));
        inventoryPlayer = invPlayer;
        tileMCUFurnace = tileEntityFurnace;
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(furnaceGuiTextures);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        if (TileMCUFurnace.isBurning(tileMCUFurnace)) {
            int k = getBurnLeftScaled(13);
            drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        int l = getProgressLevel(24);
        drawTexturedModalRect(getGuiLeft() + 79, this.guiTop + 35, 176, 14, l + 1, 16);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = tileMCUFurnace.getName();
        fontRenderer.drawString(s, this.xSize / 2 - fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        fontRenderer.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    private int getBurnLeftScaled(int pixels) {
        int i = tileMCUFurnace.getField(1);
        if (i == 0) {
            i = 200;
        }
        return tileMCUFurnace.getField(0) * pixels / i;
    }

    private int getProgressLevel(int progressIndicatorPixelWidth) {
        int ticksSmeltItemSoFar = tileMCUFurnace.getField(2);
        int ticksPerItem = tileMCUFurnace.getField(3);
        return ticksPerItem != 0 && ticksSmeltItemSoFar != 0
                ? ticksSmeltItemSoFar * progressIndicatorPixelWidth / ticksPerItem
                : 0;
    } */
}
