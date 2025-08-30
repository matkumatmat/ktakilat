package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class RepeatingStreamConstraintForVideoRecordingQuirk implements Quirk {
    public static boolean isHuaweiMate9() {
        if (!"Huawei".equalsIgnoreCase(Build.BRAND) || !"mha-l29".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isHuaweiMate9();
    }
}
