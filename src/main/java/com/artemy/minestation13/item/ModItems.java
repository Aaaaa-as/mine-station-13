package com.artemy.minestation13.item;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.item.custom.ChiselItem;
import com.artemy.minestation13.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword", new SwordItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,3,-2.4f))));

    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe", new PickaxeItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,1,-2.8f))));

    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe", new AxeItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,6f,-3.2f))));

    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe", new HoeItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,0,-3))));

    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel", new ShovelItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,1.5f,-3.0f))));

    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer", new HammerItem(ModToolMaterials.PINK_GARNET,new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,7f,-4.0f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MineStation13.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MineStation13.LOGGER.info("Registering Mod Items for " + MineStation13.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
