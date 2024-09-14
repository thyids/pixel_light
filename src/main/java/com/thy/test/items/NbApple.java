package com.thy.test.items;

import com.thy.test.Test;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class NbApple extends Item {
    public NbApple() {
        super(new Item.Properties()
                .group(Test.TAB)
                .food(new Food.Builder()
                        .hunger(100)
                        .saturation(0.1f)
                        .effect(new EffectInstance(Effects.NIGHT_VISION, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.DOLPHINS_GRACE, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.HASTE, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.HEALTH_BOOST, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 99999999, 9), 1.0f)
                        .effect(new EffectInstance(Effects.INSTANT_HEALTH, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.LUCK, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.REGENERATION, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.SATURATION, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.SLOW_FALLING, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.SPEED, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.STRENGTH, 99999999, 29), 1.0f)
                        .effect(new EffectInstance(Effects.WATER_BREATHING, 99999999, 29), 1.0f)
                        .meat()
                        .fastToEat()
                        .setAlwaysEdible()
                        .build()));
    }
}
