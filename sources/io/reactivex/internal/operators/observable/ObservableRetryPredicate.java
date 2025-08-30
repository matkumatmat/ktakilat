package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate d;
    public final long e;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Observer c;
        public final SequentialDisposable d;
        public final ObservableSource e;
        public final Predicate f;
        public long g;

        public RepeatObserver(Observer observer, long j, Predicate predicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.c = observer;
            this.d = sequentialDisposable;
            this.e = observableSource;
            this.f = predicate;
            this.g = j;
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
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            long j = this.g;
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g = j - 1;
            }
            Observer observer = this.c;
            if (j == 0) {
                observer.onError(th);
                return;
            }
            try {
                if (!this.f.test(th)) {
                    observer.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.a(th2);
                observer.onError(new CompositeException(th, th2));
            }
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            this.d.update(disposable);
        }
    }

    public ObservableRetryPredicate(Observable observable, long j, Predicate predicate) {
        super(observable);
        this.d = predicate;
        this.e = j;
    }

    public final void subscribeActual(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        Observer observer2 = observer;
        new RepeatObserver(observer2, this.e, this.d, sequentialDisposable, this.c).a();
    }
}
