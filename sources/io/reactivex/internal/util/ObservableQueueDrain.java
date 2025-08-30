package io.reactivex.internal.util;

import io.reactivex.observers.SerializedObserver;

public interface ObservableQueueDrain<T, U> {
    void a(SerializedObserver serializedObserver, Object obj);
}
