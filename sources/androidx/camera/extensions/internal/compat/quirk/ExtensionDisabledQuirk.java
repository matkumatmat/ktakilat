package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;

public class ExtensionDisabledQuirk implements Quirk {
    private static boolean isAdvancedExtenderSupported() {
        if (!ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_2) || !ExtensionVersion.isAdvancedExtenderSupported()) {
            return false;
        }
        return true;
    }

    private static boolean isMoto() {
        return "motorola".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean isPixel5() {
        if (!"google".equalsIgnoreCase(Build.BRAND) || !"redfin".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean isRealme() {
        return "realme".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean load() {
        if (isPixel5() || isMoto() || isRealme()) {
            return true;
        }
        return false;
    }

    public boolean shouldDisableExtension() {
        if (isPixel5() && !isAdvancedExtenderSupported()) {
            return true;
        }
        if (isMoto() && ExtensionVersion.isMaximumCompatibleVersion(Version.VERSION_1_1)) {
            return true;
        }
        if (!isRealme() || !ExtensionVersion.isMaximumCompatibleVersion(Version.VERSION_1_1)) {
            return false;
        }
        return true;
    }
}
