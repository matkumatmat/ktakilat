package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    public final Callable d;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        public Collection c;
        public final Observer d;
        public Disposable e;

        public ToListObserver(Observer observer, Collection collection) {
            this.d = observer;
            this.c = collection;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            Collection collection = this.c;
            this.c = null;
            Observer observer = this.d;
            observer.onNext(collection);
            observer.onComplete();
        }

        public final void onError(Throwable th) {
            this.c = null;
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.add(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.d.onSubscribe(this);
            }
        }
    }

    public ObservableToList(ObservableSource observableSource) {
        super(observableSource);
        this.d = Functions.c(16);
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.d.call();
            ObjectHelper.b(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.c.subscribe(new ToListObserver(observer, (Collection) call));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }

    public ObservableToList(Observable observable, Callable callable) {
        super(observable);
        this.d = callable;
    }
}
