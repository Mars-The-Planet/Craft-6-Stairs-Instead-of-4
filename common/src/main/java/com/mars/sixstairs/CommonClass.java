package com.mars.sixstairs;

import com.google.common.collect.Lists;
import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import com.mars.sixstairs.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import static com.mars.sixstairs.Constants.MOD_ID;

public class CommonClass {
    public static void init() {
        DeimosConfig.init(MOD_ID, SixStairsConfig.class);

        for (int i = 0; i < SixStairsConfig.blockStairsList.size(); i++) {
            String current = SixStairsConfig.blockStairsList.get(i);
            String[] set = ((current).replaceAll("\\s","")).split(",");

            DeimosRecipeGenerator.createShapedRecipeJson(
                    Lists.newArrayList(
                            '#'
                    ),
                    Lists.newArrayList(ResourceLocation.parse(set[0])),
                    Lists.newArrayList("item"),
                    Lists.newArrayList(
                            "#  ",
                            "## ",
                            "###"
                    ),
                    ResourceLocation.parse(set[1]), SixStairsConfig.stairAmount);
        }
    }
}
