package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CameraMode {
    public static final int CONCURRENT_CAMERA = 1;
    public static final int DEFAULT = 0;
    public static final int ULTRA_HIGH_RESOLUTION_CAMERA = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private CameraMode() {
    }

    @NonNull
    public static String toLabelString(int i) {
        if (i == 1) {
            return "CONCURRENT_CAMERA";
        }
        if (i != 2) {
            return MessengerShareContentUtility.PREVIEW_DEFAULT;
        }
        return "ULTRA_HIGH_RESOLUTION_CAMERA";
    }
}
