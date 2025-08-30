package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk implements Quirk {
    public static boolean load() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return true;
    }
}
