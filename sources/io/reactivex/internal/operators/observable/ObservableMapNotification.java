package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    public final Function d;
    public final Function e;
    public final Callable f;

    public static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        public final Observer c;
        public final Function d;
        public final Function e;
        public final Callable f;
        public Disposable g;

        public MapNotificationObserver(Observer observer, Function function, Function function2, Callable callable) {
            this.c = observer;
            this.d = function;
            this.e = function2;
            this.f = callable;
        }

        public final void dispose() {
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.g.isDisposed();
        }

        public final void onComplete() {
            Observer observer = this.c;
            try {
                Object call = this.f.call();
                ObjectHelper.b(call, "The onComplete ObservableSource returned is null");
                observer.onNext((ObservableSource) call);
                observer.onComplete();
            } catch (Throwable th) {
                Exceptions.a(th);
                observer.onError(th);
            }
        }

        public final void onError(Throwable th) {
            Observer observer = this.c;
            try {
                Object apply = this.e.apply(th);
                ObjectHelper.b(apply, "The onError ObservableSource returned is null");
                observer.onNext((ObservableSource) apply);
                observer.onComplete();
            } catch (Throwable th2) {
                Exceptions.a(th2);
                observer.onError(new CompositeException(th, th2));
            }
        }

        public final void onNext(Object obj) {
            Observer observer = this.c;
            try {
                Object apply = this.d.apply(obj);
                ObjectHelper.b(apply, "The onNext ObservableSource returned is null");
                observer.onNext((ObservableSource) apply);
            } catch (Throwable th) {
                Exceptions.a(th);
                observer.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableMapNotification(Observable observable, Function function, Function function2, Callable callable) {
        super(observable);
        this.d = function;
        this.e = function2;
        this.f = callable;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new MapNotificationObserver(observer, this.d, this.e, this.f));
    }
}
