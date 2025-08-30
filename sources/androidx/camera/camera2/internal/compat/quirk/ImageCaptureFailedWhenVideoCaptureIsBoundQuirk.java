package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;

public class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, SurfaceProcessingQuirk {
    public static boolean isBluStudioX10() {
        if (!"blu".equalsIgnoreCase(Build.BRAND) || !"studio x10".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean isItelW6004() {
        if (!"itel".equalsIgnoreCase(Build.BRAND) || !"itel w6004".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean isMotoE13() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto e13".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isPixel4XLApi29() {
        if (!"pixel 4 xl".equalsIgnoreCase(Build.MODEL) || Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return true;
    }

    public static boolean isPositivoTwist2Pro() {
        if (!"positivo".equalsIgnoreCase(Build.BRAND) || !"twist 2 pro".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean isSamsungTabA8() {
        if ("samsung".equalsIgnoreCase(Build.BRAND)) {
            String str = Build.DEVICE;
            if ("gta8".equalsIgnoreCase(str) || "gta8wifi".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVivo1805() {
        if (!"vivo".equalsIgnoreCase(Build.BRAND) || !"vivo 1805".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isBluStudioX10() || isItelW6004() || isVivo1805() || isPositivoTwist2Pro() || isPixel4XLApi29() || isMotoE13() || isSamsungTabA8()) {
            return true;
        }
        return false;
    }

    public boolean workaroundByCaptureIntentPreview() {
        if (isBluStudioX10() || isItelW6004() || isVivo1805() || isPositivoTwist2Pro()) {
            return true;
        }
        return false;
    }

    public boolean workaroundBySurfaceProcessing() {
        if (isBluStudioX10() || isItelW6004() || isVivo1805() || isPositivoTwist2Pro() || isPixel4XLApi29() || isMotoE13() || isSamsungTabA8()) {
            return true;
        }
        return false;
    }
}
