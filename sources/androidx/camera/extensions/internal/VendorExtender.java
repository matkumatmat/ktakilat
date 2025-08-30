package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.List;
import java.util.Map;

public interface VendorExtender {
    @Nullable
    SessionProcessor createSessionProcessor(@NonNull Context context);

    @Nullable
    Range<Long> getEstimatedCaptureLatencyRange(@Nullable Size size);

    @NonNull
    List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions();

    @NonNull
    List<CaptureResult.Key> getSupportedCaptureResultKeys();

    @NonNull
    Map<Integer, List<Size>> getSupportedPostviewResolutions(@NonNull Size size);

    @NonNull
    List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions();

    @NonNull
    Size[] getSupportedYuvAnalysisResolutions();

    void init(@NonNull CameraInfo cameraInfo);

    boolean isCaptureProcessProgressAvailable();

    boolean isCurrentExtensionModeAvailable();

    boolean isExtensionAvailable(@NonNull String str, @NonNull Map<String, CameraCharacteristics> map);

    boolean isExtensionStrengthAvailable();

    boolean isPostviewAvailable();

    boolean willReceiveOnCaptureCompleted();
}
