package com.stevekung.fishnostuck.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.moulberry.mixinconstraints.annotations.IfDevEnvironment;
import com.stevekung.fishnostuck.mixin.accessor.AbstractSchoolingFishAccessor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.fish.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.fish.WaterAnimal;

@Mixin(AbstractSchoolingFish.class)
public class MixinAbstractSchoolingFish extends WaterAnimal
{
    @Shadow
    AbstractSchoolingFish leader;

    MixinAbstractSchoolingFish()
    {
        super(null, null);
    }

    /**
     * Decreased {@code schoolSize} from {@code leader} if this fish (follower) is getting killed.
     */
    @Override
    public void remove(Entity.RemovalReason reason)
    {
        //noinspection ConstantValue
        if (!this.level().isClientSide() && this.isDeadOrDying() && ((AbstractSchoolingFish) (Object) this).isFollower())
        {
            // Check leader is not null again because the leader might be inside an unloaded chunk
            if (this.leader != null)
            {
                ((AbstractSchoolingFishAccessor) this.leader).fishnostuck$removeFollower();
            }
        }
        super.remove(reason);
    }

    @IfDevEnvironment
    @Inject(method = "tick", at = @At("TAIL"))
    private void fishnostuck$debugTick(CallbackInfo info)
    {
        // SchoolingFishDebug.tick(AbstractSchoolingFish.class.cast(this));
    }
}