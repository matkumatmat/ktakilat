package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
    public final Observable c;
    public final Callable d;
    public final BiConsumer e;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final BiConsumer d;
        public final Object e;
        public Disposable f;
        public boolean g;

        public CollectObserver(SingleObserver singleObserver, Object obj, BiConsumer biConsumer) {
            this.c = singleObserver;
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
                this.c.onSuccess(this.e);
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

    public ObservableCollectSingle(Observable observable, Callable callable, BiConsumer biConsumer) {
        this.c = observable;
        this.d = callable;
        this.e = biConsumer;
    }

    public final Observable a() {
        return new ObservableCollect(this.c, this.d, this.e);
    }

    public final void c(SingleObserver singleObserver) {
        try {
            Object call = this.d.call();
            ObjectHelper.b(call, "The initialSupplier returned a null value");
            this.c.subscribe(new CollectObserver(singleObserver, call, this.e));
        } catch (Throwable th) {
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
