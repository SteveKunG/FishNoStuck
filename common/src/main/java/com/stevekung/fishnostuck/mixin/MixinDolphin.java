package com.stevekung.fishnostuck.mixin;

import java.util.EnumSet;

import com.stevekung.fishnostuck.RandomStrollGoalAccessor;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.dolphin.Dolphin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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

    @Mixin(targets = "net.minecraft.world.entity.animal.dolphin.Dolphin$PlayWithItemsGoal")
    public abstract static class MixinPlayWithItemsGoal extends Goal
    {
        @Inject(method = "<init>(Lnet/minecraft/world/entity/animal/dolphin/Dolphin;)V", at = @At("TAIL"))
        private void fishnostuck$additionalFixMc306840(Dolphin dolphin, CallbackInfo info)
        {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }
    }
}