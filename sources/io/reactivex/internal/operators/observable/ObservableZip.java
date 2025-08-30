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
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {
    public final ObservableSource[] c;
    public final Iterable d;
    public final Function e;
    public final int f;
    public final boolean g;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        public final Observer c;
        public final Function d;
        public final ZipObserver[] e;
        public final Object[] f;
        public final boolean g;
        public volatile boolean i;

        public ZipCoordinator(Observer observer, Function function, int i2, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = new ZipObserver[i2];
            this.f = new Object[i2];
            this.g = z;
        }

        public final void a() {
            ZipObserver[] zipObserverArr = this.e;
            for (ZipObserver zipObserver : zipObserverArr) {
                zipObserver.d.clear();
            }
            for (ZipObserver zipObserver2 : zipObserverArr) {
                DisposableHelper.dispose(zipObserver2.g);
            }
        }

        public final void b() {
            Throwable th;
            boolean z;
            if (getAndIncrement() == 0) {
                ZipObserver[] zipObserverArr = this.e;
                Observer observer = this.c;
                Object[] objArr = this.f;
                boolean z2 = this.g;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int i4 = 0;
                    for (ZipObserver zipObserver : zipObserverArr) {
                        if (objArr[i4] == null) {
                            boolean z3 = zipObserver.e;
                            Object poll = zipObserver.d.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (this.i) {
                                a();
                                return;
                            }
                            if (z3) {
                                if (!z2) {
                                    Throwable th2 = zipObserver.f;
                                    if (th2 != null) {
                                        a();
                                        observer.onError(th2);
                                        return;
                                    } else if (z) {
                                        a();
                                        observer.onComplete();
                                        return;
                                    }
                                } else if (z) {
                                    Throwable th3 = zipObserver.f;
                                    a();
                                    if (th3 != null) {
                                        observer.onError(th3);
                                        return;
                                    } else {
                                        observer.onComplete();
                                        return;
                                    }
                                }
                            }
                            if (!z) {
                                objArr[i4] = poll;
                            } else {
                                i3++;
                            }
                        } else if (zipObserver.e && !z2 && (th = zipObserver.f) != null) {
                            a();
                            observer.onError(th);
                            return;
                        }
                        i4++;
                    }
                    if (i3 != 0) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object apply = this.d.apply(objArr.clone());
                            ObjectHelper.b(apply, "The zipper returned a null value");
                            observer.onNext(apply);
                            Arrays.fill(objArr, (Object) null);
                        } catch (Throwable th4) {
                            Exceptions.a(th4);
                            a();
                            observer.onError(th4);
                            return;
                        }
                    }
                }
            }
        }

        public final void dispose() {
            if (!this.i) {
                this.i = true;
                for (ZipObserver zipObserver : this.e) {
                    DisposableHelper.dispose(zipObserver.g);
                }
                if (getAndIncrement() == 0) {
                    for (ZipObserver zipObserver2 : this.e) {
                        zipObserver2.d.clear();
                    }
                }
            }
        }

        public final boolean isDisposed() {
            return this.i;
        }
    }

    public static final class ZipObserver<T, R> implements Observer<T> {
        public final ZipCoordinator c;
        public final SpscLinkedArrayQueue d;
        public volatile boolean e;
        public Throwable f;
        public final AtomicReference g = new AtomicReference();

        public ZipObserver(ZipCoordinator zipCoordinator, int i) {
            this.c = zipCoordinator;
            this.d = new SpscLinkedArrayQueue(i);
        }

        public final void onComplete() {
            this.e = true;
            this.c.b();
        }

        public final void onError(Throwable th) {
            this.f = th;
            this.e = true;
            this.c.b();
        }

        public final void onNext(Object obj) {
            this.d.offer(obj);
            this.c.b();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }
    }

    public ObservableZip(ObservableSource[] observableSourceArr, Iterable iterable, Function function, int i, boolean z) {
        this.c = observableSourceArr;
        this.d = iterable;
        this.e = function;
        this.f = i;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        int i;
        ObservableSource[] observableSourceArr = this.c;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i = 0;
            for (ObservableSource observableSource : this.d) {
                if (i == observableSourceArr.length) {
                    ObservableSource[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i] = observableSource;
                i++;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(observer, this.e, i, this.g);
        int i2 = this.f;
        ZipObserver[] zipObserverArr = zipCoordinator.e;
        int length = zipObserverArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            zipObserverArr[i3] = new ZipObserver(zipCoordinator, i2);
        }
        zipCoordinator.lazySet(0);
        zipCoordinator.c.onSubscribe(zipCoordinator);
        for (int i4 = 0; i4 < length && !zipCoordinator.i; i4++) {
            observableSourceArr[i4].subscribe(zipObserverArr[i4]);
        }
    }
}
