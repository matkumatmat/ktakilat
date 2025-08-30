package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {
    public final Observable c;

    public static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        public Notification d;
        public final Semaphore e = new Semaphore(0);
        public final AtomicReference f = new AtomicReference();

        public final boolean hasNext() {
            Notification notification = this.d;
            if (notification == null || !NotificationLite.isError(notification.f656a)) {
                if (this.d == null) {
                    try {
                        this.e.acquire();
                        Notification notification2 = (Notification) this.f.getAndSet((Object) null);
                        this.d = notification2;
                        if (NotificationLite.isError(notification2.f656a)) {
                            throw ExceptionHelper.c(notification2.b());
                        }
                    } catch (InterruptedException e2) {
                        dispose();
                        this.d = Notification.a(e2);
                        throw ExceptionHelper.c(e2);
                    }
                }
                return this.d.d();
            }
            throw ExceptionHelper.c(this.d.b());
        }

        public final Object next() {
            if (hasNext()) {
                Object c = this.d.c();
                this.d = null;
                return c;
            }
            throw new NoSuchElementException();
        }

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.f.getAndSet((Notification) obj) == null) {
                this.e.release();
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(Observable observable) {
        this.c = observable;
    }

    public final Iterator iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.c).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
