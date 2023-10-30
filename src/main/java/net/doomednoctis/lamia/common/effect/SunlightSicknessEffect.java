package net.doomednoctis.lamia.common.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class SunlightSicknessEffect extends StatusEffect {
    public SunlightSicknessEffect() {
        super(      StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0x98D982); // color in RGB);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        Vec3d pos = entity.getPos();
        if (entity.getWorld() != null && entity.getWorld() instanceof ServerWorld) {
            ((ServerWorld) entity.getWorld()).spawnParticles(
                    ParticleTypes.SMOKE,
                    pos.x - entity.getWidth()/4.0,
                    pos.y,
                    pos.z - entity.getWidth()/4.0,
                    10,
                    entity.getWidth()/2.0,
                    entity.getHeight()/2.0,
                    entity.getWidth()/2.0,
                    0.0
                    );
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
