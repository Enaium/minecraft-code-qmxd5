package cn.enaium.learn.qmxd.client.modules.movement;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.event.events.UpdateEvent;
import cn.enaium.cf4m.module.Category;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

/**
 * Project: qmxd
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "Sprint", key = GLFW.GLFW_KEY_V, category = Category.MOVEMENT)
public class Sprint {
    @Event
    public void onUpdate(UpdateEvent event) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setSprinting(true);
    }
}
