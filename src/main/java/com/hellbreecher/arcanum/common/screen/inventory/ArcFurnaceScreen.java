package com.hellbreecher.arcanum.common.screen.inventory;

import com.hellbreecher.arcanum.common.blocks.container.containerArcFurnace;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcFurnaceScreen extends ContainerScreen<containerArcFurnace> implements IHasContainer<containerArcFurnace> {
	
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("arcanum:textures/gui/ArcFurnace.png");
    private static final ITextComponent displayName = ITextComponent.func_244388_a("Arc Furnace");
    protected final PlayerInventory playerInv;
    //public final AbstractRecipeBookGui recipeGui;
    
    public ArcFurnaceScreen(containerArcFurnace container, PlayerInventory inv, ITextComponent titleIn) {
		super(container, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 176;
		this.ySize = 166;
		this.playerInv = inv;
		//this.recipeGui = recipeGuiIn;
    }
    
    //Background Layer
    protected void func_230450_a_(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
    	RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(furnaceGuiTextures);
        this.func_238474_b_(stack, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        int l = this.container.getCookProgressionScaled();
        this.func_238474_b_(stack, getGuiLeft() + 79, this.guiTop + 35, 176, 14, l + 1, 16);
    }

    //Foreground Layer
    protected void func_230451_b_(MatrixStack stack, int mouseX, int mouseY) {
        field_230712_o_.func_243248_b(stack, displayName, (float) this.xSize / 2 - field_230712_o_.getStringWidth(displayName.getString()) / 2, (float) 6, 4210752);
        field_230712_o_.func_243248_b(stack, playerInv.getDisplayName(), (float) 8, (float) this.ySize - 96 + 2, 4210752);
    }
}
