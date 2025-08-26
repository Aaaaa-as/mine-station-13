package com.artemy.minestation13.block.entity;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, MineStation13.id("pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static void registerBlockEntities() {
        MineStation13.LOGGER.info("Registering Block Entities for " + MineStation13.MOD_ID);
    }
}
