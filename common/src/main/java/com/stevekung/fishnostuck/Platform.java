package com.stevekung.fishnostuck;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Platform
{
    @ExpectPlatform
    public static boolean isDev()
    {
        throw new AssertionError();
    }
}