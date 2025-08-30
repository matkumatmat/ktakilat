package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

public class ExcludeStretchedVideoQualityQuirk implements VideoQualityQuirk {
    private static boolean isSamsungJ2() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J260F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ4() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J400G".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ5() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J530F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ6() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"sm-j600g".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ7Api27Above() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J710MN".equalsIgnoreCase(Build.MODEL) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ7Nxt() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-J701F".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !"SM-G610M".equalsIgnoreCase(Build.MODEL) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isSamsungJ2() || isSamsungJ4() || isSamsungJ5() || isSamsungJ6() || isSamsungJ7Nxt() || isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above()) {
            return true;
        }
        return false;
    }

    public boolean isProblematicVideoQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality) {
        if (isSamsungJ4()) {
            if (quality == Quality.FHD || quality == Quality.UHD) {
                return true;
            }
            return false;
        } else if ((isSamsungJ2() || isSamsungJ5() || isSamsungJ6() || isSamsungJ7Nxt() || isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above()) && quality == Quality.FHD) {
            return true;
        } else {
            return false;
        }
    }
}
