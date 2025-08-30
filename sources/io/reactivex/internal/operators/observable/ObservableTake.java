package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;

    public static final class TakeObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public boolean d;
        public Disposable e;
        public long f;

        public TakeObserver(Observer observer, long j) {
            this.c = observer;
            this.f = j;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                this.e.dispose();
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            this.d = true;
            this.e.dispose();
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            boolean z;
            if (!this.d) {
                long j = this.f;
                long j2 = j - 1;
                this.f = j2;
                if (j > 0) {
                    if (j2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.c.onNext(obj);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                long j = this.f;
                Observer observer = this.c;
                if (j == 0) {
                    this.d = true;
                    disposable.dispose();
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                observer.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource observableSource, long j) {
        super(observableSource);
        this.d = j;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new TakeObserver(observer, this.d));
    }
}
