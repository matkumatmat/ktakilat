package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

interface ZslControl {
    void addZslConfig(@NonNull SessionConfig.Builder builder);

    @Nullable
    ImageProxy dequeueImageFromBuffer();

    boolean enqueueImageToImageWriter(@NonNull ImageProxy imageProxy);

    boolean isZslDisabledByFlashMode();

    boolean isZslDisabledByUserCaseConfig();

    void setZslDisabledByFlashMode(boolean z);

    void setZslDisabledByUserCaseConfig(boolean z);
}
