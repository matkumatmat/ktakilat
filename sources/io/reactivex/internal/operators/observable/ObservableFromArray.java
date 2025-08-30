package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T> extends Observable<T> {
    public final Object[] c;

    public static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        public final Observer c;
        public final Object[] d;
        public int e;
        public boolean f;
        public volatile boolean g;

        public FromArrayDisposable(Observer observer, Object[] objArr) {
            this.c = observer;
            this.d = objArr;
        }

        public final void clear() {
            this.e = this.d.length;
        }

        public final void dispose() {
            this.g = true;
        }

        public final boolean isDisposed() {
            return this.g;
        }

        public final boolean isEmpty() {
            if (this.e == this.d.length) {
                return true;
            }
            return false;
        }

        public final Object poll() {
            int i = this.e;
            Object[] objArr = this.d;
            if (i == objArr.length) {
                return null;
            }
            this.e = i + 1;
            Object obj = objArr[i];
            ObjectHelper.b(obj, "The array element is null");
            return obj;
        }

        public final int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f = true;
            return 1;
        }
    }

    public ObservableFromArray(Object[] objArr) {
        this.c = objArr;
    }

    public final void subscribeActual(Observer observer) {
        Object[] objArr = this.c;
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, objArr);
        observer.onSubscribe(fromArrayDisposable);
        if (!fromArrayDisposable.f) {
            int length = objArr.length;
            int i = 0;
            while (i < length && !fromArrayDisposable.g) {
                Object obj = objArr[i];
                if (obj == null) {
                    fromArrayDisposable.c.onError(new NullPointerException(ba.l(i, "The ", "th element is null")));
                    return;
                } else {
                    fromArrayDisposable.c.onNext(obj);
                    i++;
                }
            }
            if (!fromArrayDisposable.g) {
                fromArrayDisposable.c.onComplete();
            }
        }
    }
}
