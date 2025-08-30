package androidx.camera.extensions;

import androidx.annotation.IntRange;

public interface CameraExtensionsControl {
    void setExtensionStrength(@IntRange(from = 0, to = 100) int i);
}
