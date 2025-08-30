package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface FutureCallback<V> {
    void onFailure(@NonNull Throwable th);

    void onSuccess(@Nullable V v);
}
