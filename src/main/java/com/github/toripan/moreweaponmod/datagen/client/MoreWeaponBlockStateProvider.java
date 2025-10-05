package com.github.toripan.moreweaponmod.datagen.client;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class MoreWeaponBlockStateProvider extends BlockStateProvider {
    public MoreWeaponBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreWeaponMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(MoreWeaponBlocks.ORIHALCON_BLOCK);
        simpleBlockWithItem(MoreWeaponBlocks.STEEL_BLOCK);
        simpleBlockWithItem(MoreWeaponBlocks.TAMAHAGANE_BLOCK);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
