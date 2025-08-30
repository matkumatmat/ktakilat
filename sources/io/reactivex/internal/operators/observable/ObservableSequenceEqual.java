package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {
    public final ObservableSource c;
    public final ObservableSource d;
    public final BiPredicate e;
    public final int f;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        public final Observer c;
        public final BiPredicate d;
        public final ArrayCompositeDisposable e = new ArrayCompositeDisposable(2);
        public final ObservableSource f;
        public final ObservableSource g;
        public final EqualObserver[] i;
        public volatile boolean j;
        public Object k;
        public Object l;

        public EqualCoordinator(Observer observer, int i2, ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
            this.c = observer;
            this.f = observableSource;
            this.g = observableSource2;
            this.d = biPredicate;
            EqualObserver[] equalObserverArr = new EqualObserver[2];
            this.i = equalObserverArr;
            equalObserverArr[0] = new EqualObserver(this, 0, i2);
            equalObserverArr[1] = new EqualObserver(this, 1, i2);
        }

        public final void a() {
            boolean z;
            boolean z2;
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                EqualObserver[] equalObserverArr = this.i;
                EqualObserver equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue spscLinkedArrayQueue = equalObserver.d;
                EqualObserver equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver2.d;
                int i2 = 1;
                while (!this.j) {
                    boolean z3 = equalObserver.f;
                    if (!z3 || (th2 = equalObserver.g) == null) {
                        boolean z4 = equalObserver2.f;
                        if (!z4 || (th = equalObserver2.g) == null) {
                            if (this.k == null) {
                                this.k = spscLinkedArrayQueue.poll();
                            }
                            if (this.k == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (this.l == null) {
                                this.l = spscLinkedArrayQueue2.poll();
                            }
                            Object obj = this.l;
                            if (obj == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z3 && z4 && z && z2) {
                                this.c.onNext(Boolean.TRUE);
                                this.c.onComplete();
                                return;
                            } else if (!z3 || !z4 || z == z2) {
                                if (!z && !z2) {
                                    try {
                                        if (!this.d.test(this.k, obj)) {
                                            this.j = true;
                                            spscLinkedArrayQueue.clear();
                                            spscLinkedArrayQueue2.clear();
                                            this.c.onNext(Boolean.FALSE);
                                            this.c.onComplete();
                                            return;
                                        }
                                        this.k = null;
                                        this.l = null;
                                    } catch (Throwable th3) {
                                        Exceptions.a(th3);
                                        this.j = true;
                                        spscLinkedArrayQueue.clear();
                                        spscLinkedArrayQueue2.clear();
                                        this.c.onError(th3);
                                        return;
                                    }
                                }
                                if ((z || z2) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                this.j = true;
                                spscLinkedArrayQueue.clear();
                                spscLinkedArrayQueue2.clear();
                                this.c.onNext(Boolean.FALSE);
                                this.c.onComplete();
                                return;
                            }
                        } else {
                            this.j = true;
                            spscLinkedArrayQueue.clear();
                            spscLinkedArrayQueue2.clear();
                            this.c.onError(th);
                            return;
                        }
                    } else {
                        this.j = true;
                        spscLinkedArrayQueue.clear();
                        spscLinkedArrayQueue2.clear();
                        this.c.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        public final void dispose() {
            if (!this.j) {
                this.j = true;
                this.e.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver[] equalObserverArr = this.i;
                    equalObserverArr[0].d.clear();
                    equalObserverArr[1].d.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.j;
        }
    }

    public static final class EqualObserver<T> implements Observer<T> {
        public final EqualCoordinator c;
        public final SpscLinkedArrayQueue d;
        public final int e;
        public volatile boolean f;
        public Throwable g;

        public EqualObserver(EqualCoordinator equalCoordinator, int i, int i2) {
            this.c = equalCoordinator;
            this.e = i;
            this.d = new SpscLinkedArrayQueue(i2);
        }

        public final void onComplete() {
            this.f = true;
            this.c.a();
        }

        public final void onError(Throwable th) {
            this.g = th;
            this.f = true;
            this.c.a();
        }

        public final void onNext(Object obj) {
            this.d.offer(obj);
            this.c.a();
        }

        public final void onSubscribe(Disposable disposable) {
            this.c.e.setResource(this.e, disposable);
        }
    }

    public ObservableSequenceEqual(ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate, int i) {
        this.c = observableSource;
        this.d = observableSource2;
        this.e = biPredicate;
        this.f = i;
    }

    public final void subscribeActual(Observer observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f, this.c, this.d, this.e);
        observer.onSubscribe(equalCoordinator);
        EqualObserver[] equalObserverArr = equalCoordinator.i;
        equalCoordinator.f.subscribe(equalObserverArr[0]);
        equalCoordinator.g.subscribe(equalObserverArr[1]);
    }
}
