package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceProcessor;
import com.google.common.util.concurrent.ListenableFuture;

public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    @NonNull
    ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2);
}
