package com.stevekung.fishnostuck.mixin;

import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.stevekung.fishnostuck.RandomStrollGoalAccessor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.animal.AbstractFish;

@Mixin(AbstractFish.class)
public class MixinAbstractFish
{
    /**
     * Change from {@code EntitySelector.NO_SPECTATORS} to {@code EntitySelector.NO_CREATIVE_OR_SPECTATOR} to make fish only avoid survival players
     */
    @Redirect(method = "registerGoals", at = @At(value = "FIELD", target = "net/minecraft/world/entity/EntitySelector.NO_SPECTATORS:Ljava/util/function/Predicate;"))
    private Predicate<Entity> fishnostuck$changeToNoCreativeAndSpectator()
    {
        return EntitySelector.NO_CREATIVE_OR_SPECTATOR;
    }

    @Mixin(targets = "net.minecraft.world.entity.animal.AbstractFish$FishSwimGoal")
    static class MixinFishSwimGoal
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
}