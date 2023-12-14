package com.stevekung.fishnostuck.debug;

import com.stevekung.fishnostuck.mixin.debug.accessor.AbstractSchoolingFishAccessor;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

public class SchoolingFishDebug
{
    public static final boolean ENABLE = true;

    public static void tick(AbstractSchoolingFish fish)
    {
        if (!ENABLE)
        {
            return;
        }

        if (!fish.level.isClientSide())
        {
            var text = "";

            if (fish.hasFollowers())
            {
                text += "leader: " + color(fish.hasFollowers()) + " ";
                text += ChatFormatting.RESET;
            }
            if (fish.isFollower())
            {
                text += "follower: " + color(fish.isFollower()) + " ";
                text += ChatFormatting.RESET;
            }

            text += "schoolSize: " + ChatFormatting.GOLD + ((AbstractSchoolingFishAccessor) fish).fishnostuck$getSchoolSize() + " ";
            text += ChatFormatting.RESET;
            text += "uuid: " + fish.getUUID().toString().split("-")[0];

            if (((AbstractSchoolingFishAccessor) fish).fishnostuck$getLeader() != null)
            {
                text += " leader: " + ChatFormatting.GOLD + ((AbstractSchoolingFishAccessor) fish).fishnostuck$getLeader().getUUID().toString().split("-")[0];
                text += ChatFormatting.RESET;
            }

            fish.setCustomNameVisible(true);
            fish.setCustomName(new TextComponent(text));
        }
    }

    private static String color(boolean isTrue)
    {
        var color = isTrue ? ChatFormatting.GREEN : ChatFormatting.RED;
        return color.toString() + isTrue;
    }
}