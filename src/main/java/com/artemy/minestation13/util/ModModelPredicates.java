package com.artemy.minestation13.util;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(MineStation13.MOD_ID,"used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.POSITION)!=null ? 1f : 0f);
    }
}
