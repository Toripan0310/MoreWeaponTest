package com.github.toripan.moreweaponmod;

import com.github.toripan.moreweaponmod.block.MoreWeaponBlocks;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import com.github.toripan.moreweaponmod.item.MoreWeaponTab;
import com.github.toripan.moreweaponmod.loot.MoreWeaponLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreWeaponMod.MOD_ID)
public class MoreWeaponMod
{
    public static final String MOD_ID = "moreweaponmod";

    private static final Logger LOGGER = LogUtils.getLogger();


    public MoreWeaponMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムイベントバスを登録
        MoreWeaponItems.register(modEventBus);
        //タブイベントバスを登録
        MoreWeaponTab.register(modEventBus);
        //ブロックイベントバスを登録
        MoreWeaponBlocks.register(modEventBus);
        //ルートイベントバスを登録
        MoreWeaponLootModifiers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(MoreWeaponItems.STEEL_INGOT.get());
            event.accept(MoreWeaponItems.ORIHALCON_INGOT.get());
            event.accept(MoreWeaponItems.TAMAHAGANE.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
