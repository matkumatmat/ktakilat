package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource d;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        public final Observer c;
        public final AtomicReference d = new AtomicReference();
        public final OtherObserver e = new OtherObserver();
        public final AtomicThrowable f = new AtomicThrowable();

        public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            public final void onComplete() {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.d);
                HalfSerializer.a(takeUntilMainObserver.c, takeUntilMainObserver, takeUntilMainObserver.f);
            }

            public final void onError(Throwable th) {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.d);
                HalfSerializer.c(takeUntilMainObserver.c, th, takeUntilMainObserver, takeUntilMainObserver.f);
            }

            public final void onNext(Object obj) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.d);
                HalfSerializer.a(takeUntilMainObserver.c, takeUntilMainObserver, takeUntilMainObserver.f);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this.e);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.d.get());
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.e);
            HalfSerializer.a(this.c, this, this.f);
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.e);
            HalfSerializer.c(this.c, th, this, this.f);
        }

        public final void onNext(Object obj) {
            HalfSerializer.e(this.c, obj, this, this.f);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public ObservableTakeUntil(Observable observable, ObservableSource observableSource) {
        super(observable);
        this.d = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.d.subscribe(takeUntilMainObserver.e);
        this.c.subscribe(takeUntilMainObserver);
    }
}
