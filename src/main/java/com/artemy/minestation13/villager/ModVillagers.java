package com.artemy.minestation13.villager;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> KAUPEN_POI_KEY = registerPoiKey("kaupen_poi");
    public static final PointOfInterestType KAUPEN_POI = registerPOI("kaupen_poi", ModBlocks.CHAIR);

    public static final VillagerProfession KAUPENGER = registerProfession("kaupenger", KAUPEN_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, MineStation13.id(name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(MineStation13.id(name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, MineStation13.id(name));
    }

    public static void registerVillagers() {
        MineStation13.LOGGER.info("Registering Mod Villagers for " + MineStation13.MOD_ID);
    }
}
