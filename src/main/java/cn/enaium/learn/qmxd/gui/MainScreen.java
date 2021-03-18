package cn.enaium.learn.qmxd.gui;

import cn.enaium.learn.qmxd.client.QMXD;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.MultiplayerWarningScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.WorldSelectionScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.lwjgl.opengl.GL11;

/**
 * Project: qmxd
 * Author: Enaium
 */
public class MainScreen extends Screen {
    public MainScreen() {
        super(new StringTextComponent(""));
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 100, height / 2, 200, 20, I18n.format("menu.singleplayer", new Object[0]), (p_213089_1_) -> {
            this.minecraft.displayGuiScreen(new WorldSelectionScreen(this));
        }));
        this.addButton(new Button(this.width / 2 - 100, height / 2 + 40, 200, 20, I18n.format("menu.multiplayer", new Object[0]), (p_213086_1_) -> {
            if (this.minecraft.gameSettings.field_230152_Z_) {
                this.minecraft.displayGuiScreen(new MultiplayerScreen(this));
            } else {
                this.minecraft.displayGuiScreen(new MultiplayerWarningScreen(this));
            }

        }));
        super.init();
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        renderBackground();
        drawString(Minecraft.getInstance().fontRenderer, QMXD.INSTANCE.NAME, 0, 0, 0xFFFFFF);
        super.render(p_render_1_, p_render_2_, p_render_3_);
    }
}
