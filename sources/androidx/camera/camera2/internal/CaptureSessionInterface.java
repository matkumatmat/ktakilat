package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    @NonNull
    List<CaptureConfig> getCaptureConfigs();

    @Nullable
    SessionConfig getSessionConfig();

    boolean isInOpenState();

    void issueCaptureRequests(@NonNull List<CaptureConfig> list);

    @NonNull
    ListenableFuture<Void> open(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull SynchronizedCaptureSession.Opener opener);

    @NonNull
    ListenableFuture<Void> release(boolean z);

    void setSessionConfig(@Nullable SessionConfig sessionConfig);

    void setStreamUseCaseMap(@NonNull Map<DeferrableSurface, Long> map);
}
