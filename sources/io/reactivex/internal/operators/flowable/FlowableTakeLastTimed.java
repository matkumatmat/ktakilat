package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public final FlowableSubscriber c;
        public final SpscLinkedArrayQueue d;
        public Subscription e;
        public final AtomicLong f = new AtomicLong();
        public volatile boolean g;
        public volatile boolean i;
        public Throwable j;

        public TakeLastTimedSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            this.d = new SpscLinkedArrayQueue(0);
        }

        public final boolean a(boolean z, FlowableSubscriber flowableSubscriber) {
            if (this.g) {
                this.d.clear();
                return true;
            }
            Throwable th = this.j;
            if (th != null) {
                this.d.clear();
                flowableSubscriber.onError(th);
                return true;
            } else if (!z) {
                return false;
            } else {
                flowableSubscriber.onComplete();
                return true;
            }
        }

        public final void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.d;
                int i2 = 1;
                do {
                    if (this.i) {
                        if (!a(spscLinkedArrayQueue.isEmpty(), flowableSubscriber)) {
                            long j2 = this.f.get();
                            long j3 = 0;
                            while (true) {
                                if (spscLinkedArrayQueue.b() == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!a(z, flowableSubscriber)) {
                                    if (j2 != j3) {
                                        spscLinkedArrayQueue.poll();
                                        flowableSubscriber.onNext(spscLinkedArrayQueue.poll());
                                        j3++;
                                    } else if (j3 != 0) {
                                        BackpressureHelper.e(this.f, j3);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                this.e.cancel();
                if (getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            this.j = th;
            this.i = true;
            b();
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.f, j2);
                b();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new TakeLastTimedSubscriber(flowableSubscriber));
    }
}
