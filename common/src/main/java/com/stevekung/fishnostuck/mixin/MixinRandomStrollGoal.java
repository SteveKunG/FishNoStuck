package com.stevekung.fishnostuck.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import com.stevekung.fishnostuck.RandomStrollGoalAccessor;

import net.minecraft.world.entity.ai.goal.RandomStrollGoal;

@Mixin(RandomStrollGoal.class)
public class MixinRandomStrollGoal implements RandomStrollGoalAccessor
{
    @Shadow
    @Final
    @Mutable
    boolean checkNoActionTime;

    @Override
    public void fishnostuck$setCheckNoActionTime(boolean checkNoActionTime)
    {
        this.checkNoActionTime = checkNoActionTime;
    }
}