package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate d;

    public static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final Predicate d;
        public Disposable e;
        public boolean f;

        public SkipWhileObserver(Observer observer, Predicate predicate) {
            this.c = observer;
            this.d = predicate;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            boolean z = this.f;
            Observer observer = this.c;
            if (z) {
                observer.onNext(obj);
                return;
            }
            try {
                if (!this.d.test(obj)) {
                    this.f = true;
                    observer.onNext(obj);
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.e.dispose();
                observer.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSkipWhile(Observable observable, Predicate predicate) {
        super(observable);
        this.d = predicate;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new SkipWhileObserver(observer, this.d));
    }
}
