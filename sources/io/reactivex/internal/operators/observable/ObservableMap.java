package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final Function d;

    public static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        public final Function i;

        public MapObserver(Observer observer, Function function) {
            super(observer);
            this.i = function;
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                int i2 = this.g;
                Observer observer = this.c;
                if (i2 != 0) {
                    observer.onNext((Object) null);
                    return;
                }
                try {
                    Object apply = this.i.apply(obj);
                    ObjectHelper.b(apply, "The mapper function returned a null value.");
                    observer.onNext(apply);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            Object poll = this.e.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.i.apply(poll);
            ObjectHelper.b(apply, "The mapper function returned a null value.");
            return apply;
        }
    }

    public ObservableMap(ObservableSource observableSource, Function function) {
        super(observableSource);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new MapObserver(observer, this.d));
    }
}
