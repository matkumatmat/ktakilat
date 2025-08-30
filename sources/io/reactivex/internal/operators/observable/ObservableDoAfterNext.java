package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

@Experimental
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
    public final Consumer d;

    public static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
        public final Consumer i;

        public DoAfterObserver(Observer observer, Consumer consumer) {
            super(observer);
            this.i = consumer;
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
            if (this.g == 0) {
                try {
                    this.i.accept(obj);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            Object poll = this.e.poll();
            if (poll != null) {
                this.i.accept(poll);
            }
            return poll;
        }
    }

    public ObservableDoAfterNext(Observable observable, Consumer consumer) {
        super(observable);
        this.d = consumer;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DoAfterObserver(observer, this.d));
    }
}
