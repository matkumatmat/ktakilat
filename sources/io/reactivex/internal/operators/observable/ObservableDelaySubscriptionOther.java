package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    public final Observable c;
    public final ObservableSource d;

    public final class DelayObserver implements Observer<U> {
        public final SequentialDisposable c;
        public final Observer d;
        public boolean e;

        public final class OnComplete implements Observer<T> {
            public OnComplete() {
            }

            public final void onComplete() {
                DelayObserver.this.d.onComplete();
            }

            public final void onError(Throwable th) {
                DelayObserver.this.d.onError(th);
            }

            public final void onNext(Object obj) {
                DelayObserver.this.d.onNext(obj);
            }

            public final void onSubscribe(Disposable disposable) {
                DelayObserver.this.c.update(disposable);
            }
        }

        public DelayObserver(SequentialDisposable sequentialDisposable, Observer observer) {
            this.c = sequentialDisposable;
            this.d = observer;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                ObservableDelaySubscriptionOther.this.c.subscribe(new OnComplete());
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            onComplete();
        }

        public final void onSubscribe(Disposable disposable) {
            this.c.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(Observable observable, ObservableSource observableSource) {
        this.c = observable;
        this.d = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.d.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
