package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;
    public final ErrorMode e;
    public final int f;
    public final int g;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        public final Observer c;
        public final Function d;
        public final int e;
        public final int f;
        public final ErrorMode g;
        public final AtomicThrowable i = new AtomicThrowable();
        public final ArrayDeque j = new ArrayDeque();
        public SimpleQueue k;
        public Disposable l;
        public volatile boolean m;
        public int n;
        public volatile boolean o;
        public InnerQueuedObserver p;
        public int q;

        public ConcatMapEagerMainObserver(Observer observer, Function function, int i2, int i3, ErrorMode errorMode) {
            this.c = observer;
            this.d = function;
            this.e = i2;
            this.f = i3;
            this.g = errorMode;
        }

        public final void a() {
            InnerQueuedObserver innerQueuedObserver = this.p;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver innerQueuedObserver2 = (InnerQueuedObserver) this.j.poll();
                if (innerQueuedObserver2 != null) {
                    innerQueuedObserver2.dispose();
                } else {
                    return;
                }
            }
        }

        public final void b() {
            boolean z;
            boolean z2;
            if (getAndIncrement() == 0) {
                SimpleQueue simpleQueue = this.k;
                ArrayDeque arrayDeque = this.j;
                Observer observer = this.c;
                ErrorMode errorMode = this.g;
                int i2 = 1;
                while (true) {
                    int i3 = this.q;
                    while (true) {
                        if (i3 == this.e) {
                            break;
                        } else if (this.o) {
                            simpleQueue.clear();
                            a();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.i.get()) == null) {
                            try {
                                Object poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                Object apply = this.d.apply(poll);
                                ObjectHelper.b(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i3++;
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                this.l.dispose();
                                simpleQueue.clear();
                                a();
                                this.i.addThrowable(th);
                                observer.onError(this.i.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            a();
                            observer.onError(this.i.terminate());
                            return;
                        }
                    }
                    this.q = i3;
                    if (this.o) {
                        simpleQueue.clear();
                        a();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.i.get()) == null) {
                        InnerQueuedObserver innerQueuedObserver2 = this.p;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.i.get()) == null) {
                                boolean z3 = this.m;
                                InnerQueuedObserver innerQueuedObserver3 = (InnerQueuedObserver) arrayDeque.poll();
                                if (innerQueuedObserver3 == null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z3 || !z2) {
                                    if (!z2) {
                                        this.p = innerQueuedObserver3;
                                    }
                                    innerQueuedObserver2 = innerQueuedObserver3;
                                } else if (((Throwable) this.i.get()) != null) {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.i.terminate());
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                a();
                                observer.onError(this.i.terminate());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue queue = innerQueuedObserver2.queue();
                            while (!this.o) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.i.get()) == null) {
                                    try {
                                        Object poll2 = queue.poll();
                                        if (poll2 == null) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (isDone && z) {
                                            this.p = null;
                                            this.q--;
                                        } else if (!z) {
                                            observer.onNext(poll2);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.a(th2);
                                        this.i.addThrowable(th2);
                                        this.p = null;
                                        this.q--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.i.terminate());
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            a();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        a();
                        observer.onError(this.i.terminate());
                        return;
                    }
                }
            }
        }

        public final void c(InnerQueuedObserver innerQueuedObserver, Throwable th) {
            if (this.i.addThrowable(th)) {
                if (this.g == ErrorMode.IMMEDIATE) {
                    this.l.dispose();
                }
                innerQueuedObserver.setDone();
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void d(InnerQueuedObserver innerQueuedObserver) {
            innerQueuedObserver.setDone();
            b();
        }

        public final void dispose() {
            this.o = true;
            if (getAndIncrement() == 0) {
                this.k.clear();
                a();
            }
        }

        public final void e(InnerQueuedObserver innerQueuedObserver, Object obj) {
            innerQueuedObserver.queue().offer(obj);
            b();
        }

        public final boolean isDisposed() {
            return this.o;
        }

        public final void onComplete() {
            this.m = true;
            b();
        }

        public final void onError(Throwable th) {
            if (this.i.addThrowable(th)) {
                this.m = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.n == 0) {
                this.k.offer(obj);
            }
            b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.l, disposable)) {
                this.l = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.n = requestFusion;
                        this.k = queueDisposable;
                        this.m = true;
                        this.c.onSubscribe(this);
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.n = requestFusion;
                        this.k = queueDisposable;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.k = new SpscLinkedArrayQueue(this.f);
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(Observable observable, Function function, ErrorMode errorMode, int i, int i2) {
        super(observable);
        this.d = function;
        this.e = errorMode;
        this.f = i;
        this.g = i2;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new ConcatMapEagerMainObserver(observer, this.d, this.f, this.g, this.e));
    }
}
