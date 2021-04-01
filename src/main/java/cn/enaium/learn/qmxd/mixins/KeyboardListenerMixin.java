package cn.enaium.learn.qmxd.mixins;

import cn.enaium.cf4m.CF4M;
import cn.enaium.learn.qmxd.client.event.Events;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: qmxd
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Mixin(KeyboardListener.class)
public class KeyboardListenerMixin {
    @Inject(at = @At("HEAD"), method = "onKeyEvent")
    private void onKeyEvent(long window, int key, int p_onKeyEvent_4_, int action, int p_onKeyEvent_6_, CallbackInfo callbackInfo) {
        if (Minecraft.getInstance().currentScreen == null && action == GLFW.GLFW_PRESS) {
            CF4M.module.onKey(key);
            new Events.KeyboardEvent(key).call();
        }
    }
}
