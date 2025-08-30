package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import kotlin.jvm.internal.Intrinsics;

public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    public void accept(@NonNull T t) {
        Intrinsics.d(this.mListener, "Listener is not set.");
        this.mListener.accept(t);
    }

    public void setListener(@NonNull Consumer<T> consumer) {
        this.mListener = consumer;
    }
}
