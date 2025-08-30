package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Observer c;
        public final SequentialDisposable d;
        public final ObservableSource e;
        public long f;

        public RepeatObserver(Observer observer, long j, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.c = observer;
            this.d = sequentialDisposable;
            this.e = observableSource;
            this.f = j;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.d.isDisposed()) {
                    this.e.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public final void onComplete() {
            long j = this.f;
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f = j - 1;
            }
            if (j != 0) {
                a();
            } else {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }
    }

    public ObservableRepeat(Observable observable, long j) {
        super(observable);
        this.d = j;
    }

    public final void subscribeActual(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j = this.d;
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j - 1;
        }
        new RepeatObserver(observer, j2, sequentialDisposable, this.c).a();
    }
}
