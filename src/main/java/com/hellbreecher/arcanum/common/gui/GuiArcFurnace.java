package com.hellbreecher.arcanum.common.gui;

import com.hellbreecher.arcanum.common.blocks.container.containerArcFurnace;
import com.hellbreecher.arcanum.common.blocks.tile.TileArcFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiArcFurnace extends GuiContainer {
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(
            "arcanum:textures/gui/ArcFurnace.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileArcFurnace tileArcFurnace;

    public GuiArcFurnace(InventoryPlayer invPlayer, TileArcFurnace tileEntityFurnace) {
        super(new containerArcFurnace(invPlayer, tileEntityFurnace));
        inventoryPlayer = invPlayer;
        tileArcFurnace = tileEntityFurnace;
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(furnaceGuiTextures);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        int l = getProgressLevel(24);
        this.drawTexturedModalRect(getGuiLeft() + 79, this.guiTop + 35, 176, 14, l + 1, 16);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = tileArcFurnace.getName();
        fontRenderer.drawString(s, this.xSize / 2 - fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        fontRenderer.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    private int getProgressLevel(int progressIndicatorPixelWidth) {
        int ticksSmeltItemSoFar = tileArcFurnace.getField(2);
        int ticksPerItem = tileArcFurnace.getField(3);
        return ticksPerItem != 0 && ticksSmeltItemSoFar != 0
                ? ticksSmeltItemSoFar * progressIndicatorPixelWidth / ticksPerItem
                : 0;
    }
}
