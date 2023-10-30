package net.doomednoctis.lamia.api;

import net.doomednoctis.lamia.common.registry.LamiaComponentRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.Entity;

public class LamiaAPI {
    public static boolean isVampire(Entity entity){
        if(entity instanceof PlayerEntity){
            return LamiaComponentRegistry.VAMPIRISM.get(entity).isVampire();
        }
        return false;
    }

    public static void convertPlayer(ServerPlayerEntity playerEntity){
        LamiaComponentRegistry.VAMPIRISM.get(playerEntity).makeVampire();
        LamiaComponentRegistry.VAMPIRISM.sync(playerEntity);
    }
}
