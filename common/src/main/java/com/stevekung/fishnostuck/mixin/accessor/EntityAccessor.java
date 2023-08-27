package com.stevekung.fishnostuck.mixin.accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

/**
 * For multiple version support, 1.17.x-1.20.x
 */
@Mixin(Entity.class)
public interface EntityAccessor
{
    @Accessor("level")
    Level fishnostuck$level();
}