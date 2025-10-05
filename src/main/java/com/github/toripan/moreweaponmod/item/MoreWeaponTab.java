package com.github.toripan.moreweaponmod.item;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MoreWeaponTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreWeaponMod.MOD_ID);

    //レジストリにタブを追加
    public static final RegistryObject<CreativeModeTab> MoreWeaponTab = TABS.register("moreweapontab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.moreweapontab"))
                    .icon(MoreWeaponItems.STEEL_INGOT.get()::getDefaultInstance)
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(MoreWeaponItems.STEEL_INGOT.get());
                        pOutput.accept(MoreWeaponItems.TAMAHAGANE.get());
                        pOutput.accept(MoreWeaponItems.ORIHALCON_INGOT.get());
                        pOutput.accept(MoreWeaponBlocks.STEEL_BLOCK.get());
                        pOutput.accept(MoreWeaponBlocks.TAMAHAGANE_BLOCK.get());
                        pOutput.accept(MoreWeaponBlocks.ORIHALCON_BLOCK.get());
                    })
                    .build());

    //タブイベントバスを作成
    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
