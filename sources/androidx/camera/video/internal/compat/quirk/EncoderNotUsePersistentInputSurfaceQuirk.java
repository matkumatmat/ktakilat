package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class EncoderNotUsePersistentInputSurfaceQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = Arrays.asList(new String[]{"SM-N9208", "SM-G920V"});

    public static boolean load() {
        if (Build.VERSION.SDK_INT <= 22 || DEVICE_MODELS.contains(Build.MODEL.toUpperCase())) {
            return true;
        }
        return false;
    }
}
