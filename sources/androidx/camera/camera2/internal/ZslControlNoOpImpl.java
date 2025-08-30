package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

public class ZslControlNoOpImpl implements ZslControl {
    public void addZslConfig(@NonNull SessionConfig.Builder builder) {
    }

    @Nullable
    public ImageProxy dequeueImageFromBuffer() {
        return null;
    }

    public boolean enqueueImageToImageWriter(@NonNull ImageProxy imageProxy) {
        return false;
    }

    public boolean isZslDisabledByFlashMode() {
        return false;
    }

    public boolean isZslDisabledByUserCaseConfig() {
        return false;
    }

    public void setZslDisabledByFlashMode(boolean z) {
    }

    public void setZslDisabledByUserCaseConfig(boolean z) {
    }
}
