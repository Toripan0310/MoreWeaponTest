package com.github.toripan.moreweaponmod.datagen;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.datagen.client.ENUSLanguageProvider;
import com.github.toripan.moreweaponmod.datagen.client.JAJPLanguageProvider;
import com.github.toripan.moreweaponmod.datagen.client.MoreWeaponBlockStateProvider;
import com.github.toripan.moreweaponmod.datagen.client.MoreWeaponItemModelProvider;
import com.github.toripan.moreweaponmod.datagen.server.MoreWeaponBlockTagsProvider;
import com.github.toripan.moreweaponmod.datagen.server.MoreWeaponGlobalLootModifierProvider;
import com.github.toripan.moreweaponmod.datagen.server.MoreWeaponRecipeProvider;
import com.github.toripan.moreweaponmod.datagen.server.loot.MoreWeaponLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MoreWeaponMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreWeaponDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new MoreWeaponItemModelProvider(packOutput
                             , existingFileHelper));
        generator.addProvider(event.includeClient(),
                new MoreWeaponBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));
        generator.addProvider(event.includeServer(), new MoreWeaponRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), MoreWeaponLootTables.create(packOutput));
        generator.addProvider(event.includeServer(), new MoreWeaponBlockTagsProvider(packOutput,
                lookUpProvider, existingFileHelper));
        generator.addProvider(event.includeServer(),
                new MoreWeaponGlobalLootModifierProvider(packOutput));
    }
}
