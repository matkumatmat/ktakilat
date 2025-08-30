package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    public Present(T t) {
        this.mReference = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Present) {
            return this.mReference.equals(((Present) obj).mReference);
        }
        return false;
    }

    @NonNull
    public T get() {
        return this.mReference;
    }

    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    public boolean isPresent() {
        return true;
    }

    @NonNull
    public T or(@NonNull T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    public T orNull() {
        return this.mReference;
    }

    @NonNull
    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }

    @NonNull
    public Optional<T> or(@NonNull Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @NonNull
    public T or(@NonNull Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }
}
