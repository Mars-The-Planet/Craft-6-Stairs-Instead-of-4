package com.mars.sixstairs;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SixStairs {

    public SixStairs(IEventBus eventBus) {
        CommonClass.init();
    }
}
