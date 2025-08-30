package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    public final Scheduler d;
    public final boolean e;
    public final int f;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        public final Observer c;
        public final Scheduler.Worker d;
        public final boolean e;
        public final int f;
        public SimpleQueue g;
        public Disposable i;
        public Throwable j;
        public volatile boolean k;
        public volatile boolean l;
        public int m;
        public boolean n;

        public ObserveOnObserver(Observer observer, Scheduler.Worker worker, boolean z, int i2) {
            this.c = observer;
            this.d = worker;
            this.e = z;
            this.f = i2;
        }

        public final boolean a(boolean z, boolean z2, Observer observer) {
            if (this.l) {
                this.g.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.j;
                if (this.e) {
                    if (!z2) {
                        return false;
                    }
                    if (th != null) {
                        observer.onError(th);
                    } else {
                        observer.onComplete();
                    }
                    this.d.dispose();
                    return true;
                } else if (th != null) {
                    this.g.clear();
                    observer.onError(th);
                    this.d.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    observer.onComplete();
                    this.d.dispose();
                    return true;
                }
            }
        }

        public final void clear() {
            this.g.clear();
        }

        public final void dispose() {
            if (!this.l) {
                this.l = true;
                this.i.dispose();
                this.d.dispose();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.l;
        }

        public final boolean isEmpty() {
            return this.g.isEmpty();
        }

        public final void onComplete() {
            if (!this.k) {
                this.k = true;
                if (getAndIncrement() == 0) {
                    this.d.b(this);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.k) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = th;
            this.k = true;
            if (getAndIncrement() == 0) {
                this.d.b(this);
            }
        }

        public final void onNext(Object obj) {
            if (!this.k) {
                if (this.m != 2) {
                    this.g.offer(obj);
                }
                if (getAndIncrement() == 0) {
                    this.d.b(this);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.g = queueDisposable;
                        this.k = true;
                        this.c.onSubscribe(this);
                        if (getAndIncrement() == 0) {
                            this.d.b(this);
                            return;
                        }
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

        public final Object poll() {
            return this.g.poll();
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.n = true;
            return 2;
        }

        public final void run() {
            boolean z;
            int i2 = 1;
            if (this.n) {
                while (!this.l) {
                    boolean z2 = this.k;
                    Throwable th = this.j;
                    if (this.e || !z2 || th == null) {
                        this.c.onNext((Object) null);
                        if (z2) {
                            Throwable th2 = this.j;
                            if (th2 != null) {
                                this.c.onError(th2);
                            } else {
                                this.c.onComplete();
                            }
                            this.d.dispose();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        this.c.onError(th);
                        this.d.dispose();
                        return;
                    }
                }
                return;
            }
            SimpleQueue simpleQueue = this.g;
            Observer observer = this.c;
            int i3 = 1;
            while (!a(this.k, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z3 = this.k;
                    try {
                        Object poll = simpleQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!a(z3, z, observer)) {
                            if (z) {
                                i3 = addAndGet(-i3);
                                if (i3 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.a(th3);
                        this.i.dispose();
                        simpleQueue.clear();
                        observer.onError(th3);
                        this.d.dispose();
                        return;
                    }
                }
            }
        }
    }

    public ObservableObserveOn(Observable observable, Scheduler scheduler, boolean z, int i) {
        super(observable);
        this.d = scheduler;
        this.e = z;
        this.f = i;
    }

    public final void subscribeActual(Observer observer) {
        Scheduler scheduler = this.d;
        boolean z = scheduler instanceof TrampolineScheduler;
        ObservableSource observableSource = this.c;
        if (z) {
            observableSource.subscribe(observer);
        } else {
            observableSource.subscribe(new ObserveOnObserver(observer, scheduler.a(), this.e, this.f));
        }
    }
}
