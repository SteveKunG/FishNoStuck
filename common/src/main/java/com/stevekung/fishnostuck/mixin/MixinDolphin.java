package com.stevekung.fishnostuck.mixin;

import com.stevekung.fishnostuck.RandomStrollGoalAccessor;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.dolphin.Dolphin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Dolphin.class)
public class MixinDolphin
{
    @ModifyArg(method = "registerGoals", at = @At(
            value = "INVOKE",
            target = "net/minecraft/world/entity/ai/goal/GoalSelector.addGoal(ILnet/minecraft/world/entity/ai/goal/Goal;)V",
            ordinal = 0
    ),
            slice = @Slice(
                    from = @At(
                            value = "NEW",
                            target = "net/minecraft/world/entity/ai/goal/RandomSwimmingGoal")),
            index = 1)
    private Goal fishnostuck$fixDolphinNoActionTime(Goal goal)
    {
        if (goal instanceof RandomStrollGoalAccessor accessor)
        {
            accessor.fishnostuck$setCheckNoActionTime(false);
        }
        return goal;
    }
}