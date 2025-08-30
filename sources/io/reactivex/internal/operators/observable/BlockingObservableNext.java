package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T> implements Iterable<T> {
    public final Observable c;

    public static final class NextIterator<T> implements Iterator<T> {
        public final NextObserver c;
        public final Observable d;
        public Object e;
        public boolean f = true;
        public boolean g = true;
        public Throwable i;
        public boolean j;

        public NextIterator(Observable observable, NextObserver nextObserver) {
            this.d = observable;
            this.c = nextObserver;
        }

        public final boolean hasNext() {
            Throwable th = this.i;
            if (th != null) {
                throw ExceptionHelper.c(th);
            } else if (!this.f) {
                return false;
            } else {
                if (this.g) {
                    boolean z = this.j;
                    NextObserver nextObserver = this.c;
                    AtomicInteger atomicInteger = nextObserver.e;
                    if (!z) {
                        this.j = true;
                        atomicInteger.set(1);
                        new AbstractObservableWithUpstream(this.d).subscribe(nextObserver);
                    }
                    try {
                        atomicInteger.set(1);
                        Notification notification = (Notification) nextObserver.d.take();
                        if (notification.d()) {
                            this.g = false;
                            this.e = notification.c();
                        } else {
                            this.f = false;
                            if (notification.f656a == null) {
                                return false;
                            }
                            Throwable b = notification.b();
                            this.i = b;
                            throw ExceptionHelper.c(b);
                        }
                    } catch (InterruptedException e2) {
                        nextObserver.dispose();
                        this.i = e2;
                        throw ExceptionHelper.c(e2);
                    }
                }
                return true;
            }
        }

        public final Object next() {
            Throwable th = this.i;
            if (th != null) {
                throw ExceptionHelper.c(th);
            } else if (hasNext()) {
                this.g = true;
                return this.e;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
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

    public BlockingObservableNext(Observable observable) {
        this.c = observable;
    }

    public final Iterator iterator() {
        return new NextIterator(this.c, new NextObserver());
    }
}
