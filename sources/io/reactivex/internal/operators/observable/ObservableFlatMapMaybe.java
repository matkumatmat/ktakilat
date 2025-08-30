package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;
    public final boolean e;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        public final Observer c;
        public final boolean d;
        public final CompositeDisposable e = new Object();
        public final AtomicInteger f = new AtomicInteger(1);
        public final AtomicThrowable g = new AtomicThrowable();
        public final Function i;
        public final AtomicReference j = new AtomicReference();
        public Disposable k;
        public volatile boolean l;

        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onComplete() {
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                flatMapMaybeObserver.e.c(this);
                int i = flatMapMaybeObserver.get();
                AtomicInteger atomicInteger = flatMapMaybeObserver.f;
                if (i == 0) {
                    boolean z = false;
                    if (flatMapMaybeObserver.compareAndSet(0, 1)) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) flatMapMaybeObserver.j.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = flatMapMaybeObserver.g.terminate();
                            Observer observer = flatMapMaybeObserver.c;
                            if (terminate != null) {
                                observer.onError(terminate);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else if (flatMapMaybeObserver.decrementAndGet() != 0) {
                            flatMapMaybeObserver.a();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                atomicInteger.decrementAndGet();
                if (flatMapMaybeObserver.getAndIncrement() == 0) {
                    flatMapMaybeObserver.a();
                }
            }

            public final void onError(Throwable th) {
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                CompositeDisposable compositeDisposable = flatMapMaybeObserver.e;
                compositeDisposable.c(this);
                if (flatMapMaybeObserver.g.addThrowable(th)) {
                    if (!flatMapMaybeObserver.d) {
                        flatMapMaybeObserver.k.dispose();
                        compositeDisposable.dispose();
                    }
                    flatMapMaybeObserver.f.decrementAndGet();
                    if (flatMapMaybeObserver.getAndIncrement() == 0) {
                        flatMapMaybeObserver.a();
                        return;
                    }
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                SpscLinkedArrayQueue spscLinkedArrayQueue;
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                flatMapMaybeObserver.e.c(this);
                if (flatMapMaybeObserver.get() == 0) {
                    boolean z = false;
                    if (flatMapMaybeObserver.compareAndSet(0, 1)) {
                        flatMapMaybeObserver.c.onNext(obj);
                        if (flatMapMaybeObserver.f.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) flatMapMaybeObserver.j.get();
                        if (!z || (spscLinkedArrayQueue2 != null && !spscLinkedArrayQueue2.isEmpty())) {
                            if (flatMapMaybeObserver.decrementAndGet() == 0) {
                                return;
                            }
                            flatMapMaybeObserver.a();
                        }
                        Throwable terminate = flatMapMaybeObserver.g.terminate();
                        if (terminate != null) {
                            flatMapMaybeObserver.c.onError(terminate);
                            return;
                        } else {
                            flatMapMaybeObserver.c.onComplete();
                            return;
                        }
                    }
                }
                loop0:
                while (true) {
                    AtomicReference atomicReference = flatMapMaybeObserver.j;
                    spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                    if (spscLinkedArrayQueue != null) {
                        break;
                    }
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                    while (true) {
                        if (atomicReference.compareAndSet((Object) null, spscLinkedArrayQueue)) {
                            break loop0;
                        } else if (atomicReference.get() != null) {
                        }
                    }
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue3 = spscLinkedArrayQueue;
                synchronized (spscLinkedArrayQueue3) {
                    spscLinkedArrayQueue3.offer(obj);
                }
                flatMapMaybeObserver.f.decrementAndGet();
                if (flatMapMaybeObserver.getAndIncrement() != 0) {
                    return;
                }
                flatMapMaybeObserver.a();
            }
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public FlatMapMaybeObserver(Observer observer, Function function, boolean z) {
            this.c = observer;
            this.i = function;
            this.d = z;
        }

        public final void a() {
            boolean z;
            Object obj;
            Observer observer = this.c;
            AtomicInteger atomicInteger = this.f;
            AtomicReference atomicReference = this.j;
            int i2 = 1;
            while (!this.l) {
                if (this.d || ((Throwable) this.g.get()) == null) {
                    boolean z2 = false;
                    if (atomicInteger.get() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                    if (spscLinkedArrayQueue != null) {
                        obj = spscLinkedArrayQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z2 = true;
                    }
                    if (z && z2) {
                        Throwable terminate = this.g.terminate();
                        if (terminate != null) {
                            observer.onError(terminate);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                } else {
                    Throwable terminate2 = this.g.terminate();
                    SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) this.j.get();
                    if (spscLinkedArrayQueue2 != null) {
                        spscLinkedArrayQueue2.clear();
                    }
                    observer.onError(terminate2);
                    return;
                }
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue3 = (SpscLinkedArrayQueue) this.j.get();
            if (spscLinkedArrayQueue3 != null) {
                spscLinkedArrayQueue3.clear();
            }
        }

        public final void dispose() {
            this.l = true;
            this.k.dispose();
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.l;
        }

        public final void onComplete() {
            this.f.decrementAndGet();
            if (getAndIncrement() == 0) {
                a();
            }
        }

        public final void onError(Throwable th) {
            this.f.decrementAndGet();
            if (this.g.addThrowable(th)) {
                if (!this.d) {
                    this.e.dispose();
                }
                if (getAndIncrement() == 0) {
                    a();
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            try {
                Object apply = this.i.apply(obj);
                ObjectHelper.b(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.f.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.l && this.e.b(innerObserver)) {
                    maybeSource.b(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.k.dispose();
                onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(Observable observable, Function function, boolean z) {
        super(observable);
        this.d = function;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new FlatMapMaybeObserver(observer, this.d, this.e));
    }
}
