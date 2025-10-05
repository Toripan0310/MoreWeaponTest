package com.github.toripan.moreweaponmod.datagen.client;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MoreWeaponItemModelProvider extends ItemModelProvider {
    public MoreWeaponItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreWeaponMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(MoreWeaponItems.ORIHALCON_INGOT.get());
        basicItem(MoreWeaponItems.STEEL_INGOT.get());
        basicItem(MoreWeaponItems.TAMAHAGANE.get());
    }
}
