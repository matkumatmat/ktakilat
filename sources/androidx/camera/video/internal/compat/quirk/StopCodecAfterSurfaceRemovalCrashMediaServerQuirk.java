package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class StopCodecAfterSurfaceRemovalCrashMediaServerQuirk implements Quirk {
    private static boolean isMotoC() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto c".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }
}
