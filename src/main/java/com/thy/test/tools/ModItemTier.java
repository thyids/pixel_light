package com.thy.test.tools;

import com.thy.test.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    BLUE(4, 999999999, 80.0F, 3.0F, 16,
            () -> {return Ingredient.fromItems(RegistryHandler.BLUE_SWORD.get());});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel,int maxUses,float efficiency,float attackDamage,int enchantability,Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.efficiency = efficiency;
        this.enchantability = enchantability;
        this.attackDamage = attackDamage;
        this.maxUses = maxUses;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
