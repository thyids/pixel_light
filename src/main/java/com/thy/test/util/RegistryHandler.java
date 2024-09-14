package com.thy.test.util;

import com.thy.test.armor.ModArmorMaterial;
import com.thy.test.blocks.BlockItemBase;
import com.thy.test.fluids.TestFluids;
import com.thy.test.items.NbApple;
import com.thy.test.tools.ModItemTier;
import net.minecraft.block.Block;
import com.thy.test.Test;
import com.thy.test.items.ItemBase;
import com.thy.test.blocks.Blue_Block;
import com.thy.test.blocks.BlueOre;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Test.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Test.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Test.MOD_ID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TestFluids.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //工具
    public static final RegistryObject<SwordItem> BLUE_SWORD = ITEMS.register("blue_sword",
            () -> new SwordItem(ModItemTier.BLUE, 50, 20.0F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<AxeItem> BLUE_AXE = ITEMS.register("blue_axe",
            () -> new AxeItem(ModItemTier.BLUE, 50, 20.0F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<ShovelItem> BLUE_SHOVEL = ITEMS.register("blue_shovel",
            () -> new ShovelItem(ModItemTier.BLUE, 50, 20.0F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<HoeItem> BLUE_HOE = ITEMS.register("blue_hoe",
            () -> new HoeItem(ModItemTier.BLUE, 50, 20.0F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<PickaxeItem> BLUE_PICKAXE = ITEMS.register("blue_pickaxe",
            () -> new PickaxeItem(ModItemTier.BLUE, 50, 20.0F, new Item.Properties().group(Test.TAB)));

    //盔甲
    public static final RegistryObject<ArmorItem> BLUE_HELMET = ITEMS.register("blue_helmet",
            () -> new ArmorItem(ModArmorMaterial.BLUE, EquipmentSlotType.HEAD, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<ArmorItem> BLUE_CHESTPLATE = ITEMS.register("blue_chestplate",
            () -> new ArmorItem(ModArmorMaterial.BLUE, EquipmentSlotType.CHEST, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<ArmorItem> BLUE_LEGS = ITEMS.register("blue_leggings",
            () -> new ArmorItem(ModArmorMaterial.BLUE, EquipmentSlotType.LEGS, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<ArmorItem> BLUE_BOOTS = ITEMS.register("blue_boots",
            () -> new ArmorItem(ModArmorMaterial.BLUE, EquipmentSlotType.FEET, new Item.Properties().group(Test.TAB)));

    //方块地上的
    public static final RegistryObject<Block> BLUE = BLOCKS.register("blue", Blue_Block::new);
    public static final RegistryObject<Block> BLUE_ORE = BLOCKS.register("blue_ore", BlueOre::new);

    //方块手上的
    public static final RegistryObject<Item> BLUE_ITEM = ITEMS.register("blue",() -> new BlockItemBase(BLUE.get()));
    public static final RegistryObject<Item> BLUE_ORE_ITEM = ITEMS.register("blue_ore",() -> new BlockItemBase(BLUE_ORE.get()));

    //物品
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemBase::new);

    //食物
    public static final RegistryObject<NbApple> NB_APPLE = ITEMS.register("nb_apple", NbApple::new);

    //流体(桶)
    public static final RegistryObject<Item> BLUETEST_BUCKET = ITEMS.register("bluetest_bucket",
            ()->new BucketItem(()->TestFluids.BLUETEST_FLUID.get(), new Item.Properties().maxStackSize(1).group(Test.TAB)));
}
