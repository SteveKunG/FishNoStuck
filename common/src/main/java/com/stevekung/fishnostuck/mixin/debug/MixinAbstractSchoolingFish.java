package com.stevekung.fishnostuck.mixin.debug;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.stevekung.fishnostuck.debug.SchoolingFishDebug;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

@Mixin(value = AbstractSchoolingFish.class, remap = false)
public class MixinAbstractSchoolingFish
{
    @Inject(method = "tick", at = @At("TAIL"))
    private void fishnostuck$debugTick(CallbackInfo info)
    {
        SchoolingFishDebug.tick(AbstractSchoolingFish.class.cast(this));
    }
}