package com.stevekung.fishnostuck.neoforge;

import net.neoforged.fml.loading.FMLEnvironment;

public class PlatformImpl
{
    public static boolean isDev()
    {
        return !FMLEnvironment.production;
    }
}