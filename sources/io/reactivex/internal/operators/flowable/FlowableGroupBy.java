package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {

    public static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        public final void accept(Object obj) {
            GroupedUnicast groupedUnicast = (GroupedUnicast) obj;
            throw null;
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3688291656102519502L;
        public static final Object t = new Object();
        public final Subscriber c;
        public final Function d;
        public final Function e;
        public final int f;
        public final boolean g;
        public final Map i;
        public final SpscLinkedArrayQueue j;
        public final Queue k;
        public Subscription l;
        public final AtomicBoolean m = new AtomicBoolean();
        public final AtomicLong n = new AtomicLong();
        public final AtomicInteger o = new AtomicInteger(1);
        public Throwable p;
        public volatile boolean q;
        public boolean r;
        public boolean s;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.c = subscriber;
            this.d = function;
            this.e = function2;
            this.f = i2;
            this.g = z;
            this.i = map;
            this.k = queue;
            this.j = new SpscLinkedArrayQueue(i2);
        }

        public final void b() {
            int i2;
            boolean z;
            Throwable th;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                if (this.s) {
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.j;
                    Subscriber subscriber = this.c;
                    while (!this.m.get()) {
                        boolean z2 = this.q;
                        if (!z2 || this.g || (th = this.p) == null) {
                            subscriber.onNext((Object) null);
                            if (z2) {
                                Throwable th2 = this.p;
                                if (th2 != null) {
                                    subscriber.onError(th2);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            } else {
                                i3 = addAndGet(-i3);
                                if (i3 == 0) {
                                    return;
                                }
                            }
                        } else {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    spscLinkedArrayQueue.clear();
                    return;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.j;
                Subscriber subscriber2 = this.c;
                int i4 = 1;
                do {
                    long j2 = this.n.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z3 = this.q;
                        GroupedFlowable groupedFlowable = (GroupedFlowable) spscLinkedArrayQueue2.poll();
                        if (groupedFlowable == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!e(z3, z, subscriber2, spscLinkedArrayQueue2)) {
                            if (z) {
                                break;
                            }
                            subscriber2.onNext(groupedFlowable);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !e(this.q, spscLinkedArrayQueue2.isEmpty(), subscriber2, spscLinkedArrayQueue2)) {
                        if (j3 != 0) {
                            if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                                this.n.addAndGet(-j3);
                            }
                            this.l.request(j3);
                        }
                        i4 = addAndGet(-i4);
                    } else {
                        return;
                    }
                } while (i4 != 0);
            }
        }

        public void cancel() {
            if (this.m.compareAndSet(false, true)) {
                f();
                if (this.o.decrementAndGet() == 0) {
                    this.l.cancel();
                }
            }
        }

        public void clear() {
            this.j.clear();
        }

        public final boolean e(boolean z, boolean z2, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            if (this.m.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (this.g) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.p;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.p;
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public final void f() {
            Queue queue = this.k;
            if (queue != null) {
                int i2 = 0;
                while (true) {
                    GroupedUnicast groupedUnicast = (GroupedUnicast) queue.poll();
                    if (groupedUnicast == null) {
                        break;
                    }
                    State state = groupedUnicast.e;
                    state.i = true;
                    state.b();
                    i2++;
                }
                if (i2 != 0) {
                    this.o.addAndGet(-i2);
                }
            }
        }

        public boolean isEmpty() {
            return this.j.isEmpty();
        }

        public void onComplete() {
            if (!this.r) {
                for (GroupedUnicast groupedUnicast : this.i.values()) {
                    State state = groupedUnicast.e;
                    state.i = true;
                    state.b();
                }
                this.i.clear();
                Queue queue = this.k;
                if (queue != null) {
                    queue.clear();
                }
                this.r = true;
                this.q = true;
                b();
            }
        }

        public void onError(Throwable th) {
            if (this.r) {
                RxJavaPlugins.b(th);
                return;
            }
            this.r = true;
            for (GroupedUnicast groupedUnicast : this.i.values()) {
                State state = groupedUnicast.e;
                state.j = th;
                state.i = true;
                state.b();
            }
            this.i.clear();
            Queue queue = this.k;
            if (queue != null) {
                queue.clear();
            }
            this.p = th;
            this.q = true;
            b();
        }

        public void onNext(T t2) {
            Object obj;
            boolean z;
            if (!this.r) {
                try {
                    Object apply = this.d.apply(t2);
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = t;
                    }
                    Map map = this.i;
                    GroupedUnicast groupedUnicast = (GroupedUnicast) map.get(obj);
                    if (groupedUnicast != null) {
                        z = false;
                    } else if (!this.m.get()) {
                        int i2 = GroupedUnicast.f;
                        GroupedUnicast groupedUnicast2 = new GroupedUnicast(apply, new State(this.f, this, apply, this.g));
                        map.put(obj, groupedUnicast2);
                        this.o.getAndIncrement();
                        z = true;
                        groupedUnicast = groupedUnicast2;
                    } else {
                        return;
                    }
                    try {
                        Object apply2 = this.e.apply(t2);
                        ObjectHelper.b(apply2, "The valueSelector returned null");
                        State state = groupedUnicast.e;
                        state.d.offer(apply2);
                        state.b();
                        f();
                        if (z) {
                            this.j.offer(groupedUnicast);
                            b();
                        }
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        this.l.cancel();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    this.l.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) this.f);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.n, j2);
                b();
            }
        }

        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.s = true;
            return 2;
        }

        @Nullable
        public GroupedFlowable<K, V> poll() {
            return (GroupedFlowable) this.j.poll();
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = t;
            }
            this.i.remove(k2);
            if (this.o.decrementAndGet() == 0) {
                this.l.cancel();
                if (getAndIncrement() == 0) {
                    this.j.clear();
                }
            }
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        public static final /* synthetic */ int f = 0;
        public final State e;

        public GroupedUnicast(Object obj, State state) {
            super(obj);
            this.e = state;
        }

        public final void b(FlowableSubscriber flowableSubscriber) {
            this.e.d(flowableSubscriber);
        }
    }

    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final Object c;
        public final SpscLinkedArrayQueue d;
        public final GroupBySubscriber e;
        public final boolean f;
        public final AtomicLong g = new AtomicLong();
        public volatile boolean i;
        public Throwable j;
        public final AtomicBoolean k = new AtomicBoolean();
        public final AtomicReference l = new AtomicReference();
        public final AtomicBoolean m = new AtomicBoolean();
        public boolean n;
        public int o;

        public State(int i2, GroupBySubscriber groupBySubscriber, Object obj, boolean z) {
            this.d = new SpscLinkedArrayQueue(i2);
            this.e = groupBySubscriber;
            this.c = obj;
            this.f = z;
        }

        public final void b() {
            int i2;
            boolean z;
            Throwable th;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                if (this.n) {
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                    Subscriber subscriber = (Subscriber) this.l.get();
                    while (true) {
                        if (subscriber != null) {
                            if (this.k.get()) {
                                spscLinkedArrayQueue.clear();
                                return;
                            }
                            boolean z2 = this.i;
                            if (!z2 || this.f || (th = this.j) == null) {
                                subscriber.onNext((Object) null);
                                if (z2) {
                                    Throwable th2 = this.j;
                                    if (th2 != null) {
                                        subscriber.onError(th2);
                                        return;
                                    } else {
                                        subscriber.onComplete();
                                        return;
                                    }
                                }
                            } else {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                        }
                        i3 = addAndGet(-i3);
                        if (i3 != 0) {
                            if (subscriber == null) {
                                subscriber = (Subscriber) this.l.get();
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.d;
                    boolean z3 = this.f;
                    Subscriber subscriber2 = (Subscriber) this.l.get();
                    int i4 = 1;
                    while (true) {
                        if (subscriber2 != null) {
                            long j2 = this.g.get();
                            long j3 = 0;
                            while (true) {
                                i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                                if (i2 == 0) {
                                    break;
                                }
                                boolean z4 = this.i;
                                Object poll = spscLinkedArrayQueue2.poll();
                                if (poll == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!e(z4, z, subscriber2, z3)) {
                                    if (z) {
                                        break;
                                    }
                                    subscriber2.onNext(poll);
                                    j3++;
                                } else {
                                    return;
                                }
                            }
                            if (i2 == 0 && e(this.i, spscLinkedArrayQueue2.isEmpty(), subscriber2, z3)) {
                                return;
                            }
                            if (j3 != 0) {
                                if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                                    this.g.addAndGet(-j3);
                                }
                                this.e.l.request(j3);
                            }
                        }
                        i4 = addAndGet(-i4);
                        if (i4 != 0) {
                            if (subscriber2 == null) {
                                subscriber2 = (Subscriber) this.l.get();
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final void cancel() {
            if (this.k.compareAndSet(false, true)) {
                this.e.cancel(this.c);
            }
        }

        public final void clear() {
            this.d.clear();
        }

        public final void d(Subscriber subscriber) {
            if (this.m.compareAndSet(false, true)) {
                subscriber.onSubscribe(this);
                this.l.lazySet(subscriber);
                b();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }

        public final boolean e(boolean z, boolean z2, Subscriber subscriber, boolean z3) {
            boolean z4 = this.k.get();
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
            if (z4) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.j;
                    if (th != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.j;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public final boolean isEmpty() {
            return this.d.isEmpty();
        }

        public final Object poll() {
            Object poll = this.d.poll();
            if (poll != null) {
                this.o++;
                return poll;
            }
            int i2 = this.o;
            if (i2 == 0) {
                return null;
            }
            this.o = 0;
            this.e.l.request((long) i2);
            return null;
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.g, j2);
                b();
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.n = true;
            return 2;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            this.d.a(new GroupBySubscriber(flowableSubscriber, (Function) null, (Function) null, 0, false, new ConcurrentHashMap(), (Queue) null));
        } catch (Exception e) {
            Exceptions.a(e);
            flowableSubscriber.onSubscribe(EmptyComponent.INSTANCE);
            flowableSubscriber.onError(e);
        }
    }
}
