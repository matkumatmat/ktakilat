package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ImageCaptureFailedForVideoSnapshotQuirk implements Quirk {
    private static final Set<String> PROBLEMATIC_UNI_SOC_MODELS = new HashSet(Arrays.asList(new String[]{"itel l6006", "itel w6004", "moto g(20)", "moto e13", "moto e20", "rmx3231", "rmx3511", "sm-a032f", "sm-a035m", "tecno mobile bf6"}));

    private static boolean isHuaweiPSmart() {
        if (!"HUAWEI".equalsIgnoreCase(Build.BRAND) || !"FIG-LX1".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isUniSocChipsetDevice() {
        Set<String> set = PROBLEMATIC_UNI_SOC_MODELS;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!set.contains(str.toLowerCase(locale)) && (Build.VERSION.SDK_INT < 31 || !"Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER))) {
            String str2 = Build.HARDWARE;
            if (str2.toLowerCase(locale).startsWith("ums") || ("itel".equalsIgnoreCase(Build.BRAND) && str2.toLowerCase(locale).startsWith("sp"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isUniSocChipsetDevice() || isHuaweiPSmart()) {
            return true;
        }
        return false;
    }
}
