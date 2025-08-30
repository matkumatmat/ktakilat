package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    public final BiPredicate d;

    public static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Observer c;
        public final SequentialDisposable d;
        public final ObservableSource e;
        public final BiPredicate f;
        public int g;

        public RetryBiObserver(Observer observer, BiPredicate biPredicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.c = observer;
            this.d = sequentialDisposable;
            this.e = observableSource;
            this.f = biPredicate;
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
            Observer observer = this.c;
            try {
                BiPredicate biPredicate = this.f;
                int i = this.g + 1;
                this.g = i;
                if (!biPredicate.test(Integer.valueOf(i), th)) {
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

    public ObservableRetryBiPredicate(Observable observable, BiPredicate biPredicate) {
        super(observable);
        this.d = biPredicate;
    }

    public final void subscribeActual(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.d, sequentialDisposable, this.c).a();
    }
}
