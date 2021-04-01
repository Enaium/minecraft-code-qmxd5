package cn.enaium.learn.qmxd.client.module.render;

import cn.enaium.cf4m.annotation.module.Disable;
import cn.enaium.cf4m.annotation.module.Enable;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.module.Category;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

/**
 * Project: qmxd
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "FullBright", key = GLFW.GLFW_KEY_L, category = Category.RENDER)
public class FullBright {
    @Enable
    public void enable() {
        Minecraft.getInstance().gameSettings.gamma = 300;
    }

    @Disable
    public void disable() {
        Minecraft.getInstance().gameSettings.gamma = 1;
    }
}
