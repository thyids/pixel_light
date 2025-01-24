package com.thy.test.events;

import com.thy.test.Test;
import com.thy.test.key.YuanshenKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class YuanshenKeyEvents {

    @SubscribeEvent
    public static void pressKey(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if(mc.world == null) return;

        processKeyPress(mc, event.getKey());
    }

    private static void processKeyPress(Minecraft mc, int key){
        if(mc.currentScreen == null && YuanshenKeybinds.yuanshenKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("\u539f\u795e\u4e0b\u8f7d\u5730\u5740\uff1ahttps://ys.mihoyo.com/");
        }
    }
}
