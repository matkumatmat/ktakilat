package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
    public final int d;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;
        public final Observer c;
        public final int d;
        public Disposable e;
        public volatile boolean f;

        public TakeLastObserver(Observer observer, int i) {
            this.c = observer;
            this.d = i;
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                this.e.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            Observer observer = this.c;
            while (!this.f) {
                Object poll = poll();
                if (poll != null) {
                    observer.onNext(poll);
                } else if (!this.f) {
                    observer.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.d == size()) {
                poll();
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

    public ObservableTakeLast(Observable observable, int i) {
        super(observable);
        this.d = i;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new TakeLastObserver(observer, this.d));
    }
}
