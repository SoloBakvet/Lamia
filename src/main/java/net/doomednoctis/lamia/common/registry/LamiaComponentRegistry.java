package net.doomednoctis.lamia.common.registry;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.doomednoctis.lamia.common.component.VampiricPlayerComponent;
import net.minecraft.util.Identifier;

public class LamiaComponentRegistry implements EntityComponentInitializer {
    public static final ComponentKey<VampiricPlayerComponent> VAMPIRISM =
            ComponentRegistry.getOrCreate(new Identifier("lamia", "vampirism"), VampiricPlayerComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(VAMPIRISM, VampiricPlayerComponent::new, RespawnCopyStrategy.CHARACTER);

    }
}
