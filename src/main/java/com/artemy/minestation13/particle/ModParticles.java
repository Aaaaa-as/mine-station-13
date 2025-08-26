package com.artemy.minestation13.particle;

import com.artemy.minestation13.MineStation13;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticles {
    public static final SimpleParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, MineStation13.id(name), particleType);
    }

    public static void registerParticles() {
        MineStation13.LOGGER.info("Registering Particles for " + MineStation13.MOD_ID);
    }
}
