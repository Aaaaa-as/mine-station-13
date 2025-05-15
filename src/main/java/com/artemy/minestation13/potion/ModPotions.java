package com.artemy.minestation13.potion;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions{
    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY,1200,0)));

    @SuppressWarnings("SameParameterValue")
    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(MineStation13.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        MineStation13.LOGGER.info("Registering Mod Potions for " + MineStation13.MOD_ID);
    }
}
