package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final long d;
    public final long e;
    public final int f;

    public static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        public final Observer c;
        public final long d;
        public final int e;
        public long f;
        public Disposable g;
        public UnicastSubject i;
        public volatile boolean j;

        public WindowExactObserver(Observer observer, long j2, int i2) {
            this.c = observer;
            this.d = j2;
            this.e = i2;
        }

        public final void dispose() {
            this.j = true;
        }

        public final boolean isDisposed() {
            return this.j;
        }

        public final void onComplete() {
            UnicastSubject unicastSubject = this.i;
            if (unicastSubject != null) {
                this.i = null;
                unicastSubject.onComplete();
            }
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            UnicastSubject unicastSubject = this.i;
            if (unicastSubject != null) {
                this.i = null;
                unicastSubject.onError(th);
            }
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            UnicastSubject unicastSubject = this.i;
            if (unicastSubject == null && !this.j) {
                UnicastSubject unicastSubject2 = new UnicastSubject(this, this.e);
                this.i = unicastSubject2;
                this.c.onNext(unicastSubject2);
                unicastSubject = unicastSubject2;
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(obj);
                long j2 = this.f + 1;
                this.f = j2;
                if (j2 >= this.d) {
                    this.f = 0;
                    this.i = null;
                    unicastSubject.onComplete();
                    if (this.j) {
                        this.g.dispose();
                    }
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void run() {
            if (this.j) {
                this.g.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        public final Observer c;
        public final long d;
        public final long e;
        public final int f;
        public final ArrayDeque g;
        public long i;
        public volatile boolean j;
        public long k;
        public Disposable l;
        public final AtomicInteger m = new AtomicInteger();

        public WindowSkipObserver(Observer observer, long j2, long j3, int i2) {
            this.c = observer;
            this.d = j2;
            this.e = j3;
            this.f = i2;
            this.g = new ArrayDeque();
        }

        public final void dispose() {
            this.j = true;
        }

        public final boolean isDisposed() {
            return this.j;
        }

        public final void onComplete() {
            ArrayDeque arrayDeque = this.g;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
            }
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            ArrayDeque arrayDeque = this.g;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onError(th);
            }
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            ArrayDeque arrayDeque = this.g;
            long j2 = this.i;
            long j3 = this.e;
            if (j2 % j3 == 0 && !this.j) {
                this.m.getAndIncrement();
                UnicastSubject unicastSubject = new UnicastSubject(this, this.f);
                arrayDeque.offer(unicastSubject);
                this.c.onNext(unicastSubject);
            }
            long j4 = this.k + 1;
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).onNext(obj);
            }
            if (j4 >= this.d) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
                if (!arrayDeque.isEmpty() || !this.j) {
                    this.k = j4 - j3;
                } else {
                    this.l.dispose();
                    return;
                }
            } else {
                this.k = j4;
            }
            this.i = j2 + 1;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.l, disposable)) {
                this.l = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void run() {
            if (this.m.decrementAndGet() == 0 && this.j) {
                this.l.dispose();
            }
        }
    }

    public ObservableWindow(Observable observable, long j, long j2, int i) {
        super(observable);
        this.d = j;
        this.e = j2;
        this.f = i;
    }

    public final void subscribeActual(Observer observer) {
        long j = this.e;
        ObservableSource observableSource = this.c;
        long j2 = this.d;
        if (j2 == j) {
            observableSource.subscribe(new WindowExactObserver(observer, j2, this.f));
            return;
        }
        Observer observer2 = observer;
        observableSource.subscribe(new WindowSkipObserver(observer2, this.d, this.e, this.f));
    }
}
