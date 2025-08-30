package io.reactivex.internal.util;

import io.reactivex.subscribers.SerializedSubscriber;

public interface QueueDrain<T, U> {
    boolean a(SerializedSubscriber serializedSubscriber, Object obj);
}
