package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {
    public final ObservableSource[] c;
    public final Iterable d;

    public static final class AmbCoordinator<T> implements Disposable {
        public final Observer c;
        public final AmbInnerObserver[] d;
        public final AtomicInteger e = new AtomicInteger();

        public AmbCoordinator(Observer observer, int i) {
            this.c = observer;
            this.d = new AmbInnerObserver[i];
        }

        public final boolean a(int i) {
            AtomicInteger atomicInteger = this.e;
            int i2 = atomicInteger.get();
            int i3 = 0;
            if (i2 == 0) {
                if (!atomicInteger.compareAndSet(0, i)) {
                    return false;
                }
                AmbInnerObserver[] ambInnerObserverArr = this.d;
                int length = ambInnerObserverArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i) {
                        AmbInnerObserver ambInnerObserver = ambInnerObserverArr[i3];
                        ambInnerObserver.getClass();
                        DisposableHelper.dispose(ambInnerObserver);
                    }
                    i3 = i4;
                }
                return true;
            } else if (i2 == i) {
                return true;
            } else {
                return false;
            }
        }

        public final void dispose() {
            AtomicInteger atomicInteger = this.e;
            if (atomicInteger.get() != -1) {
                atomicInteger.lazySet(-1);
                for (AmbInnerObserver ambInnerObserver : this.d) {
                    ambInnerObserver.getClass();
                    DisposableHelper.dispose(ambInnerObserver);
                }
            }
        }

        public final boolean isDisposed() {
            if (this.e.get() == -1) {
                return true;
            }
            return false;
        }
    }

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        public final AmbCoordinator c;
        public final int d;
        public final Observer e;
        public boolean f;

        public AmbInnerObserver(AmbCoordinator ambCoordinator, int i, Observer observer) {
            this.c = ambCoordinator;
            this.d = i;
            this.e = observer;
        }

        public final void onComplete() {
            boolean z = this.f;
            Observer observer = this.e;
            if (z) {
                observer.onComplete();
            } else if (this.c.a(this.d)) {
                this.f = true;
                observer.onComplete();
            }
        }

        public final void onError(Throwable th) {
            boolean z = this.f;
            Observer observer = this.e;
            if (z) {
                observer.onError(th);
            } else if (this.c.a(this.d)) {
                this.f = true;
                observer.onError(th);
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            boolean z = this.f;
            Observer observer = this.e;
            if (z) {
                observer.onNext(obj);
            } else if (this.c.a(this.d)) {
                this.f = true;
                observer.onNext(obj);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource[] observableSourceArr, Iterable iterable) {
        this.c = observableSourceArr;
        this.d = iterable;
    }

    public final void subscribeActual(Observer observer) {
        int i;
        Observer observer2;
        ObservableSource[] observableSourceArr = this.c;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                i = 0;
                for (ObservableSource observableSource : this.d) {
                    if (observableSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (Observer<?>) observer);
                        return;
                    }
                    if (i == observableSourceArr.length) {
                        ObservableSource[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                        observableSourceArr = observableSourceArr2;
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
            EmptyDisposable.complete((Observer<?>) observer);
        } else if (i == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            AmbCoordinator ambCoordinator = new AmbCoordinator(observer, i);
            AmbInnerObserver[] ambInnerObserverArr = ambCoordinator.d;
            int length = ambInnerObserverArr.length;
            int i3 = 0;
            while (true) {
                observer2 = ambCoordinator.c;
                if (i3 >= length) {
                    break;
                }
                int i4 = i3 + 1;
                ambInnerObserverArr[i3] = new AmbInnerObserver(ambCoordinator, i4, observer2);
                i3 = i4;
            }
            AtomicInteger atomicInteger = ambCoordinator.e;
            atomicInteger.lazySet(0);
            observer2.onSubscribe(ambCoordinator);
            for (int i5 = 0; i5 < length && atomicInteger.get() == 0; i5++) {
                observableSourceArr[i5].subscribe(ambInnerObserverArr[i5]);
            }
        }
    }
}
