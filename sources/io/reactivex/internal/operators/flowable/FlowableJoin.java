package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
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
        public JoinSubscription(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a(Throwable th) {
            if (ExceptionHelper.a(this.j, th)) {
                this.k.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void b(Throwable th) {
            if (ExceptionHelper.a(this.j, th)) {
                g();
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
            g();
        }

        public final void cancel() {
            if (!this.n) {
                this.n = true;
                f();
                if (getAndIncrement() == 0) {
                    this.e.clear();
                }
            }
        }

        public final void d(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
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
            g();
        }

        public final void e(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.f.c(leftRightSubscriber);
            this.k.decrementAndGet();
            g();
        }

        public final void f() {
            this.f.dispose();
        }

        public final void g() {
            boolean z;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.e;
                FlowableSubscriber flowableSubscriber = this.c;
                int i2 = 1;
                while (!this.n) {
                    if (((Throwable) this.j.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        f();
                        h(flowableSubscriber);
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
                            int i3 = this.l;
                            this.l = i3 + 1;
                            this.g.put(Integer.valueOf(i3), poll);
                            try {
                                throw null;
                            } catch (Throwable th) {
                                i(th, flowableSubscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 2) {
                            int i4 = this.m;
                            this.m = i4 + 1;
                            this.i.put(Integer.valueOf(i4), poll);
                            try {
                                throw null;
                            } catch (Throwable th2) {
                                i(th2, flowableSubscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == 3) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            LinkedHashMap linkedHashMap = this.g;
                            leftRightEndSubscriber.getClass();
                            linkedHashMap.remove(0);
                            this.f.a(leftRightEndSubscriber);
                        } else if (num == 4) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
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

        public final void h(FlowableSubscriber flowableSubscriber) {
            Throwable b = ExceptionHelper.b(this.j);
            this.g.clear();
            this.i.clear();
            flowableSubscriber.onError(b);
        }

        public final void i(Throwable th, FlowableSubscriber flowableSubscriber, SimpleQueue simpleQueue) {
            Exceptions.a(th);
            ExceptionHelper.a(this.j, th);
            simpleQueue.clear();
            f();
            h(flowableSubscriber);
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.d, j2);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(flowableSubscriber);
        flowableSubscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        CompositeDisposable compositeDisposable = joinSubscription.f;
        compositeDisposable.b(leftRightSubscriber);
        compositeDisposable.b(new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false));
        this.d.a(leftRightSubscriber);
        throw null;
    }
}
