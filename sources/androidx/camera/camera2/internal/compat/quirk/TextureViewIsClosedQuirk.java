package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class TextureViewIsClosedQuirk implements Quirk {
    public static boolean load() {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return false;
    }
}
