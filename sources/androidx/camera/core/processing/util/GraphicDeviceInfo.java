package androidx.camera.core.processing.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.processing.util.AutoValue_GraphicDeviceInfo;
import com.google.auto.value.AutoValue;

@AutoValue
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class GraphicDeviceInfo {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract GraphicDeviceInfo build();

        @NonNull
        public abstract Builder setEglExtensions(@NonNull String str);

        @NonNull
        public abstract Builder setEglVersion(@NonNull String str);

        @NonNull
        public abstract Builder setGlExtensions(@NonNull String str);

        @NonNull
        public abstract Builder setGlVersion(@NonNull String str);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_GraphicDeviceInfo.Builder().setGlVersion("0.0").setEglVersion("0.0").setGlExtensions("").setEglExtensions("");
    }

    @NonNull
    public abstract String getEglExtensions();

    @NonNull
    public abstract String getEglVersion();

    @NonNull
    public abstract String getGlExtensions();

    @NonNull
    public abstract String getGlVersion();
}
