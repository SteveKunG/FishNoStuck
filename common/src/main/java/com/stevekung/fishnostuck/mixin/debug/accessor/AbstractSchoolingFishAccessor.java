package com.stevekung.fishnostuck.mixin.debug.accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

@Mixin(value = AbstractSchoolingFish.class, remap = false)
public interface AbstractSchoolingFishAccessor
{
    @Accessor("schoolSize")
    int fishnostuck$getSchoolSize();

    @Accessor("leader")
    AbstractSchoolingFish fishnostuck$getLeader();
}