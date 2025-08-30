package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {
    public final Observable c;
    public final Function d;
    public final ErrorMode e;
    public final int f;

    public static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;
        public final Observer c;
        public final Function d;
        public final AtomicThrowable e = new AtomicThrowable();
        public final ConcatMapMaybeObserver f = new ConcatMapMaybeObserver(this);
        public final SpscLinkedArrayQueue g;
        public final ErrorMode i;
        public Disposable j;
        public volatile boolean k;
        public volatile boolean l;
        public Object m;
        public volatile int n;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeMainObserver c;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver concatMapMaybeMainObserver) {
                this.c = concatMapMaybeMainObserver;
            }

            public final void onComplete() {
                ConcatMapMaybeMainObserver concatMapMaybeMainObserver = this.c;
                concatMapMaybeMainObserver.n = 0;
                concatMapMaybeMainObserver.a();
            }

            public final void onError(Throwable th) {
                ConcatMapMaybeMainObserver concatMapMaybeMainObserver = this.c;
                if (concatMapMaybeMainObserver.e.addThrowable(th)) {
                    if (concatMapMaybeMainObserver.i != ErrorMode.END) {
                        concatMapMaybeMainObserver.j.dispose();
                    }
                    concatMapMaybeMainObserver.n = 0;
                    concatMapMaybeMainObserver.a();
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public final void onSuccess(Object obj) {
                ConcatMapMaybeMainObserver concatMapMaybeMainObserver = this.c;
                concatMapMaybeMainObserver.m = obj;
                concatMapMaybeMainObserver.n = 2;
                concatMapMaybeMainObserver.a();
            }
        }

        public ConcatMapMaybeMainObserver(Observer observer, Function function, int i2, ErrorMode errorMode) {
            this.c = observer;
            this.d = function;
            this.i = errorMode;
            this.g = new SpscLinkedArrayQueue(i2);
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                ErrorMode errorMode = this.i;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.g;
                AtomicThrowable atomicThrowable = this.e;
                int i2 = 1;
                while (true) {
                    if (this.l) {
                        spscLinkedArrayQueue.clear();
                        this.m = null;
                    } else {
                        int i3 = this.n;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.k;
                                Object poll = spscLinkedArrayQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z) {
                                    try {
                                        Object apply = this.d.apply(poll);
                                        ObjectHelper.b(apply, "The mapper returned a null MaybeSource");
                                        MaybeSource maybeSource = (MaybeSource) apply;
                                        this.n = 1;
                                        maybeSource.b(this.f);
                                    } catch (Throwable th) {
                                        Exceptions.a(th);
                                        this.j.dispose();
                                        spscLinkedArrayQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                Object obj = this.m;
                                this.m = null;
                                observer.onNext(obj);
                                this.n = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                this.m = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        public final void dispose() {
            this.l = true;
            this.j.dispose();
            ConcatMapMaybeObserver concatMapMaybeObserver = this.f;
            concatMapMaybeObserver.getClass();
            DisposableHelper.dispose(concatMapMaybeObserver);
            if (getAndIncrement() == 0) {
                this.g.clear();
                this.m = null;
            }
        }

        public final boolean isDisposed() {
            return this.l;
        }

        public final void onComplete() {
            this.k = true;
            a();
        }

        public final void onError(Throwable th) {
            if (this.e.addThrowable(th)) {
                if (this.i == ErrorMode.IMMEDIATE) {
                    ConcatMapMaybeObserver concatMapMaybeObserver = this.f;
                    concatMapMaybeObserver.getClass();
                    DisposableHelper.dispose(concatMapMaybeObserver);
                }
                this.k = true;
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.g.offer(obj);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(Observable observable, Function function, ErrorMode errorMode, int i) {
        this.c = observable;
        this.d = function;
        this.e = errorMode;
        this.f = i;
    }

    public final void subscribeActual(Observer observer) {
        Observable observable = this.c;
        Function function = this.d;
        if (!ScalarXMapZHelper.b(observable, function, observer)) {
            observable.subscribe(new ConcatMapMaybeMainObserver(observer, function, this.f, this.e));
        }
    }
}
