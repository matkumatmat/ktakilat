package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    public final ObservableSource d;
    public final Function e;
    public final Function f;
    public final BiFunction g;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        public final Observer c;
        public final SpscLinkedArrayQueue d = new SpscLinkedArrayQueue(Observable.bufferSize());
        public final CompositeDisposable e = new Object();
        public final LinkedHashMap f = new LinkedHashMap();
        public final LinkedHashMap g = new LinkedHashMap();
        public final AtomicReference i = new AtomicReference();
        public final Function j;
        public final Function k;
        public final BiFunction l;
        public final AtomicInteger m;
        public int n;
        public int o;
        public volatile boolean p;

        /* JADX WARNING: type inference failed for: r2v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public JoinDisposable(Observer observer, Function function, Function function2, BiFunction biFunction) {
            this.c = observer;
            this.j = function;
            this.k = function2;
            this.l = biFunction;
            this.m = new AtomicInteger(2);
        }

        public final void a(Throwable th) {
            if (ExceptionHelper.a(this.i, th)) {
                this.m.decrementAndGet();
                f();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void b(Throwable th) {
            if (ExceptionHelper.a(this.i, th)) {
                f();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void c(Object obj, boolean z) {
            int i2;
            synchronized (this) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                spscLinkedArrayQueue.a(i2, obj);
            }
            f();
        }

        public final void d(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            int i2;
            synchronized (this) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                if (z) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                spscLinkedArrayQueue.a(i2, leftRightEndObserver);
            }
            f();
        }

        public final void dispose() {
            if (!this.p) {
                this.p = true;
                this.e.dispose();
                if (getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        public final void e(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.e.c(leftRightObserver);
            this.m.decrementAndGet();
            f();
        }

        public final void f() {
            boolean z;
            boolean z2;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                Observer observer = this.c;
                int i2 = 1;
                while (!this.p) {
                    if (((Throwable) this.i.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        this.e.dispose();
                        g(observer);
                        return;
                    }
                    if (this.m.get() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        this.f.clear();
                        this.g.clear();
                        this.e.dispose();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == 1) {
                            int i3 = this.n;
                            this.n = i3 + 1;
                            this.f.put(Integer.valueOf(i3), poll);
                            try {
                                Object apply = this.j.apply(poll);
                                ObjectHelper.b(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i3);
                                this.e.b(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (((Throwable) this.i.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.e.dispose();
                                    g(observer);
                                    return;
                                }
                                for (Object apply2 : this.g.values()) {
                                    try {
                                        Object apply3 = this.l.apply(poll, apply2);
                                        ObjectHelper.b(apply3, "The resultSelector returned a null value");
                                        observer.onNext(apply3);
                                    } catch (Throwable th) {
                                        h(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                h(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 2) {
                            int i4 = this.o;
                            this.o = i4 + 1;
                            this.g.put(Integer.valueOf(i4), poll);
                            try {
                                Object apply4 = this.k.apply(poll);
                                ObjectHelper.b(apply4, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply4;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i4);
                                this.e.b(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (((Throwable) this.i.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.e.dispose();
                                    g(observer);
                                    return;
                                }
                                for (Object apply5 : this.f.values()) {
                                    try {
                                        Object apply6 = this.l.apply(apply5, poll);
                                        ObjectHelper.b(apply6, "The resultSelector returned a null value");
                                        observer.onNext(apply6);
                                    } catch (Throwable th3) {
                                        h(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                h(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 3) {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f.remove(Integer.valueOf(leftRightEndObserver3.e));
                            this.e.a(leftRightEndObserver3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.g.remove(Integer.valueOf(leftRightEndObserver4.e));
                            this.e.a(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void g(Observer observer) {
            Throwable b = ExceptionHelper.b(this.i);
            this.f.clear();
            this.g.clear();
            observer.onError(b);
        }

        public final void h(Throwable th, Observer observer, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            Exceptions.a(th);
            ExceptionHelper.a(this.i, th);
            spscLinkedArrayQueue.clear();
            this.e.dispose();
            g(observer);
        }

        public final boolean isDisposed() {
            return this.p;
        }
    }

    public ObservableJoin(Observable observable, ObservableSource observableSource, Function function, Function function2, BiFunction biFunction) {
        super(observable);
        this.d = observableSource;
        this.e = function;
        this.f = function2;
        this.g = biFunction;
    }

    public final void subscribeActual(Observer observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.e, this.f, this.g);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        CompositeDisposable compositeDisposable = joinDisposable.e;
        compositeDisposable.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        compositeDisposable.b(leftRightObserver2);
        this.c.subscribe(leftRightObserver);
        this.d.subscribe(leftRightObserver2);
    }
}
