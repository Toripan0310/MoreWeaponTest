package com.github.toripan.moreweaponmod.datagen.client;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, MoreWeaponMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(MoreWeaponItems.ORIHALCON_INGOT, "オリハルコンインゴット");
        addItem(MoreWeaponItems.STEEL_INGOT, "スチールインゴット");
        addItem(MoreWeaponItems.TAMAHAGANE, "玉鋼");

        add("creativetabs.moreweapontab", "MoreWeaponMod");

        addBlock(MoreWeaponBlocks.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(MoreWeaponBlocks.STEEL_BLOCK, "スチールブロック");
        addBlock(MoreWeaponBlocks.TAMAHAGANE_BLOCK, "玉鋼ブロック");
    }
}
