package androidx.camera.core.internal.utils;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.utils.RingBuffer;
import java.util.ArrayDeque;

public class ArrayRingBuffer<T> implements RingBuffer<T> {
    private static final String TAG = "ZslRingBuffer";
    @GuardedBy("mLock")
    private final ArrayDeque<T> mBuffer;
    private final Object mLock;
    @Nullable
    final RingBuffer.OnRemoveCallback<T> mOnRemoveCallback;
    private final int mRingBufferCapacity;

    public ArrayRingBuffer(int i) {
        this(i, (RingBuffer.OnRemoveCallback) null);
    }

    @NonNull
    public T dequeue() {
        T removeLast;
        synchronized (this.mLock) {
            removeLast = this.mBuffer.removeLast();
        }
        return removeLast;
    }

    public void enqueue(@NonNull T t) {
        Object obj;
        synchronized (this.mLock) {
            try {
                if (this.mBuffer.size() >= this.mRingBufferCapacity) {
                    obj = dequeue();
                } else {
                    obj = null;
                }
                this.mBuffer.addFirst(t);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        RingBuffer.OnRemoveCallback<T> onRemoveCallback = this.mOnRemoveCallback;
        if (onRemoveCallback != null && obj != null) {
            onRemoveCallback.onRemove(obj);
        }
    }

    public int getMaxCapacity() {
        return this.mRingBufferCapacity;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mLock) {
            isEmpty = this.mBuffer.isEmpty();
        }
        return isEmpty;
    }

    public ArrayRingBuffer(int i, @Nullable RingBuffer.OnRemoveCallback<T> onRemoveCallback) {
        this.mLock = new Object();
        this.mRingBufferCapacity = i;
        this.mBuffer = new ArrayDeque<>(i);
        this.mOnRemoveCallback = onRemoveCallback;
    }
}
