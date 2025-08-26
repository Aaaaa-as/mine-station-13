package com.artemy.minestation13.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PinkGarnetParticle extends SpriteBillboardParticle {


    protected PinkGarnetParticle(ClientWorld clientWorld, double x, double y, double z,
                                 SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
        this.velocityMultiplier = 0.8F;
        this.maxAge=40;
        this.setSpriteForAge(spriteProvider);
        this.red = this.green = this.blue = 1;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public record Factory(SpriteProvider spriteProvider) implements ParticleFactory<SimpleParticleType> {

        @Override
            public @NotNull Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
                return new PinkGarnetParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
            }
        }
}
