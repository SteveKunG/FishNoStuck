package com.stevekung.fishnostuck.mixin.accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.entity.animal.AbstractSchoolingFish;

@Mixin(AbstractSchoolingFish.class)
public interface AbstractSchoolingFishAccessor
{
    @Invoker("removeFollower")
    void fishnostuck$removeFollower();

    @Accessor("schoolSize")
    int fishnostuck$getSchoolSize();

    @Accessor("leader")
    AbstractSchoolingFish fishnostuck$getLeader();
}