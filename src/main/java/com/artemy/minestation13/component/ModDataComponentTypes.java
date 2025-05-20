package com.artemy.minestation13.component;

import com.artemy.minestation13.MineStation13;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> POSITION = register("position", builder -> builder.codec(BlockPos.CODEC));


    private static <T>ComponentType<T> register (@SuppressWarnings("SameParameterValue") String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, MineStation13.id(name), builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        MineStation13.LOGGER.info("Registering Data Component Types for " + MineStation13.MOD_ID);
    }
}
