package com.stevekung.fishnostuck;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FishNoStuck
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static void init()
    {
        LOGGER.info("FishNoStuck loaded, Free all the fish!");
    }
}