package io.reactivex.internal.subscriptions;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    public Subscription c;
    public long d;
    public final AtomicReference e = new AtomicReference();
    public final AtomicLong f = new AtomicLong();
    public final AtomicLong g = new AtomicLong();
    public volatile boolean i;
    public boolean j;

    public void cancel() {
        if (!this.i) {
            this.i = true;
            if (getAndIncrement() == 0) {
                d();
            }
        }
    }

    public final void d() {
        int i2 = 1;
        long j2 = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = (Subscription) this.e.get();
            if (subscription2 != null) {
                subscription2 = (Subscription) this.e.getAndSet((Object) null);
            }
            long j3 = this.f.get();
            if (j3 != 0) {
                j3 = this.f.getAndSet(0);
            }
            long j4 = this.g.get();
            if (j4 != 0) {
                j4 = this.g.getAndSet(0);
            }
            Subscription subscription3 = this.c;
            if (this.i) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.c = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j5 = this.d;
                if (j5 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    j5 = BackpressureHelper.c(j5, j3);
                    if (j5 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        j5 -= j4;
                        if (j5 < 0) {
                            SubscriptionHelper.reportMoreProduced(j5);
                            j5 = 0;
                        }
                    }
                    this.d = j5;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    this.c = subscription2;
                    if (j5 != 0) {
                        j2 = BackpressureHelper.c(j2, j5);
                        subscription = subscription2;
                    }
                } else if (!(subscription3 == null || j3 == 0)) {
                    j2 = BackpressureHelper.c(j2, j3);
                    subscription = subscription3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j2 != 0) {
            subscription.request(j2);
        }
    }

    public final boolean isCancelled() {
        return this.i;
    }

    public final boolean isUnbounded() {
        return this.j;
    }

    public void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }

    public final void produced(long j2) {
        if (!this.j) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.a(this.g, j2);
                if (getAndIncrement() == 0) {
                    d();
                    return;
                }
                return;
            }
            long j3 = this.d;
            if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j4 = j3 - j2;
                if (j4 < 0) {
                    SubscriptionHelper.reportMoreProduced(j4);
                    j4 = 0;
                }
                this.d = j4;
            }
            if (decrementAndGet() != 0) {
                d();
            }
        }
    }

    public final void request(long j2) {
        if (SubscriptionHelper.validate(j2) && !this.j) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.a(this.f, j2);
                if (getAndIncrement() == 0) {
                    d();
                    return;
                }
                return;
            }
            long j3 = this.d;
            if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                long c2 = BackpressureHelper.c(j3, j2);
                this.d = c2;
                if (c2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.j = true;
                }
            }
            Subscription subscription = this.c;
            if (decrementAndGet() != 0) {
                d();
            }
            if (subscription != null) {
                subscription.request(j2);
            }
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.i) {
            subscription.cancel();
            return;
        }
        ObjectHelper.b(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription subscription2 = (Subscription) this.e.getAndSet(subscription);
            if (subscription2 != null) {
                subscription2.cancel();
            }
            if (getAndIncrement() == 0) {
                d();
                return;
            }
            return;
        }
        Subscription subscription3 = this.c;
        if (subscription3 != null) {
            subscription3.cancel();
        }
        this.c = subscription;
        long j2 = this.d;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j2 != 0) {
            subscription.request(j2);
        }
    }
}
