package io.reactivex.internal.subscribers;

public interface InnerQueuedSubscriberSupport<T> {
    void a(InnerQueuedSubscriber innerQueuedSubscriber);

    void b();

    void d(InnerQueuedSubscriber innerQueuedSubscriber, Object obj);

    void e(InnerQueuedSubscriber innerQueuedSubscriber, Throwable th);
}
