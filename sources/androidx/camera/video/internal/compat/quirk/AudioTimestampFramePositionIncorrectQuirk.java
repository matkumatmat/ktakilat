package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AudioTimestampFramePositionIncorrectQuirk implements Quirk {
    private static final List<String> AFFECTED_OPPO_MODELS = Arrays.asList(new String[]{"cph1920", "cph1923", "cph2015", "cph2083"});

    private static boolean isAffectedOppoDevices() {
        if (!"oppo".equalsIgnoreCase(Build.BRAND) || !AFFECTED_OPPO_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT))) {
            return false;
        }
        return true;
    }

    private static boolean isLgK10() {
        if (!"lge".equalsIgnoreCase(Build.BRAND) || !"lg-m250".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isMotoC() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto c".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isRealmeC2() {
        if (!"realme".equalsIgnoreCase(Build.BRAND) || !"rmx1941".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isRedmi6A() {
        if (!"Xiaomi".equalsIgnoreCase(Build.BRAND) || !"Redmi 6A".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isVivo1820() {
        if (!"vivo".equalsIgnoreCase(Build.BRAND) || !"vivo 1820".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isVivoY17() {
        if (!"vivo".equalsIgnoreCase(Build.BRAND) || !"VIVO Y17".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isAffectedOppoDevices() || isLgK10() || isMotoC() || isRealmeC2() || isRedmi6A() || isVivo1820() || isVivoY17()) {
            return true;
        }
        return false;
    }
}
