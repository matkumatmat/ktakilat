package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        public final Observer c;
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicThrowable e = new AtomicThrowable();
        public final Subject f;
        public final InnerRepeatObserver g = new InnerRepeatObserver();
        public final AtomicReference i = new AtomicReference();
        public final ObservableSource j;
        public volatile boolean k;

        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            public final void onComplete() {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.i);
                HalfSerializer.a(repeatWhenObserver.c, repeatWhenObserver, repeatWhenObserver.e);
            }

            public final void onError(Throwable th) {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.i);
                HalfSerializer.c(repeatWhenObserver.c, th, repeatWhenObserver, repeatWhenObserver.e);
            }

            public final void onNext(Object obj) {
                RepeatWhenObserver.this.a();
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(Observer observer, Subject subject, ObservableSource observableSource) {
            this.c = observer;
            this.f = subject;
            this.j = observableSource;
        }

        public final void a() {
            if (this.d.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.k) {
                        this.k = true;
                        this.j.subscribe(this);
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this.i);
            DisposableHelper.dispose(this.g);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.i.get());
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.g);
            HalfSerializer.a(this.c, this, this.e);
        }

        public final void onError(Throwable th) {
            this.k = false;
            this.f.onNext(th);
        }

        public final void onNext(Object obj) {
            HalfSerializer.e(this.c, obj, this, this.e);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.i, disposable);
        }
    }

    public ObservableRetryWhen(Observable observable, Function function) {
        super(observable);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        Subject c = new PublishSubject().c();
        try {
            Object apply = this.d.apply(c);
            ObjectHelper.b(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, c, this.c);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.g);
            repeatWhenObserver.a();
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
