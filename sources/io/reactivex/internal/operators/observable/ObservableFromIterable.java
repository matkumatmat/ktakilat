package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class ObservableFromIterable<T> extends Observable<T> {
    public final Iterable c;

    public static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        public final Observer c;
        public final Iterator d;
        public volatile boolean e;
        public boolean f;
        public boolean g;
        public boolean i;

        public FromIterableDisposable(Observer observer, Iterator it) {
            this.c = observer;
            this.d = it;
        }

        public final void clear() {
            this.g = true;
        }

        public final void dispose() {
            this.e = true;
        }

        public final boolean isDisposed() {
            return this.e;
        }

        public final boolean isEmpty() {
            return this.g;
        }

        public final Object poll() {
            if (this.g) {
                return null;
            }
            boolean z = this.i;
            Iterator it = this.d;
            if (!z) {
                this.i = true;
            } else if (!it.hasNext()) {
                this.g = true;
                return null;
            }
            Object next = it.next();
            ObjectHelper.b(next, "The iterator returned a null value");
            return next;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f = true;
            return 1;
        }
    }

    public ObservableFromIterable(Iterable iterable) {
        this.c = iterable;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Iterator it = this.c.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (!fromIterableDisposable.f) {
                    while (!fromIterableDisposable.e) {
                        try {
                            Object next = fromIterableDisposable.d.next();
                            ObjectHelper.b(next, "The iterator returned a null value");
                            fromIterableDisposable.c.onNext(next);
                            if (!fromIterableDisposable.e) {
                                try {
                                    if (!fromIterableDisposable.d.hasNext()) {
                                        if (!fromIterableDisposable.e) {
                                            fromIterableDisposable.c.onComplete();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.a(th);
                                    fromIterableDisposable.c.onError(th);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.a(th2);
                            fromIterableDisposable.c.onError(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                Exceptions.a(th3);
                EmptyDisposable.error(th3, (Observer<?>) observer);
            }
        } catch (Throwable th4) {
            Exceptions.a(th4);
            EmptyDisposable.error(th4, (Observer<?>) observer);
        }
    }
}
