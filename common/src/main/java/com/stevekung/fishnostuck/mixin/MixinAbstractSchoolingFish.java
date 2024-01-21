package com.stevekung.fishnostuck.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.stevekung.fishnostuck.mixin.accessor.AbstractSchoolingFishAccessor;
import com.stevekung.fishnostuck.mixin.accessor.EntityAccessor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.WaterAnimal;

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
        if (!((EntityAccessor)this).fishnostuck$level().isClientSide() && this.isDeadOrDying() && ((AbstractSchoolingFish)(Object)this).isFollower())
        {
            // Check leader is not null again because the leader might be inside an unloaded chunk
            if (this.leader != null)
            {
                ((AbstractSchoolingFishAccessor) this.leader).fishnostuck$removeFollower();
            }
        }
        super.remove(reason);
    }
}