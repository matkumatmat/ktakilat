package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource d;

    public final class SkipUntil implements Observer<U> {
        public final ArrayCompositeDisposable c;
        public final SkipUntilObserver d;
        public final SerializedObserver e;
        public Disposable f;

        public SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver skipUntilObserver, SerializedObserver serializedObserver) {
            this.c = arrayCompositeDisposable;
            this.d = skipUntilObserver;
            this.e = serializedObserver;
        }

        public final void onComplete() {
            this.d.f = true;
        }

        public final void onError(Throwable th) {
            this.c.dispose();
            this.e.onError(th);
        }

        public final void onNext(Object obj) {
            this.f.dispose();
            this.d.f = true;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.setResource(1, disposable);
            }
        }
    }

    public static final class SkipUntilObserver<T> implements Observer<T> {
        public final SerializedObserver c;
        public final ArrayCompositeDisposable d;
        public Disposable e;
        public volatile boolean f;
        public boolean g;

        public SkipUntilObserver(SerializedObserver serializedObserver, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.c = serializedObserver;
            this.d = arrayCompositeDisposable;
        }

        public final void onComplete() {
            this.d.dispose();
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.d.dispose();
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.g) {
                this.c.onNext(obj);
            } else if (this.f) {
                this.g = true;
                this.c.onNext(obj);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.d.setResource(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(Observable observable, ObservableSource observableSource) {
        super(observable);
        this.d = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.d.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.c.subscribe(skipUntilObserver);
    }
}
