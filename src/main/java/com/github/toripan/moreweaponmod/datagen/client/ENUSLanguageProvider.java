package com.github.toripan.moreweaponmod.datagen.client;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, MoreWeaponMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(MoreWeaponItems.ORIHALCON_INGOT, "Orihalcon Ingot");
        addItem(MoreWeaponItems.STEEL_INGOT, "Steel Ingot");
        addItem(MoreWeaponItems.TAMAHAGANE, "Tamahagane");

        add("creativetabs.moreweapontab", "MoreWeaponMod");

        addBlock(MoreWeaponBlocks.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(MoreWeaponBlocks.STEEL_BLOCK, "Steel Block");
        addBlock(MoreWeaponBlocks.TAMAHAGANE_BLOCK, "Tamahagane Block");
    }
}
