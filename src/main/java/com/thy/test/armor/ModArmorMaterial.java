package com.thy.test.armor;

import com.thy.test.Test;
import com.thy.test.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    BLUE(Test.MOD_ID + ":blue", 1, new int[] {10, 10, 10, 10},
            18, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 99999999.0F,
            () -> {return Ingredient.fromItems(RegistryHandler.SAPPHIRE.get());},
            99999);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 999999999, 999999999, 999999999, 999999999};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionArray;
    private final int enchantabilty;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionArray
                    , int enchantabilty, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial
                    , float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionArray = damageReductionArray;
        this.enchantabilty = enchantabilty;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantabilty;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return this.knockbackResistance;
    }
}
