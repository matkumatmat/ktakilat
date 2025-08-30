package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;
    public final BiPredicate e;

    public static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        public final Function i;
        public final BiPredicate j;
        public Object k;
        public boolean l;

        public DistinctUntilChangedObserver(Observer observer, Function function, BiPredicate biPredicate) {
            super(observer);
            this.i = function;
            this.j = biPredicate;
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                int i2 = this.g;
                Observer observer = this.c;
                if (i2 != 0) {
                    observer.onNext(obj);
                    return;
                }
                try {
                    Object apply = this.i.apply(obj);
                    if (this.l) {
                        boolean test = this.j.test(this.k, apply);
                        this.k = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.l = true;
                        this.k = apply;
                    }
                    observer.onNext(obj);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            while (true) {
                Object poll = this.e.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.i.apply(poll);
                if (!this.l) {
                    this.l = true;
                    this.k = apply;
                    return poll;
                } else if (!this.j.test(this.k, apply)) {
                    this.k = apply;
                    return poll;
                } else {
                    this.k = apply;
                }
            }
        }
    }

    public ObservableDistinctUntilChanged(Observable observable, Function function, BiPredicate biPredicate) {
        super(observable);
        this.d = function;
        this.e = biPredicate;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DistinctUntilChangedObserver(observer, this.d, this.e));
    }
}
