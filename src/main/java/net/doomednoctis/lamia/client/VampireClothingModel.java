package net.doomednoctis.lamia.client;

import net.doomednoctis.lamia.common.item.VampireClothingItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class VampireClothingModel extends GeoModel<VampireClothingItem> {
    @Override
    public Identifier getModelResource(VampireClothingItem animatable) {
        return new Identifier("lamia","geo/vampire_clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(VampireClothingItem animatable) {
        return new Identifier("lamia","textures/armour/vampire_clothing.png");
    }

    @Override
    public Identifier getAnimationResource(VampireClothingItem animatable) {
        return new Identifier("lamia","animations/vampire_clothing.animation.json");
    }
}
