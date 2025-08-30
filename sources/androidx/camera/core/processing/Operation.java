package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.camera.core.ImageCaptureException;

public interface Operation<I, O> {
    @WorkerThread
    @NonNull
    O apply(@NonNull I i) throws ImageCaptureException;
}
