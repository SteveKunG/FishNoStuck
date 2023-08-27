package com.stevekung.fishnostuck.mixin;

import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

@Mixin(FollowFlockLeaderGoal.class)
public class MixinFollowFlockLeaderGoal
{
    /**
     * Before add follower to leader fish, make sure if it is not a leader fish.
     */
    @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = "java/util/stream/Stream.filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;", ordinal = 1, remap = false))
    private Predicate<AbstractSchoolingFish> fishnostuck$addHasFollowersCheck(Predicate<AbstractSchoolingFish> defaultValue)
    {
        return defaultValue.and(Predicate.not(AbstractSchoolingFish::hasFollowers));
    }
}