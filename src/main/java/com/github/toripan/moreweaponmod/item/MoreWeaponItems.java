package com.github.toripan.moreweaponmod.item;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MoreWeaponItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreWeaponMod.MOD_ID);

    //レジストリにアイテムを追加
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAMAHAGANE = ITEMS.register("tamahagane", () -> new Item(new Item.Properties()));

    //イベントバスを作成
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
