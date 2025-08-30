package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingFlowableLatest<T> implements Iterable<T> {

    public static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        public final Semaphore d = new Semaphore(0);
        public final AtomicReference e = new AtomicReference();
        public Notification f;

        public final boolean hasNext() {
            Notification notification = this.f;
            if (notification == null || !NotificationLite.isError(notification.f656a)) {
                Notification notification2 = this.f;
                if ((notification2 == null || notification2.d()) && this.f == null) {
                    try {
                        this.d.acquire();
                        Notification notification3 = (Notification) this.e.getAndSet((Object) null);
                        this.f = notification3;
                        if (NotificationLite.isError(notification3.f656a)) {
                            throw ExceptionHelper.c(notification3.b());
                        }
                    } catch (InterruptedException e2) {
                        dispose();
                        this.f = Notification.a(e2);
                        throw ExceptionHelper.c(e2);
                    }
                }
                return this.f.d();
            }
            throw ExceptionHelper.c(this.f.b());
        }

        public final Object next() {
            if (!hasNext() || !this.f.d()) {
                throw new NoSuchElementException();
            }
            Object c = this.f.c();
            this.f = null;
            return c;
        }

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.e.getAndSet((Notification) obj) == null) {
                this.d.release();
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public final Iterator iterator() {
        new LatestSubscriberIterator();
        int i = Flowable.c;
        ObjectHelper.b((Object) null, "publisher is null");
        throw null;
    }
}
