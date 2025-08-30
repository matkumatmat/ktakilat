package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExperimentalCameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

class ProcessCameraProviderWrapperImpl implements ProcessCameraProviderWrapper {
    private final ProcessCameraProvider mProcessCameraProvider;

    public ProcessCameraProviderWrapperImpl(ProcessCameraProvider processCameraProvider) {
        this.mProcessCameraProvider = processCameraProvider;
    }

    @NonNull
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup) {
        return this.mProcessCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup);
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalCameraInfo.class})
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        return this.mProcessCameraProvider.getCameraInfo(cameraSelector);
    }

    public boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        return this.mProcessCameraProvider.hasCamera(cameraSelector);
    }

    @VisibleForTesting
    @NonNull
    public ListenableFuture<Void> shutdownAsync() {
        return this.mProcessCameraProvider.shutdownAsync();
    }

    public void unbind(@NonNull UseCase... useCaseArr) {
        this.mProcessCameraProvider.unbind(useCaseArr);
    }

    public void unbindAll() {
        this.mProcessCameraProvider.unbindAll();
    }
}
