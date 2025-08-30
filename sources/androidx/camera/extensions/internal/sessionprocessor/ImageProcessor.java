package androidx.camera.extensions.internal.sessionprocessor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ImageProcessor {
    void onNextImageAvailable(int i, long j, @NonNull ImageReference imageReference, @Nullable String str);
}
