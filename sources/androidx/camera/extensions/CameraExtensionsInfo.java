package androidx.camera.extensions;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

public interface CameraExtensionsInfo {
    @Nullable
    LiveData<Integer> getCurrentExtensionMode();

    @Nullable
    LiveData<Integer> getExtensionStrength();

    boolean isCurrentExtensionModeAvailable();

    boolean isExtensionStrengthAvailable();
}
