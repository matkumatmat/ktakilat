package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final SpscLinkedArrayQueue e = new SpscLinkedArrayQueue(Flowable.c);
        public final CompositeDisposable f = new Object();
        public final LinkedHashMap g = new LinkedHashMap();
        public final LinkedHashMap i = new LinkedHashMap();
        public final AtomicReference j = new AtomicReference();
        public final AtomicInteger k = new AtomicInteger(2);
        public int l;
        public int m;
        public volatile boolean n;

        /* JADX WARNING: type inference failed for: r2v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public GroupJoinSubscription(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a(Throwable th) {
            if (ExceptionHelper.a(this.j, th)) {
                this.k.decrementAndGet();
                f();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void b(Throwable th) {
            if (ExceptionHelper.a(this.j, th)) {
                f();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void c(Object obj, boolean z) {
            int i2;
            synchronized (this) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.e;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                spscLinkedArrayQueue.a(i2, obj);
            }
            f();
        }

        public final void cancel() {
            if (!this.n) {
                this.n = true;
                this.f.dispose();
                if (getAndIncrement() == 0) {
                    this.e.clear();
                }
            }
        }

        public final void d(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            int i2;
            synchronized (this) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.e;
                if (z) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                spscLinkedArrayQueue.a(i2, leftRightEndSubscriber);
            }
            f();
        }

        public final void e(LeftRightSubscriber leftRightSubscriber) {
            this.f.c(leftRightSubscriber);
            this.k.decrementAndGet();
            f();
        }

        public final void f() {
            boolean z;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.e;
                FlowableSubscriber flowableSubscriber = this.c;
                int i2 = 1;
                while (!this.n) {
                    if (((Throwable) this.j.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        this.f.dispose();
                        g(flowableSubscriber);
                        return;
                    }
                    boolean z2 = false;
                    if (this.k.get() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z2 = true;
                    }
                    if (z && z2) {
                        for (UnicastProcessor onComplete : this.g.values()) {
                            onComplete.onComplete();
                        }
                        this.g.clear();
                        this.i.clear();
                        this.f.dispose();
                        flowableSubscriber.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == 1) {
                            UnicastProcessor unicastProcessor = new UnicastProcessor((Runnable) null, Flowable.c);
                            int i3 = this.l;
                            this.l = i3 + 1;
                            this.g.put(Integer.valueOf(i3), unicastProcessor);
                            try {
                                throw null;
                            } catch (Throwable th) {
                                h(th, flowableSubscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 2) {
                            int i4 = this.m;
                            this.m = i4 + 1;
                            this.i.put(Integer.valueOf(i4), poll);
                            try {
                                throw null;
                            } catch (Throwable th2) {
                                h(th2, flowableSubscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 3) {
                            LeftRightEndSubscriber leftRightEndSubscriber = (LeftRightEndSubscriber) poll;
                            LinkedHashMap linkedHashMap = this.g;
                            leftRightEndSubscriber.getClass();
                            UnicastProcessor unicastProcessor2 = (UnicastProcessor) linkedHashMap.remove(0);
                            this.f.a(leftRightEndSubscriber);
                            if (unicastProcessor2 != null) {
                                unicastProcessor2.onComplete();
                            }
                        } else if (num == 4) {
                            LeftRightEndSubscriber leftRightEndSubscriber2 = (LeftRightEndSubscriber) poll;
                            LinkedHashMap linkedHashMap2 = this.i;
                            leftRightEndSubscriber2.getClass();
                            linkedHashMap2.remove(0);
                            this.f.a(leftRightEndSubscriber2);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void g(FlowableSubscriber flowableSubscriber) {
            Throwable b = ExceptionHelper.b(this.j);
            LinkedHashMap linkedHashMap = this.g;
            for (UnicastProcessor onError : linkedHashMap.values()) {
                onError.onError(b);
            }
            linkedHashMap.clear();
            this.i.clear();
            flowableSubscriber.onError(b);
        }

        public final void h(Throwable th, FlowableSubscriber flowableSubscriber, SimpleQueue simpleQueue) {
            Exceptions.a(th);
            ExceptionHelper.a(this.j, th);
            simpleQueue.clear();
            this.f.dispose();
            g(flowableSubscriber);
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.d, j2);
            }
        }
    }

    public interface JoinSupport {
        void a(Throwable th);

        void b(Throwable th);

        void c(Object obj, boolean z);

        void d(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void e(LeftRightSubscriber leftRightSubscriber);
    }

    public static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) get());
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        public final AtomicInteger c;
        public final boolean d;

        public LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            this.c = (AtomicInteger) joinSupport;
            this.d = z;
        }

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) get());
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport] */
        public final void onComplete() {
            this.c.e(this);
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport] */
        public final void onError(Throwable th) {
            this.c.a(th);
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport] */
        public final void onNext(Object obj) {
            this.c.c(obj, this.d);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(flowableSubscriber);
        flowableSubscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        CompositeDisposable compositeDisposable = groupJoinSubscription.f;
        compositeDisposable.b(leftRightSubscriber);
        compositeDisposable.b(new LeftRightSubscriber(groupJoinSubscription, false));
        this.d.a(leftRightSubscriber);
        throw null;
    }
}
