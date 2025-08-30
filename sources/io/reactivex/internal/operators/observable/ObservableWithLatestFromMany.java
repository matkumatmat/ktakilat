package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final ObservableSource[] d;
    public final Iterable e;
    public final Function f;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public final Object apply(Object obj) {
            Object apply = ObservableWithLatestFromMany.this.f.apply(new Object[]{obj});
            ObjectHelper.b(apply, "The combiner returned a null value");
            return apply;
        }
    }

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        public final Observer c;
        public final Function d;
        public final WithLatestInnerObserver[] e;
        public final AtomicReferenceArray f;
        public final AtomicReference g;
        public final AtomicThrowable i;
        public volatile boolean j;

        public WithLatestFromObserver(Observer observer, Function function, int i2) {
            this.c = observer;
            this.d = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                withLatestInnerObserverArr[i3] = new WithLatestInnerObserver(this, i3);
            }
            this.e = withLatestInnerObserverArr;
            this.f = new AtomicReferenceArray(i2);
            this.g = new AtomicReference();
            this.i = new AtomicThrowable();
        }

        public final void a(int i2) {
            int i3 = 0;
            while (true) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.e;
                if (i3 < withLatestInnerObserverArr.length) {
                    if (i3 != i2) {
                        WithLatestInnerObserver withLatestInnerObserver = withLatestInnerObserverArr[i3];
                        withLatestInnerObserver.getClass();
                        DisposableHelper.dispose(withLatestInnerObserver);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this.g);
            for (WithLatestInnerObserver withLatestInnerObserver : this.e) {
                withLatestInnerObserver.getClass();
                DisposableHelper.dispose(withLatestInnerObserver);
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.g.get());
        }

        public final void onComplete() {
            if (!this.j) {
                this.j = true;
                a(-1);
                HalfSerializer.a(this.c, this, this.i);
            }
        }

        public final void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = true;
            a(-1);
            HalfSerializer.c(this.c, th, this, this.i);
        }

        public final void onNext(Object obj) {
            if (!this.j) {
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i2 = 0;
                objArr[0] = obj;
                while (i2 < length) {
                    Object obj2 = atomicReferenceArray.get(i2);
                    if (obj2 != null) {
                        i2++;
                        objArr[i2] = obj2;
                    } else {
                        return;
                    }
                }
                try {
                    Object apply = this.d.apply(objArr);
                    ObjectHelper.b(apply, "combiner returned a null value");
                    HalfSerializer.e(this.c, apply, this, this.i);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public final WithLatestFromObserver c;
        public final int d;
        public boolean e;

        public WithLatestInnerObserver(WithLatestFromObserver withLatestFromObserver, int i) {
            this.c = withLatestFromObserver;
            this.d = i;
        }

        public final void onComplete() {
            WithLatestFromObserver withLatestFromObserver = this.c;
            int i = this.d;
            if (!this.e) {
                withLatestFromObserver.j = true;
                withLatestFromObserver.a(i);
                HalfSerializer.a(withLatestFromObserver.c, withLatestFromObserver, withLatestFromObserver.i);
                return;
            }
            withLatestFromObserver.getClass();
        }

        public final void onError(Throwable th) {
            WithLatestFromObserver withLatestFromObserver = this.c;
            int i = this.d;
            withLatestFromObserver.j = true;
            DisposableHelper.dispose(withLatestFromObserver.g);
            withLatestFromObserver.a(i);
            HalfSerializer.c(withLatestFromObserver.c, th, withLatestFromObserver, withLatestFromObserver.i);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                this.e = true;
            }
            this.c.f.set(this.d, obj);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(Observable observable, ObservableSource[] observableSourceArr, Function function) {
        super(observable);
        this.d = observableSourceArr;
        this.e = null;
        this.f = function;
    }

    public final void subscribeActual(Observer observer) {
        int i;
        ObservableSource[] observableSourceArr = this.d;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i = 0;
                for (ObservableSource observableSource : this.e) {
                    if (i == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i >> 1) + i);
                    }
                    int i2 = i + 1;
                    observableSourceArr[i] = observableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
                return;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            new ObservableMap(this.c, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f, i);
        observer.onSubscribe(withLatestFromObserver);
        WithLatestInnerObserver[] withLatestInnerObserverArr = withLatestFromObserver.e;
        AtomicReference atomicReference = withLatestFromObserver.g;
        for (int i3 = 0; i3 < i && !DisposableHelper.isDisposed((Disposable) atomicReference.get()) && !withLatestFromObserver.j; i3++) {
            observableSourceArr[i3].subscribe(withLatestInnerObserverArr[i3]);
        }
        this.c.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(Observable observable, Iterable iterable, Function function) {
        super(observable);
        this.d = null;
        this.e = iterable;
        this.f = function;
    }
}
