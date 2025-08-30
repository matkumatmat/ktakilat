package io.reactivex.internal.observers;

public interface InnerQueuedObserverSupport<T> {
    void b();

    void c(InnerQueuedObserver innerQueuedObserver, Throwable th);

    void d(InnerQueuedObserver innerQueuedObserver);

    void e(InnerQueuedObserver innerQueuedObserver, Object obj);
}
