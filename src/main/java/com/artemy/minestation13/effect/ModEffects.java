package com.artemy.minestation13.effect;

import com.artemy.minestation13.MineStation13;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModEffects {
    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL,0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(MineStation13.MOD_ID,"slimey"),-0.25,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    @SuppressWarnings("SameParameterValue")
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, MineStation13.id(name), effect);
    }

    public static void registerModEffects() {
        MineStation13.LOGGER.debug("Registering Mod Effects for " + MineStation13.MOD_ID);
    }
}
