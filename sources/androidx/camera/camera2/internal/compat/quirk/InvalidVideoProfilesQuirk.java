package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InvalidVideoProfilesQuirk implements Quirk {
    private static final List<String> AFFECTED_ONE_PLUS_MODELS = Arrays.asList(new String[]{"cph2417", "cph2451"});
    private static final List<String> AFFECTED_OPPO_MODELS = Arrays.asList(new String[]{"cph2437", "cph2525", "pht110"});
    private static final List<String> AFFECTED_PIXEL_MODELS = Arrays.asList(new String[]{"pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro"});

    private static boolean isAPI33() {
        if (Build.VERSION.SDK_INT == 33) {
            return true;
        }
        return false;
    }

    private static boolean isAffectedOnePlusDevices() {
        if (!isAffectedOnePlusModel() || !isAPI33()) {
            return false;
        }
        return true;
    }

    private static boolean isAffectedOnePlusModel() {
        return AFFECTED_ONE_PLUS_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedOppoDevices() {
        if (!isAffectedOppoModel() || !isAPI33()) {
            return false;
        }
        return true;
    }

    private static boolean isAffectedOppoModel() {
        return AFFECTED_OPPO_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedPixelBuild() {
        if (isTp1aBuild() || isTd1aBuild()) {
            return true;
        }
        return false;
    }

    private static boolean isAffectedPixelDevices() {
        if (!isAffectedPixelModel() || !isAffectedPixelBuild()) {
            return false;
        }
        return true;
    }

    private static boolean isAffectedPixelModel() {
        return AFFECTED_PIXEL_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedSamsungDevices() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND) || !isTp1aBuild()) {
            return false;
        }
        return true;
    }

    private static boolean isAffectedXiaomiDevices() {
        String str = Build.BRAND;
        if (("redmi".equalsIgnoreCase(str) || "xiaomi".equalsIgnoreCase(str)) && (isTkq1Build() || isTp1aBuild())) {
            return true;
        }
        return false;
    }

    private static boolean isTd1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean isTkq1Build() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tkq1");
    }

    private static boolean isTp1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    public static boolean load() {
        if (isAffectedSamsungDevices() || isAffectedPixelDevices() || isAffectedXiaomiDevices() || isAffectedOnePlusDevices() || isAffectedOppoDevices()) {
            return true;
        }
        return false;
    }
}
