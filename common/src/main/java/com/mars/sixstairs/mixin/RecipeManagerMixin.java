package com.mars.sixstairs.mixin;

import com.google.gson.JsonElement;
import com.mars.sixstairs.SixStairsConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Objects;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"))
    public void apply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci){
        for (int i = 0; i < SixStairsConfig.blockStairsList.size(); i++) {
            String current = SixStairsConfig.blockStairsList.get(i);
            String[] set = ((current).replaceAll("\\s","")).split(",");
            for(ResourceLocation resourceLocation : object.keySet()){
                if(Objects.equals(resourceLocation, new ResourceLocation(set[1]))){
                    object.remove(resourceLocation);
                    break;
                }
            }
        }
    }
}
