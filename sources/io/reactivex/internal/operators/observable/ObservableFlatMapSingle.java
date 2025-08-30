package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;
    public final boolean e;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
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

        public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onError(Throwable th) {
                FlatMapSingleObserver flatMapSingleObserver = FlatMapSingleObserver.this;
                CompositeDisposable compositeDisposable = flatMapSingleObserver.e;
                compositeDisposable.c(this);
                if (flatMapSingleObserver.g.addThrowable(th)) {
                    if (!flatMapSingleObserver.d) {
                        flatMapSingleObserver.k.dispose();
                        compositeDisposable.dispose();
                    }
                    flatMapSingleObserver.f.decrementAndGet();
                    if (flatMapSingleObserver.getAndIncrement() == 0) {
                        flatMapSingleObserver.a();
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
                FlatMapSingleObserver flatMapSingleObserver = FlatMapSingleObserver.this;
                flatMapSingleObserver.e.c(this);
                if (flatMapSingleObserver.get() == 0) {
                    boolean z = false;
                    if (flatMapSingleObserver.compareAndSet(0, 1)) {
                        flatMapSingleObserver.c.onNext(obj);
                        if (flatMapSingleObserver.f.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) flatMapSingleObserver.j.get();
                        if (!z || (spscLinkedArrayQueue2 != null && !spscLinkedArrayQueue2.isEmpty())) {
                            if (flatMapSingleObserver.decrementAndGet() == 0) {
                                return;
                            }
                            flatMapSingleObserver.a();
                        }
                        Throwable terminate = flatMapSingleObserver.g.terminate();
                        if (terminate != null) {
                            flatMapSingleObserver.c.onError(terminate);
                            return;
                        } else {
                            flatMapSingleObserver.c.onComplete();
                            return;
                        }
                    }
                }
                loop0:
                while (true) {
                    AtomicReference atomicReference = flatMapSingleObserver.j;
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
                flatMapSingleObserver.f.decrementAndGet();
                if (flatMapSingleObserver.getAndIncrement() != 0) {
                    return;
                }
                flatMapSingleObserver.a();
            }
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public FlatMapSingleObserver(Observer observer, Function function, boolean z) {
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
                ObjectHelper.b(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                this.f.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.l && this.e.b(innerObserver)) {
                    singleSource.b(innerObserver);
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

    public ObservableFlatMapSingle(Observable observable, Function function, boolean z) {
        super(observable);
        this.d = function;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new FlatMapSingleObserver(observer, this.d, this.e));
    }
}
