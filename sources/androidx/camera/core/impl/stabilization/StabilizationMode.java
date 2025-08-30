package androidx.camera.core.impl.stabilization;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StabilizationMode {
    public static final int OFF = 1;
    public static final int ON = 2;
    public static final int UNSPECIFIED = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private StabilizationMode() {
    }
}
