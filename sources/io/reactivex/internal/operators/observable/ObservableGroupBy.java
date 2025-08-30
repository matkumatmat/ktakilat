package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    public final Function d;
    public final Function e;
    public final int f;
    public final boolean g;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        public static final Object l = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final Observer c;
        public final Function d;
        public final Function e;
        public final int f;
        public final boolean g;
        public final ConcurrentHashMap i;
        public Disposable j;
        public final AtomicBoolean k = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = function2;
            this.f = i2;
            this.g = z;
            this.i = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = l;
            }
            this.i.remove(k2);
            if (decrementAndGet() == 0) {
                this.j.dispose();
            }
        }

        public void dispose() {
            if (this.k.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.j.dispose();
            }
        }

        public boolean isDisposed() {
            return this.k.get();
        }

        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.i.values());
            this.i.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                State state = ((GroupedUnicast) it.next()).d;
                state.g = true;
                state.a();
            }
            this.c.onComplete();
        }

        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.i.values());
            this.i.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                State state = ((GroupedUnicast) it.next()).d;
                state.i = th;
                state.g = true;
                state.a();
            }
            this.c.onError(th);
        }

        public void onNext(T t) {
            Object obj;
            try {
                Object apply = this.d.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = l;
                }
                ConcurrentHashMap concurrentHashMap = this.i;
                GroupedUnicast groupedUnicast = (GroupedUnicast) concurrentHashMap.get(obj);
                if (groupedUnicast == null) {
                    if (!this.k.get()) {
                        GroupedUnicast groupedUnicast2 = new GroupedUnicast(apply, new State(this.f, this, apply, this.g));
                        concurrentHashMap.put(obj, groupedUnicast2);
                        getAndIncrement();
                        this.c.onNext(groupedUnicast2);
                        groupedUnicast = groupedUnicast2;
                    } else {
                        return;
                    }
                }
                try {
                    Object apply2 = this.e.apply(t);
                    ObjectHelper.b(apply2, "The value supplied is null");
                    State state = groupedUnicast.d;
                    state.d.offer(apply2);
                    state.a();
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.j.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.a(th2);
                this.j.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        public final State d;

        public GroupedUnicast(Object obj, State state) {
            super(obj);
            this.d = state;
        }

        public final void subscribeActual(Observer observer) {
            this.d.subscribe(observer);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final Object c;
        public final SpscLinkedArrayQueue d;
        public final GroupByObserver e;
        public final boolean f;
        public volatile boolean g;
        public Throwable i;
        public final AtomicBoolean j = new AtomicBoolean();
        public final AtomicBoolean k = new AtomicBoolean();
        public final AtomicReference l = new AtomicReference();

        public State(int i2, GroupByObserver groupByObserver, Object obj, boolean z) {
            this.d = new SpscLinkedArrayQueue(i2);
            this.e = groupByObserver;
            this.c = obj;
            this.f = z;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                boolean z2 = this.f;
                Observer observer = (Observer) this.l.get();
                int i2 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z3 = this.g;
                            Object poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            boolean z4 = this.j.get();
                            SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.d;
                            AtomicReference atomicReference = this.l;
                            if (z4) {
                                spscLinkedArrayQueue2.clear();
                                this.e.cancel(this.c);
                                atomicReference.lazySet((Object) null);
                                return;
                            }
                            if (z3) {
                                if (!z2) {
                                    Throwable th = this.i;
                                    if (th != null) {
                                        spscLinkedArrayQueue2.clear();
                                        atomicReference.lazySet((Object) null);
                                        observer.onError(th);
                                        return;
                                    } else if (z) {
                                        atomicReference.lazySet((Object) null);
                                        observer.onComplete();
                                        return;
                                    }
                                } else if (z) {
                                    Throwable th2 = this.i;
                                    atomicReference.lazySet((Object) null);
                                    if (th2 != null) {
                                        observer.onError(th2);
                                        return;
                                    } else {
                                        observer.onComplete();
                                        return;
                                    }
                                }
                            }
                            if (z) {
                                break;
                            }
                            observer.onNext(poll);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        if (observer == null) {
                            observer = (Observer) this.l.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final void dispose() {
            if (this.j.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.l.lazySet((Object) null);
                this.e.cancel(this.c);
            }
        }

        public final boolean isDisposed() {
            return this.j.get();
        }

        public final void subscribe(Observer observer) {
            if (this.k.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                AtomicReference atomicReference = this.l;
                atomicReference.lazySet(observer);
                if (this.j.get()) {
                    atomicReference.lazySet((Object) null);
                } else {
                    a();
                }
            } else {
                EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (Observer<?>) observer);
            }
        }
    }

    public ObservableGroupBy(Observable observable, Function function, Function function2, int i, boolean z) {
        super(observable);
        this.d = function;
        this.e = function2;
        this.f = i;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new GroupByObserver(observer, this.d, this.e, this.f, this.g));
    }
}
