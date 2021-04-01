package cn.enaium.learn.qmxd.client.event;

import cn.enaium.cf4m.event.Listener;

/**
 * Project: qmxd
 * Author: Enaium
 */
public class Events {
    public static class Render2DEvent extends Listener {

    }

    public static class UpdateEvent extends Listener {

    }

    public static class KeyboardEvent extends Listener {
        private final int key;

        public KeyboardEvent(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }
}
