package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;
    public final Callable e;

    public static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        public final Collection i;
        public final Function j;

        public DistinctObserver(Observer observer, Function function, Collection collection) {
            super(observer);
            this.j = function;
            this.i = collection;
        }

        public final void clear() {
            this.i.clear();
            super.clear();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                this.i.clear();
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.i.clear();
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                int i2 = this.g;
                Observer observer = this.c;
                if (i2 == 0) {
                    try {
                        Object apply = this.j.apply(obj);
                        ObjectHelper.b(apply, "The keySelector returned a null key");
                        if (this.i.add(apply)) {
                            observer.onNext(obj);
                        }
                    } catch (Throwable th) {
                        a(th);
                    }
                } else {
                    observer.onNext((Object) null);
                }
            }
        }

        public final Object poll() {
            Object poll;
            Object apply;
            do {
                poll = this.e.poll();
                if (poll == null) {
                    break;
                }
                apply = this.j.apply(poll);
                ObjectHelper.b(apply, "The keySelector returned a null key");
            } while (!this.i.add(apply));
            return poll;
        }
    }

    public ObservableDistinct(Observable observable, Function function, Callable callable) {
        super(observable);
        this.d = function;
        this.e = callable;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.e.call();
            ObjectHelper.b(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.c.subscribe(new DistinctObserver(observer, this.d, (Collection) call));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
