package net.doomednoctis.lamia.client;

import net.doomednoctis.lamia.common.item.VampireClothingItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VampireClothingRenderer extends GeoArmorRenderer<VampireClothingItem> {
    public VampireClothingRenderer() {
        super(new VampireClothingModel());
    }

}
