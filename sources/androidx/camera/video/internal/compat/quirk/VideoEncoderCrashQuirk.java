package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

public class VideoEncoderCrashQuirk implements VideoQualityQuirk {
    private static boolean isPositivoTwist2Pro() {
        if (!"positivo".equalsIgnoreCase(Build.BRAND) || !"twist 2 pro".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isPositivoTwist2Pro();
    }

    public boolean isProblematicVideoQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality) {
        if (isPositivoTwist2Pro() && cameraInfoInternal.getLensFacing() == 0 && quality == Quality.SD) {
            return true;
        }
        return false;
    }
}
