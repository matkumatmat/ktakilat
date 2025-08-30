package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MutableStateObservable<T> extends StateObservable<T> {
    private MutableStateObservable(@Nullable Object obj, boolean z) {
        super(obj, z);
    }

    @NonNull
    public static <T> MutableStateObservable<T> withInitialError(@NonNull Throwable th) {
        return new MutableStateObservable<>(th, true);
    }

    @NonNull
    public static <T> MutableStateObservable<T> withInitialState(@Nullable T t) {
        return new MutableStateObservable<>(t, false);
    }

    public void setError(@NonNull Throwable th) {
        updateStateAsError(th);
    }

    public void setState(@Nullable T t) {
        updateState(t);
    }
}
