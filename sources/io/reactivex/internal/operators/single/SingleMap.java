package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleMap<T, R> extends Single<R> {
    public final Single c;
    public final Function d;

    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        public final SingleObserver c;
        public final Function d;

        public MapSingleObserver(SingleObserver singleObserver, Function function) {
            this.c = singleObserver;
            this.d = function;
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.c.onSubscribe(disposable);
        }

        public final void onSuccess(Object obj) {
            try {
                Object apply = this.d.apply(obj);
                ObjectHelper.b(apply, "The mapper function returned a null value.");
                this.c.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.a(th);
                onError(th);
            }
        }
    }

    public SingleMap(Single single, Function function) {
        this.c = single;
        this.d = function;
    }

    public final void c(SingleObserver singleObserver) {
        this.c.b(new MapSingleObserver(singleObserver, this.d));
    }
}
