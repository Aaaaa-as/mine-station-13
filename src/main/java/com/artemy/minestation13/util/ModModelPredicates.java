package com.artemy.minestation13.util;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(MineStation13.MOD_ID,"used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.POSITION)!=null ? 1f : 0f);
        registerCustomBow(ModItems.KAUPEN_BOW);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
