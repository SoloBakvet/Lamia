package net.doomednoctis.lamia.api.component;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;

public interface IVampiricPlayer extends ComponentV3, ServerTickingComponent {
    boolean isVampire();
    void makeVampire();

    int getBloodLevel();
    int getMaxBloodLevel();

    float getBloodSaturationLevel();

}
