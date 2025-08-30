package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
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
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final Function d;
    public final int e;
    public final ErrorMode f;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        public final Observer c;
        public final Function d;
        public final int e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final DelayErrorInnerObserver g;
        public final boolean i;
        public SimpleQueue j;
        public Disposable k;
        public volatile boolean l;
        public volatile boolean m;
        public volatile boolean n;
        public int o;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            public final Observer c;
            public final ConcatMapDelayErrorObserver d;

            public DelayErrorInnerObserver(Observer observer, ConcatMapDelayErrorObserver concatMapDelayErrorObserver) {
                this.c = observer;
                this.d = concatMapDelayErrorObserver;
            }

            public final void onComplete() {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.d;
                concatMapDelayErrorObserver.l = false;
                concatMapDelayErrorObserver.a();
            }

            public final void onError(Throwable th) {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.d;
                if (concatMapDelayErrorObserver.f.addThrowable(th)) {
                    if (!concatMapDelayErrorObserver.i) {
                        concatMapDelayErrorObserver.k.dispose();
                    }
                    concatMapDelayErrorObserver.l = false;
                    concatMapDelayErrorObserver.a();
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onNext(Object obj) {
                this.c.onNext(obj);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer observer, Function function, int i2, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = i2;
            this.i = z;
            this.g = new DelayErrorInnerObserver(observer, this);
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                SimpleQueue simpleQueue = this.j;
                AtomicThrowable atomicThrowable = this.f;
                while (true) {
                    if (!this.l) {
                        if (this.n) {
                            simpleQueue.clear();
                            return;
                        } else if (this.i || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z2 = this.m;
                            try {
                                Object poll = simpleQueue.poll();
                                if (poll == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z2 && z) {
                                    this.n = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        observer.onError(terminate);
                                        return;
                                    } else {
                                        observer.onComplete();
                                        return;
                                    }
                                } else if (!z) {
                                    try {
                                        Object apply = this.d.apply(poll);
                                        ObjectHelper.b(apply, "The mapper returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        if (observableSource instanceof Callable) {
                                            try {
                                                Object call = ((Callable) observableSource).call();
                                                if (call != null && !this.n) {
                                                    observer.onNext(call);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.a(th);
                                                atomicThrowable.addThrowable(th);
                                            }
                                        } else {
                                            this.l = true;
                                            observableSource.subscribe(this.g);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.a(th2);
                                        this.n = true;
                                        this.k.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.a(th3);
                                this.n = true;
                                this.k.dispose();
                                atomicThrowable.addThrowable(th3);
                                observer.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.n = true;
                            observer.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public final void dispose() {
            this.n = true;
            this.k.dispose();
            DelayErrorInnerObserver delayErrorInnerObserver = this.g;
            delayErrorInnerObserver.getClass();
            DisposableHelper.dispose(delayErrorInnerObserver);
        }

        public final boolean isDisposed() {
            return this.n;
        }

        public final void onComplete() {
            this.m = true;
            a();
        }

        public final void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                this.m = true;
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.o == 0) {
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
                        this.o = requestFusion;
                        this.j = queueDisposable;
                        this.m = true;
                        this.c.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.o = requestFusion;
                        this.j = queueDisposable;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.j = new SpscLinkedArrayQueue(this.e);
                this.c.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        public final SerializedObserver c;
        public final Function d;
        public final InnerObserver e;
        public final int f;
        public SimpleQueue g;
        public Disposable i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile boolean l;
        public int m;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            public final SerializedObserver c;
            public final SourceObserver d;

            public InnerObserver(SerializedObserver serializedObserver, SourceObserver sourceObserver) {
                this.c = serializedObserver;
                this.d = sourceObserver;
            }

            public final void onComplete() {
                SourceObserver sourceObserver = this.d;
                sourceObserver.j = false;
                sourceObserver.a();
            }

            public final void onError(Throwable th) {
                this.d.dispose();
                this.c.onError(th);
            }

            public final void onNext(Object obj) {
                this.c.onNext(obj);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.set(this, disposable);
            }
        }

        public SourceObserver(SerializedObserver serializedObserver, Function function, int i2) {
            this.c = serializedObserver;
            this.d = function;
            this.f = i2;
            this.e = new InnerObserver(serializedObserver, this);
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                while (!this.k) {
                    if (!this.j) {
                        boolean z2 = this.l;
                        try {
                            Object poll = this.g.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z2 && z) {
                                this.k = true;
                                this.c.onComplete();
                                return;
                            } else if (!z) {
                                try {
                                    Object apply = this.d.apply(poll);
                                    ObjectHelper.b(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    this.j = true;
                                    observableSource.subscribe(this.e);
                                } catch (Throwable th) {
                                    Exceptions.a(th);
                                    dispose();
                                    this.g.clear();
                                    this.c.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.a(th2);
                            dispose();
                            this.g.clear();
                            this.c.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.g.clear();
            }
        }

        public final void dispose() {
            this.k = true;
            InnerObserver innerObserver = this.e;
            innerObserver.getClass();
            DisposableHelper.dispose(innerObserver);
            this.i.dispose();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        public final boolean isDisposed() {
            return this.k;
        }

        public final void onComplete() {
            if (!this.l) {
                this.l = true;
                a();
            }
        }

        public final void onError(Throwable th) {
            if (this.l) {
                RxJavaPlugins.b(th);
                return;
            }
            this.l = true;
            dispose();
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.l) {
                if (this.m == 0) {
                    this.g.offer(obj);
                }
                a();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.g = queueDisposable;
                        this.l = true;
                        this.c.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.g = queueDisposable;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.g = new SpscLinkedArrayQueue(this.f);
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource observableSource, Function function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.d = function;
        this.f = errorMode;
        this.e = Math.max(8, i);
    }

    public final void subscribeActual(Observer observer) {
        boolean z;
        ObservableSource observableSource = this.c;
        Function function = this.d;
        if (!ObservableScalarXMap.b(observableSource, observer, function)) {
            ErrorMode errorMode = ErrorMode.IMMEDIATE;
            int i = this.e;
            ErrorMode errorMode2 = this.f;
            if (errorMode2 == errorMode) {
                observableSource.subscribe(new SourceObserver(new SerializedObserver(observer), function, i));
                return;
            }
            if (errorMode2 == ErrorMode.END) {
                z = true;
            } else {
                z = false;
            }
            observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i, z));
        }
    }
}
