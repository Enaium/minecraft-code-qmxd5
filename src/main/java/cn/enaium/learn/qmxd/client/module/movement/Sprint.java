package cn.enaium.learn.qmxd.client.module.movement;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.module.Category;
import cn.enaium.learn.qmxd.client.event.Events;
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
    public void onUpdate(Events.UpdateEvent event) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setSprinting(true);
    }
}
