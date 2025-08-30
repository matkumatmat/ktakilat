package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class ForwardingCameraControl implements CameraControlInternal {
    private final CameraControlInternal mCameraControlInternal;

    public ForwardingCameraControl(@NonNull CameraControlInternal cameraControlInternal) {
        this.mCameraControlInternal = cameraControlInternal;
    }

    public void addInteropConfig(@NonNull Config config) {
        this.mCameraControlInternal.addInteropConfig(config);
    }

    public void addZslConfig(@NonNull SessionConfig.Builder builder) {
        this.mCameraControlInternal.addZslConfig(builder);
    }

    @NonNull
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControlInternal.cancelFocusAndMetering();
    }

    public void clearInteropConfig() {
        this.mCameraControlInternal.clearInteropConfig();
    }

    public void decrementVideoUsage() {
        this.mCameraControlInternal.decrementVideoUsage();
    }

    @NonNull
    public ListenableFuture<Void> enableTorch(boolean z) {
        return this.mCameraControlInternal.enableTorch(z);
    }

    @NonNull
    public ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(int i, int i2) {
        return this.mCameraControlInternal.getCameraCapturePipelineAsync(i, i2);
    }

    public int getFlashMode() {
        return this.mCameraControlInternal.getFlashMode();
    }

    @NonNull
    public CameraControlInternal getImplementation() {
        return this.mCameraControlInternal.getImplementation();
    }

    @NonNull
    public Config getInteropConfig() {
        return this.mCameraControlInternal.getInteropConfig();
    }

    @NonNull
    public Rect getSensorRect() {
        return this.mCameraControlInternal.getSensorRect();
    }

    @NonNull
    public SessionConfig getSessionConfig() {
        return this.mCameraControlInternal.getSessionConfig();
    }

    public void incrementVideoUsage() {
        this.mCameraControlInternal.incrementVideoUsage();
    }

    @VisibleForTesting
    public boolean isInVideoUsage() {
        return this.mCameraControlInternal.isInVideoUsage();
    }

    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mCameraControlInternal.isZslDisabledByByUserCaseConfig();
    }

    @NonNull
    public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
        return this.mCameraControlInternal.setExposureCompensationIndex(i);
    }

    public void setFlashMode(int i) {
        this.mCameraControlInternal.setFlashMode(i);
    }

    @NonNull
    public ListenableFuture<Void> setLinearZoom(float f) {
        return this.mCameraControlInternal.setLinearZoom(f);
    }

    public void setScreenFlash(@Nullable ImageCapture.ScreenFlash screenFlash) {
        this.mCameraControlInternal.setScreenFlash(screenFlash);
    }

    @NonNull
    public ListenableFuture<Void> setZoomRatio(float f) {
        return this.mCameraControlInternal.setZoomRatio(f);
    }

    public void setZslDisabledByUserCaseConfig(boolean z) {
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(z);
    }

    @NonNull
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        return this.mCameraControlInternal.startFocusAndMetering(focusMeteringAction);
    }

    @NonNull
    public ListenableFuture<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i, int i2) {
        return this.mCameraControlInternal.submitStillCaptureRequests(list, i, i2);
    }
}
