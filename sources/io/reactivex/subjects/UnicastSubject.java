package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {
    public final SpscLinkedArrayQueue c;
    public final AtomicReference d;
    public final AtomicReference e;
    public final boolean f;
    public volatile boolean g;
    public volatile boolean i;
    public Throwable j;
    public final AtomicBoolean k;
    public final BasicIntQueueDisposable l;
    public boolean m;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        public final void clear() {
            UnicastSubject.this.c.clear();
        }

        public final void dispose() {
            if (!UnicastSubject.this.g) {
                UnicastSubject.this.g = true;
                UnicastSubject.this.d();
                UnicastSubject.this.d.lazySet((Object) null);
                if (UnicastSubject.this.l.getAndIncrement() == 0) {
                    UnicastSubject.this.d.lazySet((Object) null);
                    UnicastSubject.this.c.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return UnicastSubject.this.g;
        }

        public final boolean isEmpty() {
            return UnicastSubject.this.c.isEmpty();
        }

        public final Object poll() {
            return UnicastSubject.this.c.poll();
        }

        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.m = true;
            return 2;
        }
    }

    public UnicastSubject(int i2) {
        ObjectHelper.c(i2, "capacityHint");
        this.c = new SpscLinkedArrayQueue(i2);
        this.e = new AtomicReference();
        this.f = true;
        this.d = new AtomicReference();
        this.k = new AtomicBoolean();
        this.l = new UnicastQueueDisposable();
    }

    public final void d() {
        AtomicReference atomicReference = this.e;
        Runnable runnable = (Runnable) atomicReference.get();
        if (runnable != null) {
            while (!atomicReference.compareAndSet(runnable, (Object) null)) {
                if (atomicReference.get() != runnable) {
                    return;
                }
            }
            runnable.run();
        }
    }

    public final void e() {
        boolean z;
        Throwable th;
        if (this.l.getAndIncrement() == 0) {
            Observer observer = (Observer) this.d.get();
            int i2 = 1;
            int i3 = 1;
            while (observer == null) {
                i3 = this.l.addAndGet(-i3);
                if (i3 != 0) {
                    observer = (Observer) this.d.get();
                } else {
                    return;
                }
            }
            if (this.m) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.c;
                boolean z2 = this.f;
                while (!this.g) {
                    boolean z3 = this.i;
                    if (z2 || !z3 || (th = this.j) == null) {
                        observer.onNext((Object) null);
                        if (z3) {
                            this.d.lazySet((Object) null);
                            Throwable th2 = this.j;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            i2 = this.l.addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        this.d.lazySet((Object) null);
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                this.d.lazySet((Object) null);
                spscLinkedArrayQueue.clear();
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.c;
            boolean z4 = this.f;
            boolean z5 = true;
            int i4 = 1;
            while (!this.g) {
                boolean z6 = this.i;
                Object poll = this.c.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z6) {
                    if (!z4 && z5) {
                        Throwable th3 = this.j;
                        if (th3 != null) {
                            this.d.lazySet((Object) null);
                            spscLinkedArrayQueue2.clear();
                            observer.onError(th3);
                            return;
                        }
                        z5 = false;
                    }
                    if (z) {
                        this.d.lazySet((Object) null);
                        Throwable th4 = this.j;
                        if (th4 != null) {
                            observer.onError(th4);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if (z) {
                    i4 = this.l.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.d.lazySet((Object) null);
            spscLinkedArrayQueue2.clear();
        }
    }

    public final void onComplete() {
        if (!this.i && !this.g) {
            this.i = true;
            d();
            e();
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.i || this.g) {
            RxJavaPlugins.b(th);
            return;
        }
        this.j = th;
        this.i = true;
        d();
        e();
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.i && !this.g) {
            this.c.offer(obj);
            e();
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.i || this.g) {
            disposable.dispose();
        }
    }

    public final void subscribeActual(Observer observer) {
        if (this.k.get() || !this.k.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.l);
        this.d.lazySet(observer);
        if (this.g) {
            this.d.lazySet((Object) null);
        } else {
            e();
        }
    }

    public UnicastSubject(Runnable runnable, int i2) {
        ObjectHelper.c(i2, "capacityHint");
        this.c = new SpscLinkedArrayQueue(i2);
        this.e = new AtomicReference(runnable);
        this.f = true;
        this.d = new AtomicReference();
        this.k = new AtomicBoolean();
        this.l = new UnicastQueueDisposable();
    }
}
