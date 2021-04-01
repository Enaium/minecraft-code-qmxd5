package cn.enaium.learn.qmxd.mixins;

import cn.enaium.learn.qmxd.client.event.Events;
import net.minecraft.client.gui.IngameGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: qmxd
 * Author: Enaium
 */
@Mixin(IngameGui.class)
public class IngameGuiMixin {
    @Inject(at = @At("HEAD"), method = "renderGameOverlay")
    private void run(float p_renderGameOverlay_1_, CallbackInfo callbackInfo) {
        new Events.Render2DEvent().call();
    }
}
