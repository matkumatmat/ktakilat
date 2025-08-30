package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public interface CameraControlInternal extends CameraControl {
    @NonNull
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() {
        public void addInteropConfig(@NonNull Config config) {
        }

        public void addZslConfig(@NonNull SessionConfig.Builder builder) {
        }

        @NonNull
        public ListenableFuture<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        public void clearInteropConfig() {
        }

        public final /* synthetic */ void decrementVideoUsage() {
            CC.a(this);
        }

        @NonNull
        public ListenableFuture<Void> enableTorch(boolean z) {
            return Futures.immediateFuture(null);
        }

        public final /* synthetic */ ListenableFuture getCameraCapturePipelineAsync(int i, int i2) {
            return CC.b(this, i, i2);
        }

        public int getFlashMode() {
            return 2;
        }

        public final /* synthetic */ CameraControlInternal getImplementation() {
            return CC.c(this);
        }

        @NonNull
        public Config getInteropConfig() {
            return null;
        }

        @NonNull
        public Rect getSensorRect() {
            return new Rect();
        }

        @NonNull
        public SessionConfig getSessionConfig() {
            return SessionConfig.defaultEmptySessionConfig();
        }

        public final /* synthetic */ void incrementVideoUsage() {
            CC.d(this);
        }

        public final /* synthetic */ boolean isInVideoUsage() {
            return CC.e(this);
        }

        public boolean isZslDisabledByByUserCaseConfig() {
            return false;
        }

        @NonNull
        public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
            return Futures.immediateFuture(0);
        }

        public void setFlashMode(int i) {
        }

        @NonNull
        public ListenableFuture<Void> setLinearZoom(float f) {
            return Futures.immediateFuture(null);
        }

        public final /* synthetic */ void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
            CC.f(this, screenFlash);
        }

        @NonNull
        public ListenableFuture<Void> setZoomRatio(float f) {
            return Futures.immediateFuture(null);
        }

        public void setZslDisabledByUserCaseConfig(boolean z) {
        }

        @NonNull
        public ListenableFuture<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        @NonNull
        public ListenableFuture<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i, int i2) {
            return Futures.immediateFuture(Collections.emptyList());
        }
    };

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(@NonNull Config config);

    void addZslConfig(@NonNull SessionConfig.Builder builder);

    void clearInteropConfig();

    void decrementVideoUsage();

    @NonNull
    ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(int i, int i2);

    int getFlashMode();

    @NonNull
    CameraControlInternal getImplementation();

    @NonNull
    Config getInteropConfig();

    @NonNull
    Rect getSensorRect();

    @NonNull
    SessionConfig getSessionConfig();

    void incrementVideoUsage();

    @VisibleForTesting
    boolean isInVideoUsage();

    boolean isZslDisabledByByUserCaseConfig();

    void setFlashMode(int i);

    void setScreenFlash(@Nullable ImageCapture.ScreenFlash screenFlash);

    void setZslDisabledByUserCaseConfig(boolean z);

    @NonNull
    ListenableFuture<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i, int i2);

    public static final class CameraControlException extends Exception {
        @NonNull
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        @NonNull
        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure, @NonNull Throwable th) {
            super(th);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }

    /* renamed from: androidx.camera.core.impl.CameraControlInternal$-CC  reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static ListenableFuture b(CameraControlInternal cameraControlInternal, int i, int i2) {
            return Futures.immediateFuture(new CameraCapturePipeline() {
                @NonNull
                public ListenableFuture<Void> invokePostCapture() {
                    return Futures.immediateFuture(null);
                }

                @NonNull
                public ListenableFuture<Void> invokePreCapture() {
                    return Futures.immediateFuture(null);
                }
            });
        }

        public static boolean e(CameraControlInternal cameraControlInternal) {
            return false;
        }

        public static void a(CameraControlInternal cameraControlInternal) {
        }

        public static CameraControlInternal c(CameraControlInternal cameraControlInternal) {
            return cameraControlInternal;
        }

        public static void d(CameraControlInternal cameraControlInternal) {
        }

        public static void f(CameraControlInternal cameraControlInternal, ImageCapture.ScreenFlash screenFlash) {
        }
    }
}
