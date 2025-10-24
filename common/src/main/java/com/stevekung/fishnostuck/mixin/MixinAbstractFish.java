package com.stevekung.fishnostuck.mixin;

import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
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
}