package cn.enaium.learn.qmxd.client.modules.render;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.Setting;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.module.Category;
import cn.enaium.learn.qmxd.client.QMXD;
import cn.enaium.learn.qmxd.client.events.Render2DEvent;
import cn.enaium.learn.qmxd.client.settings.EnableSetting;
import cn.enaium.learn.qmxd.mixins.IMinecraft;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Module(value = "HUD", key = GLFW.GLFW_KEY_O, category = Category.RENDER)
public class HUD {

    @Setting("Logo")
    private final EnableSetting logo = new EnableSetting(true);

    @Setting("List")
    private final EnableSetting list = new EnableSetting(true);

    @Event
    public void onRender(Render2DEvent event) {
        if (!logo.getEnable())
            return;
        GL11.glScaled(2.0, 2.0, 2.0);
        int i = Minecraft.getInstance().fontRenderer.drawStringWithShadow(QMXD.INSTANCE.NAME, 0, 0, 0xFFFFFF);
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getInstance().fontRenderer.drawStringWithShadow("Version:" + QMXD.INSTANCE.VERSION, i * 2, 0, 0xFFFFFF);
    }

    @Event
    public void list(Render2DEvent event) {
        if (!list.getEnable())
            return;

        ArrayList<Object> mods = CF4M.INSTANCE.module.getModules();
        MainWindow mainWindow = ((IMinecraft) Minecraft.getInstance()).getMainWindow();
        int index = 0;
        for (Object mod : mods) {
            if (!CF4M.INSTANCE.module.getEnable(mod))
                continue;
            String name = CF4M.INSTANCE.module.getName(mod);
            Minecraft.getInstance().fontRenderer.drawStringWithShadow(name, mainWindow.getScaledWidth() - Minecraft.getInstance().fontRenderer.getStringWidth(name), index, 0xFFFFFF);
            index += Minecraft.getInstance().fontRenderer.FONT_HEIGHT;
        }
    }
}
