package net.doomednoctis.lamia.common.registry;

import net.doomednoctis.lamia.common.item.VampireClothingItem;
import net.doomednoctis.lamia.common.item.VampireClothingMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LamiaItemRegistry {
    public static final Item INJECTOR = registerItem("vampire_blood", new Item(new FabricItemSettings()));


    public static final ArmorMaterial VAMPIRE_CLOTHING_MATERIAL = new VampireClothingMaterial();
    public static final Item VAMPIRE_HAT = registerItem("vampire_hat", new VampireClothingItem(VAMPIRE_CLOTHING_MATERIAL, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item VAMPIRE_COAT = registerItem("vampire_coat", new VampireClothingItem(VAMPIRE_CLOTHING_MATERIAL, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item VAMPIRE_TROUSERS = registerItem("vampire_trousers", new VampireClothingItem(VAMPIRE_CLOTHING_MATERIAL, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item VAMPIRE_SHOES = registerItem("vampire_shoes", new VampireClothingItem(VAMPIRE_CLOTHING_MATERIAL, ArmorItem.Type.BOOTS,new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("lamia", name), item);
    }
    public static void registerItems(){
       // retu

    }
}
