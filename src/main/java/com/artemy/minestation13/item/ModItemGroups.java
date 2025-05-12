package com.artemy.minestation13.item;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MINE_STATION_13_GROUP =
            Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(MineStation13.MOD_ID, "mine_station_13"),
                    FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                            .displayName(Text.translatable("itemgroup.mine_station_13"))
                            .entries(((displayContext, entries) -> {
                                entries.add(ModItems.PINK_GARNET);
                                entries.add(ModItems.RAW_PINK_GARNET);
                                entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                                entries.add(ModBlocks.PINK_GARNET_BLOCK);

                                entries.add(ModBlocks.PINK_GARNET_STAIRS);
                                entries.add(ModBlocks.PINK_GARNET_SLAB);

                                entries.add(ModBlocks.PINK_GARNET_FENCE);
                                entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                                entries.add(ModBlocks.PINK_GARNET_WALL);

                                entries.add(ModBlocks.PINK_GARNET_BUTTON);
                                entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

                                entries.add(ModBlocks.PINK_GARNET_DOOR);
                                entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

                                entries.add(ModBlocks.PINK_GARNET_LAMP);

                                entries.add(ModBlocks.MAGIC_BLOCK);
                                entries.add(ModBlocks.PINK_GARNET_ORE);
                                entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                                entries.add(ModItems.PINK_GARNET_SWORD);
                                entries.add(ModItems.PINK_GARNET_PICKAXE);
                                entries.add(ModItems.PINK_GARNET_SHOVEL);
                                entries.add(ModItems.PINK_GARNET_AXE);
                                entries.add(ModItems.PINK_GARNET_HOE);
                                entries.add(ModItems.PINK_GARNET_HAMMER);
                                entries.add(ModItems.CHISEL);
                                entries.add(ModItems.CAULIFLOWER);
                                entries.add(ModItems.STARLIGHT_ASHES);
                            })).build());

    public static void registerModItemGroups() {
        MineStation13.LOGGER.info("Registering Mod Item Groups for " + MineStation13.MOD_ID);

    }
}
