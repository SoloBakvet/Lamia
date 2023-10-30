package net.doomednoctis.lamia.mixin;

import net.doomednoctis.lamia.api.LamiaAPI;
import net.doomednoctis.lamia.common.registry.LamiaComponentRegistry;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HungerManager.class)
public class HungerManagerMixin {

    @Unique
    private boolean isVampire;
    @Unique private PlayerEntity player;

    @Inject(method = "getFoodLevel", at = @At("HEAD"), cancellable = true)
    void lamia$getBloodLevel(CallbackInfoReturnable<Integer> cir) {
        if(isVampire) {
            cir.setReturnValue((int) LamiaComponentRegistry.VAMPIRISM.get(player).getBloodLevel());
        }
    }

    @Inject(method = "getSaturationLevel", at = @At("HEAD"), cancellable = true)
    void lamia$fakeSaturationLevel(CallbackInfoReturnable<Float> cir) {
        if(isVampire) {
            cir.setReturnValue(0f);
        }

    }

    @Inject(method = "update", at = @At("HEAD"), cancellable = true)
    void lamia$setVampire(PlayerEntity player, CallbackInfo ci) {
        this.isVampire = LamiaAPI.isVampire(player);
        this.player = player;

        if (this.isVampire) {
            ci.cancel();
        }
    }

}
