package com.artemy.minestation13.entity;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.entity.custom.MantisEntity;
import com.artemy.minestation13.entity.custom.TomahawkProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {

    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            MineStation13.id("mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,
            MineStation13.id("tomahawk"),
            EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(.5f, 1.15f).build());

    public static void registerModEntities() {
        MineStation13.LOGGER.info("Registering Mod Entities for " + MineStation13.MOD_ID);
    }

}
