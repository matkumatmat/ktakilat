package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface VideoCapabilities {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final VideoCapabilities EMPTY = new VideoCapabilities() {
        public final /* synthetic */ VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size size, DynamicRange dynamicRange) {
            return n.a(this, size, dynamicRange);
        }

        public final /* synthetic */ Quality findNearestHigherSupportedQualityFor(Size size, DynamicRange dynamicRange) {
            return n.b(this, size, dynamicRange);
        }

        public final /* synthetic */ VideoValidatedEncoderProfilesProxy getProfiles(Quality quality, DynamicRange dynamicRange) {
            return n.c(this, quality, dynamicRange);
        }

        @NonNull
        public Set<DynamicRange> getSupportedDynamicRanges() {
            return new HashSet();
        }

        @NonNull
        public List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange) {
            return new ArrayList();
        }

        public boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
            return false;
        }

        public boolean isStabilizationSupported() {
            return false;
        }
    };

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(@NonNull Size size, @NonNull DynamicRange dynamicRange);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Quality findNearestHigherSupportedQualityFor(@NonNull Size size, @NonNull DynamicRange dynamicRange);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality, @NonNull DynamicRange dynamicRange);

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange);

    boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange);

    boolean isStabilizationSupported();
}
