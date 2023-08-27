package com.stevekung.fishnostuck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishNoStuck
{
    private static final Logger LOGGER = LoggerFactory.getLogger("FishNoStuck");

    public static void init()
    {
        LOGGER.info("FishNoStuck loaded, Free all the fish!");
    }
}