package net.doomednoctis.lamia;

import com.mojang.brigadier.Command;
import net.doomednoctis.lamia.api.LamiaAPI;
import net.doomednoctis.lamia.common.registry.LamiaEffectRegistry;
import net.doomednoctis.lamia.common.registry.LamiaItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class Lamia implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, access, environment) -> {
            dispatcher.register(CommandManager.literal("getStatus").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                    .then(CommandManager.argument("player", EntityArgumentType.player()).executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if(player != null){
                            context.getSource().sendFeedback(() -> Text.literal("Vampiric: " + LamiaAPI.isVampire(player)), true);
                            return Command.SINGLE_SUCCESS;
                        }
                        return 0;
                    })));

            dispatcher.register(CommandManager.literal("convert").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                    .then(CommandManager.argument("player", EntityArgumentType.player()).executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if(player != null){
                            LamiaAPI.convertPlayer(player);
                            return Command.SINGLE_SUCCESS;
                        }
                        return 0;
                    })));

        });

        LamiaEffectRegistry.registerEffects();
        LamiaItemRegistry.registerItems();

    }
}
