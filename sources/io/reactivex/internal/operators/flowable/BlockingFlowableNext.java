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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingFlowableNext<T> implements Iterable<T> {

    public static final class NextIterator<T> implements Iterator<T> {
        public final NextSubscriber c;
        public Object d;
        public boolean e = true;
        public boolean f = true;
        public Throwable g;
        public boolean i;

        public NextIterator(NextSubscriber nextSubscriber) {
            this.c = nextSubscriber;
        }

        public final boolean hasNext() {
            Throwable th = this.g;
            if (th != null) {
                throw ExceptionHelper.c(th);
            } else if (!this.e) {
                return false;
            } else {
                boolean z = true;
                if (this.f) {
                    NextSubscriber nextSubscriber = this.c;
                    try {
                        boolean z2 = this.i;
                        AtomicInteger atomicInteger = nextSubscriber.e;
                        if (z2) {
                            atomicInteger.set(1);
                            Notification notification = (Notification) nextSubscriber.d.take();
                            if (notification.d()) {
                                this.f = false;
                                this.d = notification.c();
                            } else {
                                this.e = false;
                                Object obj = notification.f656a;
                                if (obj != null) {
                                    z = false;
                                }
                                if (z) {
                                    return false;
                                }
                                if (NotificationLite.isError(obj)) {
                                    Throwable b = notification.b();
                                    this.g = b;
                                    throw ExceptionHelper.c(b);
                                }
                                throw new IllegalStateException("Should not reach here");
                            }
                        } else {
                            this.i = true;
                            atomicInteger.set(1);
                            int i2 = Flowable.c;
                            ObjectHelper.b((Object) null, "publisher is null");
                            throw null;
                        }
                    } catch (InterruptedException e2) {
                        nextSubscriber.dispose();
                        this.g = e2;
                        throw ExceptionHelper.c(e2);
                    }
                }
                return true;
            }
        }

        public final Object next() {
            Throwable th = this.g;
            if (th != null) {
                throw ExceptionHelper.c(th);
            } else if (hasNext()) {
                this.f = true;
                return this.d;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        public final ArrayBlockingQueue d = new ArrayBlockingQueue(1);
        public final AtomicInteger e = new AtomicInteger();

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            Notification notification = (Notification) obj;
            if (this.e.getAndSet(0) == 1 || !notification.d()) {
                while (true) {
                    ArrayBlockingQueue arrayBlockingQueue = this.d;
                    if (!arrayBlockingQueue.offer(notification)) {
                        Notification notification2 = (Notification) arrayBlockingQueue.poll();
                        if (notification2 != null && !notification2.d()) {
                            notification = notification2;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final Iterator iterator() {
        return new NextIterator(new NextSubscriber());
    }
}
