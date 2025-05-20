package com.artemy.minestation13.item;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.item.custom.ChiselItem;
import com.artemy.minestation13.item.custom.HammerItem;
import com.artemy.minestation13.item.custom.ModArmorItem;
import com.artemy.minestation13.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
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

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33))));

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33))));

    public static final Item PINK_GARNET_LEGGINS = registerItem("pink_garnet_leggins",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33))));

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33))));

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                    AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item KAUPEN_SMITHING_TEMPLATE = registerItem("kaupen_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(MineStation13.MOD_ID,"kaupen"), FeatureFlags.VANILLA));

    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    public static final Item HONEY_BERRIES = registerItem("honey_berries",
            new AliasedBlockItem(ModBlocks.HONEY_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.HONEY_BERRIES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, MineStation13.id(name), item);
    }


    public static void registerModItems() {
        MineStation13.LOGGER.info("Registering Mod Items for " + MineStation13.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CAULIFLOWER);
            entries.add(HONEY_BERRIES);
        });
    }
}
