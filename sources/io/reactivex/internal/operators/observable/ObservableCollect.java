package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final Callable d;
    public final BiConsumer e;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        public final Observer c;
        public final BiConsumer d;
        public final Object e;
        public Disposable f;
        public boolean g;

        public CollectObserver(Observer observer, Object obj, BiConsumer biConsumer) {
            this.c = observer;
            this.d = biConsumer;
            this.e = obj;
        }

        public final void dispose() {
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.g) {
                this.g = true;
                Object obj = this.e;
                Observer observer = this.c;
                observer.onNext(obj);
                observer.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.b(th);
                return;
            }
            this.g = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.g) {
                try {
                    this.d.accept(this.e, obj);
                } catch (Throwable th) {
                    this.f.dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(Observable observable, Callable callable, BiConsumer biConsumer) {
        super(observable);
        this.d = callable;
        this.e = biConsumer;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.d.call();
            ObjectHelper.b(call, "The initialSupplier returned a null value");
            this.c.subscribe(new CollectObserver(observer, call, this.e));
        } catch (Throwable th) {
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
