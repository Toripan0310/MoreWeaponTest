package com.github.toripan.moreweaponmod.block;

import com.github.toripan.moreweaponmod.MoreWeaponMod;
import com.github.toripan.moreweaponmod.item.MoreWeaponItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MoreWeaponBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoreWeaponMod.MOD_ID);

    //レジストリにブロックを追加
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlockItem("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TAMAHAGANE_BLOCK = registerBlockItem("tamahagane_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ORIHALCON_BLOCK = registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        MoreWeaponItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    //ブロックイベントバスを作成
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
