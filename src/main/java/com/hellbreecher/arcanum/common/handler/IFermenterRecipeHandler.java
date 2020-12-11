package com.hellbreecher.arcanum.common.handler;

public class IFermenterRecipeHandler {
	
	/**
    private static final IFermenterRecipeHandler FERMENTING_BASE = new IFermenterRecipeHandler();

    public static IFermenterRecipeHandler instance() {
        return FERMENTING_BASE;
    }

    private final Map<ItemStack, ItemStack> fermentingList = Maps.newHashMap();

    private final Map<ItemStack, Float> experienceList = Maps.newHashMap();

    private IFermenterRecipeHandler() {
        addfermenting(ArcanumFood.itemUnfermentedBeer, new ItemStack(ArcanumFood.itemFermentedBeer), 1.0F);
        addfermenting(Items.WATER_BUCKET, new ItemStack(ArcanumFood.itemCortonWine), 1.0F);
    }

    public void addfermenting(Item input, ItemStack stack, float experience) {
        addfermentingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addfermentingRecipe(ItemStack input, ItemStack result, float experience) {
        if (getFermentingResult(input) != ItemStack.EMPTY) {
            FMLLog.log.info("Ignored fermenting recipe with conflicting input: {} = {}", input, result);
            return;
        }
        fermentingList.put(input, result);
        experienceList.put(result, Float.valueOf(experience));
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem()
                && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getfermentingList() {
        return fermentingList;
    }

    public ItemStack getFermentingResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : fermentingList.entrySet()) {
            if (compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    } */
}
