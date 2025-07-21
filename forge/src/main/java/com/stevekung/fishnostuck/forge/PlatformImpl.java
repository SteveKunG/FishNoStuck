package com.stevekung.fishnostuck.forge;

import net.minecraftforge.fml.loading.FMLEnvironment;

public class PlatformImpl
{
    public static boolean isDev()
    {
        return !FMLEnvironment.production;
    }
}