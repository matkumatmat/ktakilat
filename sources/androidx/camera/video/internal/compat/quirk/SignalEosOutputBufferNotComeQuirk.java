package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class SignalEosOutputBufferNotComeQuirk implements Quirk {
    private static boolean isNokia1() {
        if (!"Nokia".equalsIgnoreCase(Build.BRAND) || !"Nokia 1".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isNokia1();
    }
}
