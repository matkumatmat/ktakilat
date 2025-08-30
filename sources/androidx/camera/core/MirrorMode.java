package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MirrorMode {
    public static final int MIRROR_MODE_OFF = 0;
    public static final int MIRROR_MODE_ON = 1;
    public static final int MIRROR_MODE_ON_FRONT_ONLY = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int MIRROR_MODE_UNSPECIFIED = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mirror {
    }

    private MirrorMode() {
    }
}
