package com.example.modid.mixin;

import com.example.modid.ExampleMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
    @Inject(method = "init()V", at = @At("HEAD"))
    private void exampleMod$init(CallbackInfo info) {
        ExampleMod.LOGGER.info("This line is logged by an example mod mixin!");
    }
}
