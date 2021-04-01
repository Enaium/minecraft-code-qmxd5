package cn.enaium.learn.qmxd.client.config;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.config.Config;
import cn.enaium.cf4m.annotation.config.Load;
import cn.enaium.cf4m.annotation.config.Save;
import cn.enaium.cf4m.provider.ModuleProvider;
import cn.enaium.cf4m.provider.SettingProvider;
import cn.enaium.learn.qmxd.client.setting.EnableSetting;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Config("Module")
public class ModuleConfig {
    @Load
    public void load() {
        try {
            JsonObject jsonObject = new Gson().fromJson(read(CF4M.config.getByInstance(this).getPath()), JsonObject.class);
            for (ModuleProvider moduleProvider : CF4M.module.getAll()) {
                if (jsonObject.has(moduleProvider.getName())) {
                    JsonObject moduleObject = jsonObject.get(moduleProvider.getName()).getAsJsonObject();
                    if (moduleObject.get("enable").getAsBoolean()) {
                        moduleProvider.enable();
                    }
                    moduleProvider.setKey(moduleObject.get("key").getAsInt());
                    if (!moduleProvider.getSetting().getAll().isEmpty()) {
                        JsonObject settingObject = moduleObject.get("setting").getAsJsonObject();
                        for (SettingProvider settingProvider : moduleProvider.getSetting().getAll()) {
                            if (settingObject.has(settingProvider.getName())) {
                                if (settingProvider.getSetting() instanceof EnableSetting) {
                                    settingProvider.<EnableSetting>getSetting().setEnable(settingObject.get(settingProvider.getName()).getAsBoolean());
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Save
    public void save() {
        JsonObject jsonObject = new JsonObject();
        for (ModuleProvider moduleProvider : CF4M.module.getAll()) {
            JsonObject moduleObject = new JsonObject();
            moduleObject.addProperty("enable", moduleProvider.getEnable());
            moduleObject.addProperty("key", moduleProvider.getKey());
            if (!moduleProvider.getSetting().getAll().isEmpty()) {
                JsonObject settingObject = new JsonObject();
                for (SettingProvider settingProvider : moduleProvider.getSetting().getAll()) {
                    if (settingProvider.getSetting() instanceof EnableSetting) {
                        settingObject.addProperty(settingProvider.getName(), settingProvider.<EnableSetting>getSetting().getEnable());
                    }
                }
                moduleObject.add("setting", settingObject);
            }
            jsonObject.add(moduleProvider.getName(), moduleObject);
        }
        try {
            write(CF4M.config.getByInstance(this).getPath(), jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read(String path) throws IOException {
        return FileUtils.readFileToString(new File(path), "UTF-8");
    }

    private void write(String path, String text) throws IOException {
        FileUtils.write(new File(path), text, "UTF-8");
    }
}
