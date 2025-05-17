package com.artemy.minestation13.mixin;

import com.artemy.minestation13.item.ModItems;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// With help from https://github.com/Globox1997/MedievalWeapons/blob/1.21/src/main/java/net/medievalweapons/mixin/client/AbstractClientPlayerEntityMixin.java
// Under MIT License!
@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {
    public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "getFovMultiplier", at = @At("TAIL"), cancellable = true)
    private void getFovMultiplierMixin(boolean firstPerson, float fovEffectScale, CallbackInfoReturnable<Float> cir) {
        ItemStack itemStack = this.getActiveItem();
        if (this.isUsingItem() && itemStack.isOf(ModItems.KAUPEN_BOW)) {
            int useTime = this.getItemUseTime();
            float g = useTime / 20.0f;
            g = g > 1.0f ? 1.0f : g * g;
            float modifiedFov = 1.0f - g * 0.15f;
            float finalFov = MathHelper.lerp(fovEffectScale, 1.0f, modifiedFov);
            cir.setReturnValue(finalFov);
        }
    }
}