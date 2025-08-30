package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {
    public final Observable c;
    public final Callable d;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public Collection d;
        public Disposable e;

        public ToListObserver(SingleObserver singleObserver, Collection collection) {
            this.c = singleObserver;
            this.d = collection;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            Collection collection = this.d;
            this.d = null;
            this.c.onSuccess(collection);
        }

        public final void onError(Throwable th) {
            this.d = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.d.add(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(Observable observable, int i) {
        this.c = observable;
        this.d = Functions.c(i);
    }

    public final Observable a() {
        return new ObservableToList(this.c, this.d);
    }

    public final void c(SingleObserver singleObserver) {
        try {
            Object call = this.d.call();
            ObjectHelper.b(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.c.subscribe(new ToListObserver(singleObserver, (Collection) call));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    public ObservableToListSingle(Observable observable, Callable callable) {
        this.c = observable;
        this.d = callable;
    }
}
