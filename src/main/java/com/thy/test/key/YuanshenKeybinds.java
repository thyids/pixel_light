package com.thy.test.key;
import com.thy.test.Test;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;


@OnlyIn(Dist.CLIENT)
public class YuanshenKeybinds {
    public static KeyBinding yuanshenKey;
    public static void register(final FMLClientSetupEvent event){
        yuanshenKey = create("yuan_shen_key", KeyEvent.VK_Y);
        ClientRegistry.registerKeyBinding(yuanshenKey);
    }

    private static KeyBinding create(String name, int key){
        return new KeyBinding("key." + Test.MOD_ID + "." + name, key, "key.category." + Test.MOD_ID);
    }
}
