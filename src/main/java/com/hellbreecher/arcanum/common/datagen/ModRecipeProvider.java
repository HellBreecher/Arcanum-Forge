package com.hellbreecher.arcanum.common.datagen;

import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    protected <FinishedRecipe> void buildRecipes(Consumer<FinishedRecipe> consumer) {

    }

	@Override
	protected void buildRecipes(RecipeOutput p_297267_) {
		// TODO Auto-generated method stub
		
	}
	
}
