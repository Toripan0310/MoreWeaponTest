package com.github.toripan.moreweaponmod.datagen.server;

import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import java.util.function.Consumer;

public class MoreWeaponRecipeProvider extends RecipeProvider {
    public MoreWeaponRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                MoreWeaponItems.STEEL_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MoreWeaponBlocks.STEEL_BLOCK.get()
        );
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                MoreWeaponItems.ORIHALCON_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MoreWeaponBlocks.ORIHALCON_BLOCK.get()
        );
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                MoreWeaponItems.TAMAHAGANE.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MoreWeaponBlocks.TAMAHAGANE_BLOCK.get()
        );
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer);
    }
}
