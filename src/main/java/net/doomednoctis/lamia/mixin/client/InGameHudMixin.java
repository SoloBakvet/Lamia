package net.doomednoctis.lamia.mixin.client;


import net.doomednoctis.lamia.api.LamiaAPI;
import net.doomednoctis.lamia.common.registry.LamiaComponentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Shadow
    @Final
    private MinecraftClient client;
    @Unique
    private static final Identifier EMPTY_BLOOD_ICON = new Identifier("lamia","blood_empty");
    @Unique
    private static final Identifier FULL_BLOOD_ICON = new Identifier("lamia","blood_full");
    @Unique
    private static final Identifier HALF_BLOOD_ICON = new Identifier("lamia", "blood_half");

    @Unique
    private static final Identifier EMPTY_ICON = new Identifier("lamia", "empty");

    @Unique
    private int renderedIcons;

    @Inject(method = "renderStatusBars",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", shift = At.Shift.AFTER, ordinal = 3))
    private void lamia$incrementRenderedIcons(DrawContext context, CallbackInfo ci){
        renderedIcons++;
    }

    @Inject(method = "renderStatusBars", at = @At("HEAD"))
    private void lamia$resetRenderedIcons(DrawContext context, CallbackInfo ci){
        renderedIcons = 0;
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", ordinal = 3), index = 0)
    private Identifier lamia$changeEmptyFoodIcon(Identifier value) {
        if(LamiaAPI.isVampire(client.player)){
            if(renderedIcons * 2 >= LamiaComponentRegistry.VAMPIRISM.get(client.player).getMaxBloodLevel()) {
                return EMPTY_ICON;
            }
            else {
                return EMPTY_BLOOD_ICON;
            }

        }
        return value;
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", ordinal = 4), index = 0)
    private Identifier lamia$changeFullFoodIcon(Identifier value) {
        if(LamiaAPI.isVampire(client.player)){
            return FULL_BLOOD_ICON;
        }
        return value;
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", ordinal = 5), index = 0)
    private Identifier lamia$changeHalfFoodIcon(Identifier value) {
        if(LamiaAPI.isVampire(client.player)){
            return HALF_BLOOD_ICON;
        }
        return value;
    }
}
