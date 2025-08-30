package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback);

    @NonNull
    Object getCameraCharacteristics();

    @NonNull
    String getCameraId();

    @NonNull
    Quirks getCameraQuirks();

    @NonNull
    CameraSelector getCameraSelector();

    @NonNull
    EncoderProfilesProvider getEncoderProfilesProvider();

    @NonNull
    CameraInfoInternal getImplementation();

    @Nullable
    Object getPhysicalCameraCharacteristics(@NonNull String str);

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Size> getSupportedHighResolutions(int i);

    @NonNull
    Set<Integer> getSupportedOutputFormats();

    @NonNull
    List<Size> getSupportedResolutions(int i);

    @NonNull
    Timebase getTimebase();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();

    boolean isPreviewStabilizationSupported();

    boolean isVideoStabilizationSupported();

    void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback);
}
