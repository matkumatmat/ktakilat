package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;

public class ConcurrentCamera {
    @NonNull
    private List<Camera> mCameras;

    public static final class SingleCameraConfig {
        @NonNull
        private CameraSelector mCameraSelector;
        @NonNull
        private LayoutSettings mLayoutSettings;
        @NonNull
        private LifecycleOwner mLifecycleOwner;
        @NonNull
        private UseCaseGroup mUseCaseGroup;

        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull LifecycleOwner lifecycleOwner) {
            this(cameraSelector, useCaseGroup, LayoutSettings.DEFAULT, lifecycleOwner);
        }

        @NonNull
        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public LayoutSettings getLayoutSettings() {
            return this.mLayoutSettings;
        }

        @NonNull
        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @NonNull
        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull LayoutSettings layoutSettings, @NonNull LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mLayoutSettings = layoutSettings;
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    public ConcurrentCamera(@NonNull List<Camera> list) {
        this.mCameras = list;
    }

    @NonNull
    public List<Camera> getCameras() {
        return this.mCameras;
    }
}
