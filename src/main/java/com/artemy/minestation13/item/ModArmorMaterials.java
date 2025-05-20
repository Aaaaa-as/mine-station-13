package com.artemy.minestation13.item;

import com.artemy.minestation13.MineStation13;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> PINK_GARNET_ARMOR_MATERIAL = registerArmorMaterial("pink_garnet",
            ()->new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map->{
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }),25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,()-> Ingredient.ofItems(ModItems.PINK_GARNET),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MineStation13.MOD_ID,"pink_garnet"))),2,0));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, MineStation13.id(name), material.get());
    }
}
