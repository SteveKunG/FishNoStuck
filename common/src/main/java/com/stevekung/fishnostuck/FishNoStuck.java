package com.stevekung.fishnostuck;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

public class FishNoStuck
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init()
    {
        LOGGER.info("FishNoStuck loaded, Free all the fish!");
    }
}