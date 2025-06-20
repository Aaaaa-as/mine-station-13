package com.artemy.minestation13.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,200),0.25f).build();
    public static final FoodComponent HONEY_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,2),0.25f).build();
}
