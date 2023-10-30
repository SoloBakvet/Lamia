package net.doomednoctis.lamia.common.registry;

import net.doomednoctis.lamia.common.effect.SunlightSicknessEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class LamiaEffectRegistry {
    public static final StatusEffect SUNLIGHT_SICKNESS = new SunlightSicknessEffect() ;

    public static void registerEffects(){
        Registry.register(Registries.STATUS_EFFECT, new Identifier("lamia", "sunlight_sickness"), SUNLIGHT_SICKNESS);
    }
}
