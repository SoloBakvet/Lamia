package net.doomednoctis.lamia.common.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.item.Items;

public class VampireClothingMaterial implements ArmorMaterial {
    @Override
    public int getDurability(ArmorItem.Type type) {
        return ArmorMaterials.CHAIN.getDurability(type);
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return ArmorMaterials.LEATHER.getProtection(type);
    }

    @Override
    public int getEnchantability() {
        return ArmorMaterials.CHAIN.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.LEATHER.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.LEATHER);
    }

    @Override
    public String getName() {
        return "vampire_clothing";
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.CHAIN.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.CHAIN.getKnockbackResistance() ;
    }
}
