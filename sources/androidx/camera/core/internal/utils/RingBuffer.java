package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;

public interface RingBuffer<T> {

    public interface OnRemoveCallback<T> {
        void onRemove(@NonNull T t);
    }

    @NonNull
    T dequeue();

    void enqueue(@NonNull T t);

    int getMaxCapacity();

    boolean isEmpty();
}
