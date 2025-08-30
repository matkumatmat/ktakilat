package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    public final int e;
    public final boolean f = true;
    public final Action g;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        public final FlowableSubscriber c;
        public final SimplePlainQueue d;
        public final Action e;
        public Subscription f;
        public volatile boolean g;
        public volatile boolean i;
        public Throwable j;
        public final AtomicLong k = new AtomicLong();
        public boolean l;

        public BackpressureBufferSubscriber(FlowableSubscriber flowableSubscriber, int i2, boolean z, Action action) {
            SimplePlainQueue simplePlainQueue;
            this.c = flowableSubscriber;
            this.e = action;
            if (z) {
                simplePlainQueue = new SpscLinkedArrayQueue(i2);
            } else {
                simplePlainQueue = new SpscArrayQueue(i2);
            }
            this.d = simplePlainQueue;
        }

        public final void b() {
            int i2;
            boolean z;
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.d;
                FlowableSubscriber flowableSubscriber = this.c;
                int i3 = 1;
                while (!e(this.i, simplePlainQueue.isEmpty(), flowableSubscriber)) {
                    long j2 = this.k.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z2 = this.i;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!e(z2, z, flowableSubscriber)) {
                            if (z) {
                                break;
                            }
                            flowableSubscriber.onNext(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !e(this.i, simplePlainQueue.isEmpty(), flowableSubscriber)) {
                        if (!(j3 == 0 || j2 == LocationRequestCompat.PASSIVE_INTERVAL)) {
                            this.k.addAndGet(-j3);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                this.f.cancel();
                if (getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        public final void clear() {
            this.d.clear();
        }

        public final boolean e(boolean z, boolean z2, Subscriber subscriber) {
            if (this.g) {
                this.d.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.j;
                if (th != null) {
                    this.d.clear();
                    subscriber.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public final boolean isEmpty() {
            return this.d.isEmpty();
        }

        public final void onComplete() {
            this.i = true;
            if (this.l) {
                this.c.onComplete();
            } else {
                b();
            }
        }

        public final void onError(Throwable th) {
            this.j = th;
            this.i = true;
            if (this.l) {
                this.c.onError(th);
            } else {
                b();
            }
        }

        public final void onNext(Object obj) {
            if (!this.d.offer(obj)) {
                this.f.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.e.getClass();
                } catch (Throwable th) {
                    Exceptions.a(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.l) {
                this.c.onNext((Object) null);
            } else {
                b();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final Object poll() {
            return this.d.poll();
        }

        public final void request(long j2) {
            if (!this.l && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.k, j2);
                b();
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.l = true;
            return 2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowableOnBackpressureBuffer(FlowableFromObservable flowableFromObservable, int i) {
        super(flowableFromObservable);
        Action action = Functions.c;
        this.e = i;
        this.g = action;
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new BackpressureBufferSubscriber(flowableSubscriber, this.e, this.f, this.g));
    }
}
