package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.reference.get();
            if (t == null) {
                AtomicReference<AtomicSafeInitializer<T>> atomicReference = this.factory;
                while (true) {
                    if (!atomicReference.compareAndSet((Object) null, this)) {
                        if (atomicReference.get() != null) {
                            break;
                        }
                    } else {
                        this.reference.set(initialize());
                        break;
                    }
                }
            } else {
                return t;
            }
        }
    }

    public abstract T initialize() throws ConcurrentException;
}
