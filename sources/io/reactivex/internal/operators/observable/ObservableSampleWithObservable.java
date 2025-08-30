package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource d;
    public final boolean e;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public final AtomicInteger g = new AtomicInteger();
        public volatile boolean i;

        public SampleMainEmitLast(SerializedObserver serializedObserver, ObservableSource observableSource) {
            super(serializedObserver, observableSource);
        }

        public final void a() {
            this.i = true;
            if (this.g.getAndIncrement() == 0) {
                Object andSet = getAndSet((Object) null);
                if (andSet != null) {
                    this.c.onNext(andSet);
                }
                this.c.onComplete();
            }
        }

        public final void b() {
            this.i = true;
            if (this.g.getAndIncrement() == 0) {
                Object andSet = getAndSet((Object) null);
                if (andSet != null) {
                    this.c.onNext(andSet);
                }
                this.c.onComplete();
            }
        }

        public final void c() {
            if (this.g.getAndIncrement() == 0) {
                do {
                    boolean z = this.i;
                    Object andSet = getAndSet((Object) null);
                    if (andSet != null) {
                        this.c.onNext(andSet);
                    }
                    if (z) {
                        this.c.onComplete();
                        return;
                    }
                } while (this.g.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public final void a() {
            this.c.onComplete();
        }

        public final void b() {
            this.c.onComplete();
        }

        public final void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.c.onNext(andSet);
            }
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final SerializedObserver c;
        public final ObservableSource d;
        public final AtomicReference e = new AtomicReference();
        public Disposable f;

        public SampleMainObserver(SerializedObserver serializedObserver, ObservableSource observableSource) {
            this.c = serializedObserver;
            this.d = observableSource;
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public final void dispose() {
            DisposableHelper.dispose(this.e);
            this.f.dispose();
        }

        public final boolean isDisposed() {
            if (this.e.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.e);
            a();
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.e);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            lazySet(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.onSubscribe(this);
                if (this.e.get() == null) {
                    this.d.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    public static final class SamplerObserver<T> implements Observer<Object> {
        public final SampleMainObserver c;

        public SamplerObserver(SampleMainObserver sampleMainObserver) {
            this.c = sampleMainObserver;
        }

        public final void onComplete() {
            SampleMainObserver sampleMainObserver = this.c;
            sampleMainObserver.f.dispose();
            sampleMainObserver.b();
        }

        public final void onError(Throwable th) {
            SampleMainObserver sampleMainObserver = this.c;
            sampleMainObserver.f.dispose();
            sampleMainObserver.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.c();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.c.e, disposable);
        }
    }

    public ObservableSampleWithObservable(Observable observable, ObservableSource observableSource, boolean z) {
        super(observable);
        this.d = observableSource;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        boolean z = this.e;
        ObservableSource observableSource = this.d;
        ObservableSource observableSource2 = this.c;
        if (z) {
            observableSource2.subscribe(new SampleMainEmitLast(serializedObserver, observableSource));
        } else {
            observableSource2.subscribe(new SampleMainObserver(serializedObserver, observableSource));
        }
    }
}
