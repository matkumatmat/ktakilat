package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;
import androidx.camera.extensions.internal.compat.quirk.ExtensionDisabledQuirk;

public class ExtensionDisabledValidator {
    private final ExtensionDisabledQuirk mQuirk = ((ExtensionDisabledQuirk) DeviceQuirks.get(ExtensionDisabledQuirk.class));

    public boolean shouldDisableExtension() {
        ExtensionDisabledQuirk extensionDisabledQuirk = this.mQuirk;
        if (extensionDisabledQuirk == null || !extensionDisabledQuirk.shouldDisableExtension()) {
            return false;
        }
        return true;
    }
}
