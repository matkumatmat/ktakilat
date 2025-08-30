package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    public final BiFunction d;
    public final ObservableSource e;

    public final class WithLastFrom implements Observer<U> {
        public final WithLatestFromObserver c;

        public WithLastFrom(WithLatestFromObserver withLatestFromObserver) {
            this.c = withLatestFromObserver;
        }

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            WithLatestFromObserver withLatestFromObserver = this.c;
            DisposableHelper.dispose(withLatestFromObserver.e);
            withLatestFromObserver.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.lazySet(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.c.f, disposable);
        }
    }

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        public final SerializedObserver c;
        public final BiFunction d;
        public final AtomicReference e = new AtomicReference();
        public final AtomicReference f = new AtomicReference();

        public WithLatestFromObserver(SerializedObserver serializedObserver, BiFunction biFunction) {
            this.c = serializedObserver;
            this.d = biFunction;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.e);
            DisposableHelper.dispose(this.f);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.e.get());
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.f);
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.f);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            SerializedObserver serializedObserver = this.c;
            Object obj2 = get();
            if (obj2 != null) {
                try {
                    Object apply = this.d.apply(obj, obj2);
                    ObjectHelper.b(apply, "The combiner returned a null value");
                    serializedObserver.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    dispose();
                    serializedObserver.onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.e, disposable);
        }
    }

    public ObservableWithLatestFrom(Observable observable, BiFunction biFunction, ObservableSource observableSource) {
        super(observable);
        this.d = biFunction;
        this.e = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.d);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.e.subscribe(new WithLastFrom(withLatestFromObserver));
        this.c.subscribe(withLatestFromObserver);
    }
}
