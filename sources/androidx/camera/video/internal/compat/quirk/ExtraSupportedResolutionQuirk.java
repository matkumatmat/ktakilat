package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;

public class ExtraSupportedResolutionQuirk implements SurfaceProcessingQuirk {
    private static boolean isMotoE5Play() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto e5 play".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    public final /* synthetic */ boolean workaroundBySurfaceProcessing() {
        return qf.a(this);
    }
}
