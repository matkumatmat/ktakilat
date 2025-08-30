package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
    public final int d;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;
        public final Observer c;
        public final int d;
        public Disposable e;

        public SkipLastObserver(Observer observer, int i) {
            super(i);
            this.c = observer;
            this.d = i;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.d == size()) {
                this.c.onNext(poll());
            }
            offer(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(Observable observable, int i) {
        super(observable);
        this.d = i;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new SkipLastObserver(observer, this.d));
    }
}
