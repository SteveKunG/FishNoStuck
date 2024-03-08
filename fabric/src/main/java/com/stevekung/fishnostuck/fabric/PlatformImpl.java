package com.stevekung.fishnostuck.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class PlatformImpl
{
    public static boolean isDev()
    {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}