package com.thy.test;

import com.thy.test.fluids.TestFluids;
import com.thy.test.key.TestKeybinds;
import com.thy.test.key.YuanshenKeybinds;
import com.thy.test.util.RegistryHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("test")
public class Test
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "test";

    public Test() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        RegistryHandler.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(TestFluids.BLUETEST_FLUID.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(TestFluids.BLUETEST_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(TestFluids.BLUETEST_FLOWING.get(), RenderType.getTranslucent());

        TestKeybinds.register(event);
        YuanshenKeybinds.register(event);
    }

    public static final ItemGroup TAB = new ItemGroup("testTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.STONE);
        }
    };
}
