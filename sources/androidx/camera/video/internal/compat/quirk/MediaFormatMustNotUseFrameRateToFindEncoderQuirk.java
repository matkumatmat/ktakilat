package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class MediaFormatMustNotUseFrameRateToFindEncoderQuirk implements Quirk {
    public static boolean load() {
        if (Build.VERSION.SDK_INT == 21) {
            return true;
        }
        return false;
    }
}
