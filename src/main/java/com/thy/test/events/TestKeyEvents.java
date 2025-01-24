package com.thy.test.events;

import com.thy.test.Test;
import com.thy.test.key.TestKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TestKeyEvents {

    @SubscribeEvent
    public static void pressKey(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if(mc.world == null) return;

        processKeyPress(mc, event.getKey());
    }

    private static void processKeyPress(Minecraft mc, int key){
        if(mc.currentScreen == null && TestKeybinds.testKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("\u4f60\u597d");
        }
    }
}
