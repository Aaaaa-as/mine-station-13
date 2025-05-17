package com.artemy.minestation13.enchantment;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.enchantment.custom.LightningStrikerEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

@SuppressWarnings("unused")
public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER = registerEntityEffect("lightning_striker",
            LightningStrikerEnchantmentEffect.CODEC);

    @SuppressWarnings("SameParameterValue")
    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MineStation13.id(name), codec);
    }


    public static void registerEnchantmentEffects() {
        MineStation13.LOGGER.info("Registering Mod Enchantment Effects for " + MineStation13.MOD_ID);
    }
}
