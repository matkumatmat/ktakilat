package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SessionProcessor {

    public interface CaptureCallback {
        void onCaptureCompleted(long j, int i, @NonNull CameraCaptureResult cameraCaptureResult);

        void onCaptureFailed(int i);

        void onCaptureProcessProgressed(int i);

        void onCaptureProcessStarted(int i);

        void onCaptureSequenceAborted(int i);

        void onCaptureSequenceCompleted(int i);

        void onCaptureStarted(int i, long j);
    }

    void abortCapture(int i);

    void deInitSession();

    @Nullable
    Pair<Long, Long> getRealtimeCaptureLatency();

    @NonNull
    Set<Integer> getSupportedCameraOperations();

    @NonNull
    Map<Integer, List<Size>> getSupportedPostviewSize(@NonNull Size size);

    @NonNull
    SessionConfig initSession(@NonNull CameraInfo cameraInfo, @NonNull OutputSurfaceConfiguration outputSurfaceConfiguration);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(@NonNull RequestProcessor requestProcessor);

    void setParameters(@NonNull Config config);

    int startCapture(boolean z, @NonNull TagBundle tagBundle, @NonNull CaptureCallback captureCallback);

    int startRepeating(@NonNull TagBundle tagBundle, @NonNull CaptureCallback captureCallback);

    int startTrigger(@NonNull Config config, @NonNull TagBundle tagBundle, @NonNull CaptureCallback captureCallback);

    void stopRepeating();
}
