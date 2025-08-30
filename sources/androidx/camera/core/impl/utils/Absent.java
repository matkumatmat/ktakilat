package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

final class Absent<T> extends Optional<T> {
    static final Absent<Object> sInstance = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return sInstance;
    }

    public static <T> Optional<T> withType() {
        return sInstance;
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this;
    }

    @NonNull
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public int hashCode() {
        return 2040732332;
    }

    public boolean isPresent() {
        return false;
    }

    @NonNull
    public T or(@NonNull T t) {
        return Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Nullable
    public T orNull() {
        return null;
    }

    @NonNull
    public String toString() {
        return "Optional.absent()";
    }

    @NonNull
    public Optional<T> or(@NonNull Optional<? extends T> optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @NonNull
    public T or(@NonNull Supplier<? extends T> supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
