package com.github.toripan.moreweaponmod.datagen.server.loot;

import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class MoreWeaponBlockLootTables extends BlockLootSubProvider {
    protected MoreWeaponBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(MoreWeaponBlocks.ORIHALCON_BLOCK.get());
        this.dropSelf(MoreWeaponBlocks.TAMAHAGANE_BLOCK.get());
        this.dropSelf(MoreWeaponBlocks.STEEL_BLOCK.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MoreWeaponBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
