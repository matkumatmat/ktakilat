package androidx.camera.core;

import android.util.Range;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public interface CameraInfo {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImplementationType {
    }

    @NonNull
    CameraSelector getCameraSelector();

    @NonNull
    LiveData<CameraState> getCameraState();

    @NonNull
    ExposureState getExposureState();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    String getImplementationType();

    @FloatRange(from = 0.0d, fromInclusive = false)
    float getIntrinsicZoomRatio();

    int getLensFacing();

    @NonNull
    Set<CameraInfo> getPhysicalCameraInfos();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i);

    @NonNull
    Set<Range<Integer>> getSupportedFrameRateRanges();

    @NonNull
    LiveData<Integer> getTorchState();

    @NonNull
    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction);

    boolean isLogicalMultiCameraSupported();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isPrivateReprocessingSupported();

    @ExperimentalZeroShutterLag
    boolean isZslSupported();

    @NonNull
    Set<DynamicRange> querySupportedDynamicRanges(@NonNull Set<DynamicRange> set);
}
