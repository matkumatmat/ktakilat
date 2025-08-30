package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate d;

    public static final class TakeWhileObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final Predicate d;
        public Disposable e;
        public boolean f;

        public TakeWhileObserver(Observer observer, Predicate predicate) {
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
            if (!this.f) {
                this.f = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                try {
                    boolean test = this.d.test(obj);
                    Observer observer = this.c;
                    if (!test) {
                        this.f = true;
                        this.e.dispose();
                        observer.onComplete();
                        return;
                    }
                    observer.onNext(obj);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.e.dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(Observable observable, Predicate predicate) {
        super(observable);
        this.d = predicate;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new TakeWhileObserver(observer, this.d));
    }
}
