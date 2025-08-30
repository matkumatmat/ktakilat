package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class DeactivateEncoderSurfaceBeforeStopEncoderQuirk implements Quirk {
    public static boolean load() {
        if (Build.VERSION.SDK_INT <= 22) {
            return true;
        }
        return false;
    }
}
