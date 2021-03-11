package cn.enaium.learn.qmxd.client;

import cn.enaium.cf4m.CF4M;

/**
 * Project: qmxd
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public enum QMXD {

    INSTANCE;

    public String NAME = "QMXD";
    public String VERSION = "5";

    public void run() {
        CF4M.INSTANCE.run(this);
    }
}