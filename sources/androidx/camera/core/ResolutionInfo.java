package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal;
import com.google.auto.value.AutoValue;

public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    @AutoValue
    public static abstract class ResolutionInfoInternal {

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract ResolutionInfoInternal build();

            @NonNull
            public abstract Builder setCropRect(@NonNull Rect rect);

            @NonNull
            public abstract Builder setResolution(@NonNull Size size);

            @NonNull
            public abstract Builder setRotationDegrees(int i);
        }

        @NonNull
        public abstract Rect getCropRect();

        @NonNull
        public abstract Size getResolution();

        public abstract int getRotationDegrees();
    }

    public ResolutionInfo(@NonNull Size size, @NonNull Rect rect, int i) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(size).setCropRect(rect).setRotationDegrees(i).build();
    }

    public boolean equals(@Nullable Object obj) {
        return this.mResolutionInfoInternal.equals(obj);
    }

    @NonNull
    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    @NonNull
    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }
}
