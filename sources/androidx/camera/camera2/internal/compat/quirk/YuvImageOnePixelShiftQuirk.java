package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;

public final class YuvImageOnePixelShiftQuirk implements OnePixelShiftQuirk {
    private static boolean isMotorolaMotoG3() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"MotoG3".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungSMA920F() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !"SM-A920F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungSMG532F() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !"SM-G532F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungSMJ415F() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J415F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungSMJ700F() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J700F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isXiaomiMiA1() {
        if (!"xiaomi".equalsIgnoreCase(Build.BRAND) || !"Mi A1".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (isMotorolaMotoG3() || isSamsungSMG532F() || isSamsungSMJ700F() || isSamsungSMA920F() || isSamsungSMJ415F() || isXiaomiMiA1()) {
            return true;
        }
        return false;
    }
}
