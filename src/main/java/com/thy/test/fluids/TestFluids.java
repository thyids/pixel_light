package com.thy.test.fluids;

import com.thy.test.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class TestFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final RegistryObject<FlowingFluid> BLUETEST_FLUID = RegistryHandler.FLUIDS.register("bluetest_fluid",
            () -> new ForgeFlowingFluid.Source(TestFluids.BLUETEST_PROPERTIES));

    public static final RegistryObject<FlowingFluid> BLUETEST_FLOWING = RegistryHandler.FLUIDS.register("bluetest_flowing",
            () -> new ForgeFlowingFluid.Flowing(TestFluids.BLUETEST_PROPERTIES));

    public static final ForgeFlowingFluid.Properties BLUETEST_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> BLUETEST_FLUID.get(), () -> BLUETEST_FLOWING.get(),
            FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
                    .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(WATER_OVERLAY_RL)
                    .color(0xffB22222)).slopeFindDistance(3).levelDecreasePerBlock(2)
            .block(()->TestFluids.BLUETEST_BLOCK.get()).bucket(() -> RegistryHandler.BLUETEST_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> BLUETEST_BLOCK = RegistryHandler.BLOCKS.register("bluetest",
            () -> new FlowingFluidBlock(()->TestFluids.BLUETEST_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .hardnessAndResistance(0f)));

    public static void register(IEventBus eventBus){RegistryHandler.FLUIDS.register(eventBus);}
}
