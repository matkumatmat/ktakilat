package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PreviewPixelHDRnetQuirk implements Quirk {
    private static final List<String> SUPPORTED_DEVICES = Arrays.asList(new String[]{"sunfish", "bramble", "redfin", "barbet"});

    public static boolean load() {
        if (!"Google".equals(Build.MANUFACTURER) || !SUPPORTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.getDefault()))) {
            return false;
        }
        return true;
    }
}
