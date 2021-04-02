package cn.enaium.learn.qmxd.client;

import cn.enaium.cf4m.annotation.Configuration;
import cn.enaium.cf4m.configuration.ICommandConfiguration;
import cn.enaium.cf4m.configuration.IConfiguration;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Configuration
public class ClientConfig implements IConfiguration {
    @Override
    public ICommandConfiguration command() {
        return new ICommandConfiguration() {
            @Override
            public void message(String message) {
                Minecraft.getInstance().ingameGUI.getChatGUI().printChatMessage(new StringTextComponent(message));
            }
        };
    }
}
