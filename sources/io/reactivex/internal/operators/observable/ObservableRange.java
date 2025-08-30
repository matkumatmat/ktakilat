package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    public final int c;
    public final long d;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        public final Observer c;
        public final long d;
        public long e;
        public boolean f;

        public RangeDisposable(Observer observer, long j, long j2) {
            this.c = observer;
            this.e = j;
            this.d = j2;
        }

        public final void clear() {
            this.e = this.d;
            lazySet(1);
        }

        public final void dispose() {
            set(1);
        }

        public final boolean isDisposed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        public final boolean isEmpty() {
            if (this.e == this.d) {
                return true;
            }
            return false;
        }

        public final Object poll() {
            long j = this.e;
            if (j != this.d) {
                this.e = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        public final int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f = true;
            return 1;
        }
    }

    public ObservableRange(int i, int i2) {
        this.c = i;
        this.d = ((long) i) + ((long) i2);
    }

    public final void subscribeActual(Observer observer) {
        Observer observer2;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.c, this.d);
        observer.onSubscribe(rangeDisposable);
        if (!rangeDisposable.f) {
            long j = rangeDisposable.e;
            while (true) {
                long j2 = rangeDisposable.d;
                observer2 = rangeDisposable.c;
                if (j != j2 && rangeDisposable.get() == 0) {
                    observer2.onNext(Integer.valueOf((int) j));
                    j++;
                }
            }
            if (rangeDisposable.get() == 0) {
                rangeDisposable.lazySet(1);
                observer2.onComplete();
            }
        }
    }
}
