package androidx.camera.core.resolutionselector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ResolutionSelector {
    public static final int PREFER_CAPTURE_RATE_OVER_HIGHER_RESOLUTION = 0;
    public static final int PREFER_HIGHER_RESOLUTION_OVER_CAPTURE_RATE = 1;
    private final int mAllowedResolutionMode;
    @NonNull
    private final AspectRatioStrategy mAspectRatioStrategy;
    @Nullable
    private final ResolutionFilter mResolutionFilter;
    @Nullable
    private final ResolutionStrategy mResolutionStrategy;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AllowedResolutionMode {
    }

    public ResolutionSelector(@NonNull AspectRatioStrategy aspectRatioStrategy, @Nullable ResolutionStrategy resolutionStrategy, @Nullable ResolutionFilter resolutionFilter, int i) {
        this.mAspectRatioStrategy = aspectRatioStrategy;
        this.mResolutionStrategy = resolutionStrategy;
        this.mResolutionFilter = resolutionFilter;
        this.mAllowedResolutionMode = i;
    }

    public int getAllowedResolutionMode() {
        return this.mAllowedResolutionMode;
    }

    @NonNull
    public AspectRatioStrategy getAspectRatioStrategy() {
        return this.mAspectRatioStrategy;
    }

    @Nullable
    public ResolutionFilter getResolutionFilter() {
        return this.mResolutionFilter;
    }

    @Nullable
    public ResolutionStrategy getResolutionStrategy() {
        return this.mResolutionStrategy;
    }

    public static final class Builder {
        private int mAllowedResolutionMode = 0;
        @Nullable
        private AspectRatioStrategy mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
        @Nullable
        private ResolutionFilter mResolutionFilter = null;
        @Nullable
        private ResolutionStrategy mResolutionStrategy = null;

        public Builder() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromResolutionSelector(@NonNull ResolutionSelector resolutionSelector) {
            return new Builder(resolutionSelector);
        }

        @NonNull
        public ResolutionSelector build() {
            return new ResolutionSelector(this.mAspectRatioStrategy, this.mResolutionStrategy, this.mResolutionFilter, this.mAllowedResolutionMode);
        }

        @NonNull
        public Builder setAllowedResolutionMode(int i) {
            this.mAllowedResolutionMode = i;
            return this;
        }

        @NonNull
        public Builder setAspectRatioStrategy(@NonNull AspectRatioStrategy aspectRatioStrategy) {
            this.mAspectRatioStrategy = aspectRatioStrategy;
            return this;
        }

        @NonNull
        public Builder setResolutionFilter(@NonNull ResolutionFilter resolutionFilter) {
            this.mResolutionFilter = resolutionFilter;
            return this;
        }

        @NonNull
        public Builder setResolutionStrategy(@NonNull ResolutionStrategy resolutionStrategy) {
            this.mResolutionStrategy = resolutionStrategy;
            return this;
        }

        private Builder(@NonNull ResolutionSelector resolutionSelector) {
            this.mAspectRatioStrategy = resolutionSelector.getAspectRatioStrategy();
            this.mResolutionStrategy = resolutionSelector.getResolutionStrategy();
            this.mResolutionFilter = resolutionSelector.getResolutionFilter();
            this.mAllowedResolutionMode = resolutionSelector.getAllowedResolutionMode();
        }
    }
}
