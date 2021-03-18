package cn.enaium.learn.qmxd.mixins;

import cn.enaium.learn.qmxd.client.QMXD;
import cn.enaium.learn.qmxd.gui.MainScreen;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

/**
 * Project: FoxBase
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("HEAD"), method = "run")
    private void run(CallbackInfo callbackInfo) {
        QMXD.INSTANCE.run();
    }

    @Shadow
    @Final
    private MainWindow mainWindow;

    @Shadow
    @Nullable
    public Screen currentScreen;

    @Inject(at = @At("RETURN"), method = "func_230150_b_")
    private void setTitle(CallbackInfo callbackInfo) {
        this.mainWindow.func_230148_b_(QMXD.INSTANCE.NAME + "|" + QMXD.INSTANCE.VERSION);
    }

    @Inject(at = @At("RETURN"), method = "displayGuiScreen")
    private void displayGuiScreen(Screen p_displayGuiScreen_1_, CallbackInfo callbackInfo) {
        if (p_displayGuiScreen_1_ instanceof MainMenuScreen) {
            currentScreen = new MainScreen();
        }
    }
}
