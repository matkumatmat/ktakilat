package androidx.camera.core.streamsharing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.streamsharing.StreamSharing;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";
    @NonNull
    private final CameraInternal mParentCamera;
    private final UseCase.StateChangeCallback mStateChangeCallback;
    @NonNull
    private final VirtualCameraControl mVirtualCameraControl;
    @NonNull
    private final VirtualCameraInfo mVirtualCameraInfo;

    public VirtualCamera(@NonNull CameraInternal cameraInternal, @NonNull UseCase.StateChangeCallback stateChangeCallback, @NonNull StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mStateChangeCallback = stateChangeCallback;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal(), control);
        this.mVirtualCameraInfo = new VirtualCameraInfo(cameraInternal.getCameraInfoInternal());
    }

    public void attachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void detachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public final /* synthetic */ CameraControl getCameraControl() {
        return o2.a(this);
    }

    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    public final /* synthetic */ CameraInfo getCameraInfo() {
        return o2.b(this);
    }

    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mVirtualCameraInfo;
    }

    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    public final /* synthetic */ CameraConfig getExtendedConfig() {
        return o2.c(this);
    }

    public boolean getHasTransform() {
        return false;
    }

    public final /* synthetic */ boolean isFrontFacing() {
        return o2.e(this);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupported(boolean z, UseCase... useCaseArr) {
        return r1.a(this, z, useCaseArr);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return r1.c(this, useCaseArr);
    }

    @MainThread
    public void onUseCaseActive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseActive(useCase);
    }

    @MainThread
    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseInactive(useCase);
    }

    @MainThread
    public void onUseCaseReset(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseReset(useCase);
    }

    @MainThread
    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseUpdated(useCase);
    }

    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @NonNull
    public ListenableFuture<Void> release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public final /* synthetic */ void setActiveResumingMode(boolean z) {
        o2.f(this, z);
    }

    public final /* synthetic */ void setExtendedConfig(CameraConfig cameraConfig) {
        o2.g(this, cameraConfig);
    }

    public final /* synthetic */ void setPrimary(boolean z) {
        o2.h(this, z);
    }

    public void setRotationDegrees(int i) {
        this.mVirtualCameraInfo.setVirtualCameraRotationDegrees(i);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return r1.b(this, useCaseArr);
    }
}
