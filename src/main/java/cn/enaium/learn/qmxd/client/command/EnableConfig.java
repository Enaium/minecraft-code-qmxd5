package cn.enaium.learn.qmxd.client.command;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.command.Command;
import cn.enaium.cf4m.annotation.command.Exec;
import cn.enaium.cf4m.annotation.command.Param;
import cn.enaium.cf4m.provider.ModuleProvider;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Command({"enable", "e"})
public class EnableConfig {
    @Exec
    public void exec() {
        for (ModuleProvider moduleProvider : CF4M.module.getAll()) {
            CF4M.configuration.command().message(moduleProvider.getName());
        }
    }

    @Exec
    public void exec(@Param("Module") String name) {
        ModuleProvider moduleProvider = CF4M.module.getByName(name);
        if (moduleProvider != null) {
            moduleProvider.enable();
            CF4M.configuration.command().message(moduleProvider.getName() + (moduleProvider.getEnable() ? " Enable" : " Disable"));
        }
    }
}
