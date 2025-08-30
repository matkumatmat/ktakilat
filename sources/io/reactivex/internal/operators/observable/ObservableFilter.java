package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate d;

    public static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        public final Predicate i;

        public FilterObserver(Observer observer, Predicate predicate) {
            super(observer);
            this.i = predicate;
        }

        public final void onNext(Object obj) {
            int i2 = this.g;
            Observer observer = this.c;
            if (i2 == 0) {
                try {
                    if (this.i.test(obj)) {
                        observer.onNext(obj);
                    }
                } catch (Throwable th) {
                    a(th);
                }
            } else {
                observer.onNext((Object) null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final java.lang.Object poll() {
            /*
                r2 = this;
            L_0x0000:
                io.reactivex.internal.fuseable.QueueDisposable r0 = r2.e
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.functions.Predicate r1 = r2.i
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFilter.FilterObserver.poll():java.lang.Object");
        }
    }

    public ObservableFilter(Observable observable, Predicate predicate) {
        super(observable);
        this.d = predicate;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new FilterObserver(observer, this.d));
    }
}
