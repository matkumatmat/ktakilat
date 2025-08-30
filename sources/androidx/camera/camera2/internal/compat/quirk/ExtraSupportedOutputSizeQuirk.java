package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;

public class ExtraSupportedOutputSizeQuirk implements Quirk {
    @NonNull
    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }

    private static boolean isMotoE5Play() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto e5 play".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    @NonNull
    public Size[] getExtraSupportedResolutions(int i) {
        if (i != 34 || !isMotoE5Play()) {
            return new Size[0];
        }
        return getMotoE5PlayExtraSupportedResolutions();
    }

    @NonNull
    public <T> Size[] getExtraSupportedResolutions(@NonNull Class<T> cls) {
        if (!StreamConfigurationMap.isOutputSupportedFor(cls) || !isMotoE5Play()) {
            return new Size[0];
        }
        return getMotoE5PlayExtraSupportedResolutions();
    }
}
