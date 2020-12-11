package com.hellbreecher.arcanum.common.screen.inventory;

public class GuiFermenter {
	
	/**
    private static final ResourceLocation fermenterGuiTextures = new ResourceLocation(
            "arcanum:textures/gui/Fermenter.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileFermenter tileFermenter;

    public GuiFermenter(InventoryPlayer invPlayer, TileFermenter tileEntityFurnace) {
        super(new containerFermenter(invPlayer, tileEntityFurnace));
        inventoryPlayer = invPlayer;
        tileFermenter = tileEntityFurnace;
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(fermenterGuiTextures);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        int l = getProgressLevel(24);
        drawTexturedModalRect(getGuiLeft() + 79, this.guiTop + 35, 176, 14, l + 1, 16);
    }

    protected void drawGuiContianerForegroundLayer(int mouseX, int mouseY) {
        String s = tileFermenter.getName();
        fontRenderer.drawString(s, this.xSize / 2 - fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        fontRenderer.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    private int getProgressLevel(int progressIndicatorPixelWidth) {
        int ticksSmeltItemSoFar = tileFermenter.getField(2);
        int ticksPerItem = tileFermenter.getField(3);
        return ticksPerItem != 0 && ticksSmeltItemSoFar != 0
                ? ticksSmeltItemSoFar * progressIndicatorPixelWidth / ticksPerItem
                : 0;
    }*/
}
