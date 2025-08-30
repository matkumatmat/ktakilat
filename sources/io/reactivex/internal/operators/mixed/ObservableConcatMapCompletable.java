package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class ObservableConcatMapCompletable<T> extends Completable {
    public final Observable c;
    public final Function d;
    public final ErrorMode e;
    public final int f;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        public final CompletableObserver c;
        public final Function d;
        public final ErrorMode e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final ConcatMapInnerObserver g = new ConcatMapInnerObserver(this);
        public final int i;
        public SimpleQueue j;
        public Disposable k;
        public volatile boolean l;
        public volatile boolean m;
        public volatile boolean n;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver c;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver concatMapCompletableObserver) {
                this.c = concatMapCompletableObserver;
            }

            public final void onComplete() {
                ConcatMapCompletableObserver concatMapCompletableObserver = this.c;
                concatMapCompletableObserver.l = false;
                concatMapCompletableObserver.a();
            }

            public final void onError(Throwable th) {
                ConcatMapCompletableObserver concatMapCompletableObserver = this.c;
                if (!concatMapCompletableObserver.f.addThrowable(th)) {
                    RxJavaPlugins.b(th);
                } else if (concatMapCompletableObserver.e == ErrorMode.IMMEDIATE) {
                    concatMapCompletableObserver.n = true;
                    concatMapCompletableObserver.k.dispose();
                    Throwable terminate = concatMapCompletableObserver.f.terminate();
                    if (terminate != ExceptionHelper.f682a) {
                        concatMapCompletableObserver.c.onError(terminate);
                    }
                    if (concatMapCompletableObserver.getAndIncrement() == 0) {
                        concatMapCompletableObserver.j.clear();
                    }
                } else {
                    concatMapCompletableObserver.l = false;
                    concatMapCompletableObserver.a();
                }
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function function, ErrorMode errorMode, int i2) {
            this.c = completableObserver;
            this.d = function;
            this.e = errorMode;
            this.i = i2;
        }

        public final void a() {
            boolean z;
            CompletableSource completableSource;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.f;
                ErrorMode errorMode = this.e;
                while (!this.n) {
                    if (!this.l) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z2 = this.m;
                            try {
                                Object poll = this.j.poll();
                                if (poll != null) {
                                    Object apply = this.d.apply(poll);
                                    ObjectHelper.b(apply, "The mapper returned a null CompletableSource");
                                    completableSource = (CompletableSource) apply;
                                    z = false;
                                } else {
                                    completableSource = null;
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.n = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.c.onError(terminate);
                                        return;
                                    } else {
                                        this.c.onComplete();
                                        return;
                                    }
                                } else if (!z) {
                                    this.l = true;
                                    completableSource.b(this.g);
                                }
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                this.n = true;
                                this.j.clear();
                                this.k.dispose();
                                atomicThrowable.addThrowable(th);
                                this.c.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.n = true;
                            this.j.clear();
                            this.c.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.j.clear();
            }
        }

        public final void dispose() {
            this.n = true;
            this.k.dispose();
            ConcatMapInnerObserver concatMapInnerObserver = this.g;
            concatMapInnerObserver.getClass();
            DisposableHelper.dispose(concatMapInnerObserver);
            if (getAndIncrement() == 0) {
                this.j.clear();
            }
        }

        public final boolean isDisposed() {
            return this.n;
        }

        public final void onComplete() {
            this.m = true;
            a();
        }

        public final void onError(Throwable th) {
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.b(th);
            } else if (this.e == ErrorMode.IMMEDIATE) {
                this.n = true;
                ConcatMapInnerObserver concatMapInnerObserver = this.g;
                concatMapInnerObserver.getClass();
                DisposableHelper.dispose(concatMapInnerObserver);
                Throwable terminate = this.f.terminate();
                if (terminate != ExceptionHelper.f682a) {
                    this.c.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.j.clear();
                }
            } else {
                this.m = true;
                a();
            }
        }

        public final void onNext(Object obj) {
            if (obj != null) {
                this.j.offer(obj);
            }
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = queueDisposable;
                        this.m = true;
                        this.c.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = queueDisposable;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.j = new SpscLinkedArrayQueue(this.i);
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable observable, Function function, ErrorMode errorMode, int i) {
        this.c = observable;
        this.d = function;
        this.e = errorMode;
        this.f = i;
    }

    public final void c(CompletableObserver completableObserver) {
        Observable observable = this.c;
        Function function = this.d;
        if (!ScalarXMapZHelper.a(observable, function, completableObserver)) {
            observable.subscribe(new ConcatMapCompletableObserver(completableObserver, function, this.e, this.f));
        }
    }
}
