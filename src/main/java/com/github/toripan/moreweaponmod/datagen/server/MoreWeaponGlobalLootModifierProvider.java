package com.github.toripan.moreweaponmod.datagen.server;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import com.github.toripan.moreweaponmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class MoreWeaponGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public MoreWeaponGlobalLootModifierProvider(PackOutput output) {
        super(output, MoreWeaponMod.MOD_ID);
    }

    @Override
    @SuppressWarnings({ "unchecked", "removal" })
    protected void start() {
        //はいポータルのルート
        add("orihalcon_ingot_from_ruined_portal", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation(MoreWeaponMod.MOD_ID, "chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        }, MoreWeaponItems.ORIHALCON_INGOT.get()));
        //スニッファー
        add("orihalcon_ingot_from_sniffer_digging", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation(MoreWeaponMod.MOD_ID, "gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        }, MoreWeaponItems.ORIHALCON_INGOT.get()));

    }
}
