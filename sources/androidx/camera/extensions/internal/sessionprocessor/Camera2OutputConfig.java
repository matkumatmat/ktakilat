package androidx.camera.extensions.internal.sessionprocessor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

interface Camera2OutputConfig {
    int getId();

    @Nullable
    String getPhysicalCameraId();

    int getSurfaceGroupId();

    @NonNull
    List<Camera2OutputConfig> getSurfaceSharingOutputConfigs();
}
