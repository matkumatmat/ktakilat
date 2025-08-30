package androidx.camera.core.processing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public interface Node<I, O> {
    void release();

    @MainThread
    @NonNull
    O transform(@NonNull I i);
}
