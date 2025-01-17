package com.mars.sixstairs;

import com.google.common.collect.Lists;
import com.mars.deimos.config.DeimosConfig;

import java.util.List;

public class SixStairsConfig extends DeimosConfig {
    @Entry public static int stairAmount = 6;
    @Entry public static List<String> blockStairsList = Lists.newArrayList(
            "minecraft:acacia_planks, minecraft:acacia_stairs",
            "minecraft:andesite, minecraft:andesite_stairs");
}
