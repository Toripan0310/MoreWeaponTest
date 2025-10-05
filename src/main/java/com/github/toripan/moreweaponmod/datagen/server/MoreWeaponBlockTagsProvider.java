package com.github.toripan.moreweaponmod.datagen.server;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MoreWeaponBlockTagsProvider extends BlockTagsProvider {
    public MoreWeaponBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoreWeaponMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MoreWeaponBlocks.ORIHALCON_BLOCK.get(),
                        MoreWeaponBlocks.STEEL_BLOCK.get(),
                        MoreWeaponBlocks.TAMAHAGANE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(MoreWeaponBlocks.STEEL_BLOCK.get(),
                        MoreWeaponBlocks.TAMAHAGANE_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(MoreWeaponBlocks.ORIHALCON_BLOCK.get());

    }
}
