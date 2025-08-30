package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    public final MaybeSource d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Observer c;
        public final AtomicReference d = new AtomicReference();
        public final OtherObserver e = new OtherObserver(this);
        public final AtomicThrowable f = new AtomicThrowable();
        public volatile SpscLinkedArrayQueue g;
        public Object i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile int l;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver c;

            public OtherObserver(MergeWithObserver mergeWithObserver) {
                this.c = mergeWithObserver;
            }

            public final void onComplete() {
                MergeWithObserver mergeWithObserver = this.c;
                mergeWithObserver.l = 2;
                if (mergeWithObserver.getAndIncrement() == 0) {
                    mergeWithObserver.a();
                }
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.c;
                if (mergeWithObserver.f.addThrowable(th)) {
                    DisposableHelper.dispose(mergeWithObserver.d);
                    if (mergeWithObserver.getAndIncrement() == 0) {
                        mergeWithObserver.a();
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
                MergeWithObserver mergeWithObserver = this.c;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    mergeWithObserver.c.onNext(obj);
                    mergeWithObserver.l = 2;
                } else {
                    mergeWithObserver.i = obj;
                    mergeWithObserver.l = 1;
                    if (mergeWithObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                mergeWithObserver.a();
            }
        }

        public MergeWithObserver(Observer observer) {
            this.c = observer;
        }

        public final void a() {
            Object obj;
            boolean z;
            Observer observer = this.c;
            int i2 = 1;
            while (!this.j) {
                if (this.f.get() != null) {
                    this.i = null;
                    this.g = null;
                    observer.onError(this.f.terminate());
                    return;
                }
                int i3 = this.l;
                if (i3 == 1) {
                    Object obj2 = this.i;
                    this.i = null;
                    this.l = 2;
                    observer.onNext(obj2);
                    i3 = 2;
                }
                boolean z2 = this.k;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.g;
                if (spscLinkedArrayQueue != null) {
                    obj = spscLinkedArrayQueue.poll();
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z && i3 == 2) {
                    this.g = null;
                    observer.onComplete();
                    return;
                } else if (z) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(obj);
                }
            }
            this.i = null;
            this.g = null;
        }

        public final void dispose() {
            this.j = true;
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this.e);
            if (getAndIncrement() == 0) {
                this.g = null;
                this.i = null;
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.d.get());
        }

        public final void onComplete() {
            this.k = true;
            if (getAndIncrement() == 0) {
                a();
            }
        }

        public final void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                DisposableHelper.dispose(this.d);
                if (getAndIncrement() == 0) {
                    a();
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (compareAndSet(0, 1)) {
                this.c.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.g;
                if (spscLinkedArrayQueue == null) {
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                    this.g = spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue.offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable observable, MaybeSource maybeSource) {
        super(observable);
        this.d = maybeSource;
    }

    public final void subscribeActual(Observer observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.c.subscribe(mergeWithObserver);
        this.d.b(mergeWithObserver.e);
    }
}
