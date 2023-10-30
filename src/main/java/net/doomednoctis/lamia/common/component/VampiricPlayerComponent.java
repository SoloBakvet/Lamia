package net.doomednoctis.lamia.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.doomednoctis.lamia.api.IVampiricRank;
import net.doomednoctis.lamia.api.VampiricRank;
import net.doomednoctis.lamia.api.component.IVampiricPlayer;
import net.doomednoctis.lamia.common.module.rank.FledglingRank;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class VampiricPlayerComponent implements IVampiricPlayer, AutoSyncedComponent {

    PlayerEntity player;

    private boolean isVampire;
    private int bloodLevel;
    private int maxBloodLevel;
    private float sunExposure;

    private VampiricRank rank;

    public VampiricPlayerComponent(PlayerEntity player){
        isVampire = false;
        bloodLevel = 5;
        maxBloodLevel = 8;
        sunExposure = 0;
        rank = VampiricRank.FLEDGLING;
        this.player = player;
    }
    @Override
    public boolean isVampire() {
        return isVampire;
    }

    @Override
    public void makeVampire() {
        isVampire = true;
        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addPersistentModifier(new EntityAttributeModifier("Test",5, EntityAttributeModifier.Operation.ADDITION));
    }

    @Override
    public int getBloodLevel() {
        return bloodLevel;
    }

    @Override
    public int getMaxBloodLevel() {
        return maxBloodLevel;
    }

    @Override
    public float getBloodSaturationLevel() {
        return 0;
    }

    @Override
    public void serverTick() {
        if(player.getWorld().isDay() && !player.getWorld().isRaining() && player.getWorld().isSkyVisible(player.getBlockPos())){
            Vec3d pos = player.getPos();
            if (player.getWorld() != null && player.getWorld() instanceof ServerWorld) {
                ((ServerWorld) player.getWorld()).spawnParticles(
                        ParticleTypes.SMOKE,
                        pos.x - player.getWidth()/4.0,
                        pos.y,
                        pos.z - player.getWidth()/4.0,
                        10,
                        player.getWidth()/2.0,
                        player.getHeight()/2.0,
                        player.getWidth()/2.0,
                        0.0
                );
            }
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        isVampire = tag.getBoolean("lamia.isVampire");
        bloodLevel = tag.getInt("lamia.bloodLevel");
        maxBloodLevel = tag.getInt("lamia.maxBloodLevel");;
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putBoolean("lamia.isVampire",isVampire);
        tag.putInt("lamia.bloodLevel", bloodLevel);
        tag.putInt("lamia.maxBloodLevel", maxBloodLevel);
    }
}
