package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
    public final BooleanSupplier d;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Observer c;
        public final SequentialDisposable d;
        public final ObservableSource e;
        public final BooleanSupplier f;

        public RepeatUntilObserver(Observer observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.c = observer;
            this.d = sequentialDisposable;
            this.e = observableSource;
            this.f = booleanSupplier;
        }

        public final void onComplete() {
            Observer observer = this.c;
            try {
                if (this.f.getAsBoolean()) {
                    observer.onComplete();
                } else if (getAndIncrement() == 0) {
                    int i = 1;
                    do {
                        this.e.subscribe(this);
                        i = addAndGet(-i);
                    } while (i != 0);
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                observer.onError(th);
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

    public ObservableRepeatUntil(Observable observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.d = booleanSupplier;
    }

    public final void subscribeActual(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        RepeatUntilObserver repeatUntilObserver = new RepeatUntilObserver(observer, this.d, sequentialDisposable, this.c);
        if (repeatUntilObserver.getAndIncrement() == 0) {
            int i = 1;
            do {
                repeatUntilObserver.e.subscribe(repeatUntilObserver);
                i = repeatUntilObserver.addAndGet(-i);
            } while (i != 0);
        }
    }
}
