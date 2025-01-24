package com.thy.test.key;
import com.thy.test.Test;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;


@OnlyIn(Dist.CLIENT)
public class TestKeybinds {
    public static KeyBinding testKey;
    public static void register(final FMLClientSetupEvent event){
        testKey = create("test_key", KeyEvent.VK_H);
        ClientRegistry.registerKeyBinding(testKey);
    }

    private static KeyBinding create(String name, int key){
        return new KeyBinding("key." + Test.MOD_ID + "." + name, key, "key.category." + Test.MOD_ID);
    }
}
