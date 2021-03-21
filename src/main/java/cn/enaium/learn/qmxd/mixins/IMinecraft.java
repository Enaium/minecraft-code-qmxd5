package cn.enaium.learn.qmxd.mixins;

import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Mixin(Minecraft.class)
public interface IMinecraft {
    @Accessor("mainWindow")
    MainWindow getMainWindow();
}
