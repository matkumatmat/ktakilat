package androidx.camera.core;

import androidx.annotation.NonNull;
import java.util.Set;

public interface ImageCaptureCapabilities {
    @ExperimentalImageCaptureOutputFormat
    @NonNull
    Set<Integer> getSupportedOutputFormats();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();
}
