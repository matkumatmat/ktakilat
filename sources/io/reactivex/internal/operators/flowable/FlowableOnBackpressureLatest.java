package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;
        public final FlowableSubscriber c;
        public Subscription d;
        public volatile boolean e;
        public Throwable f;
        public volatile boolean g;
        public final AtomicLong i = new AtomicLong();
        public final AtomicReference j = new AtomicReference();

        public BackpressureLatestSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final boolean a(boolean z, boolean z2, FlowableSubscriber flowableSubscriber, AtomicReference atomicReference) {
            if (this.g) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.f;
                if (th != null) {
                    atomicReference.lazySet((Object) null);
                    flowableSubscriber.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    flowableSubscriber.onComplete();
                    return true;
                }
            }
        }

        public final void b() {
            boolean z;
            boolean z2;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                AtomicLong atomicLong = this.i;
                AtomicReference atomicReference = this.j;
                int i2 = 1;
                do {
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 == atomicLong.get()) {
                            break;
                        }
                        boolean z3 = this.e;
                        Object andSet = atomicReference.getAndSet((Object) null);
                        if (andSet == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!a(z3, z2, flowableSubscriber, atomicReference)) {
                            if (z2) {
                                break;
                            }
                            flowableSubscriber.onNext(andSet);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 == atomicLong.get()) {
                        boolean z4 = this.e;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (a(z4, z, flowableSubscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.e(atomicLong, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                this.d.cancel();
                if (getAndIncrement() == 0) {
                    this.j.lazySet((Object) null);
                }
            }
        }

        public final void onComplete() {
            this.e = true;
            b();
        }

        public final void onError(Throwable th) {
            this.f = th;
            this.e = true;
            b();
        }

        public final void onNext(Object obj) {
            this.j.lazySet(obj);
            b();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.i, j2);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(FlowableFromObservable flowableFromObservable) {
        super(flowableFromObservable);
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new BackpressureLatestSubscriber(flowableSubscriber));
    }
}
