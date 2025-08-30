package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraConfig;

public interface Camera {
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraInfo getCameraInfo();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraConfig getExtendedConfig();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupported(boolean z, @NonNull UseCase... useCaseArr);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupportedByFramework(@NonNull UseCase... useCaseArr);
}
