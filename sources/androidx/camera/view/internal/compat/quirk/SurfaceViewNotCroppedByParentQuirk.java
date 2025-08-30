package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    private static final String RED_MI_NOTE_10_MODEL = "M2101K7AG";
    private static final String XIAOMI = "XIAOMI";

    public static boolean load() {
        if (!XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) || !RED_MI_NOTE_10_MODEL.equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }
}
