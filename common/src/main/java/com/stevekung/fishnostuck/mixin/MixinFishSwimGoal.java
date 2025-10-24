package com.stevekung.fishnostuck.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.stevekung.fishnostuck.RandomStrollGoalAccessor;

@Mixin(targets = "net.minecraft.world.entity.animal.AbstractFish$FishSwimGoal")
public class MixinFishSwimGoal
{
    /**
     * Set {@code checkNoActionTime} to {@code false} to make fish not getting stuck at the current position
     */
    @Inject(method = "<init>*", at = @At("TAIL"))
    private void fishnostuck$setCheckNoActionTimeToFalse(CallbackInfo info)
    {
        ((RandomStrollGoalAccessor)this).fishnostuck$setCheckNoActionTime(false);
    }
}