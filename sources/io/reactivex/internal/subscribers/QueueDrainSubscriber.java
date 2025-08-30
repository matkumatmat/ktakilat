package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    public final SerializedSubscriber e;
    public final MpscLinkedQueue f;
    public volatile boolean g;
    public volatile boolean i;
    public Throwable j;

    public QueueDrainSubscriber(SerializedSubscriber serializedSubscriber, MpscLinkedQueue mpscLinkedQueue) {
        this.e = serializedSubscriber;
        this.f = mpscLinkedQueue;
    }

    public boolean a(SerializedSubscriber serializedSubscriber, Object obj) {
        return false;
    }

    public final boolean b() {
        if (this.c.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    public final void e(Object obj, Disposable disposable) {
        SerializedSubscriber serializedSubscriber = this.e;
        MpscLinkedQueue mpscLinkedQueue = this.f;
        if (d()) {
            long j2 = this.d.get();
            if (j2 == 0) {
                this.g = true;
                disposable.dispose();
                throw null;
            } else if (mpscLinkedQueue.isEmpty()) {
                if (a(serializedSubscriber, obj) && j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    g();
                }
                if (this.c.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                mpscLinkedQueue.offer(obj);
            }
        } else {
            mpscLinkedQueue.offer(obj);
            if (!b()) {
                return;
            }
        }
        QueueDrainHelper.c(mpscLinkedQueue, serializedSubscriber, disposable, this);
    }

    public final int f(int i2) {
        return this.c.addAndGet(i2);
    }

    public final long g() {
        return this.d.addAndGet(-1);
    }

    public final long h() {
        return this.d.get();
    }

    public void request(long j2) {
        if (SubscriptionHelper.validate(j2)) {
            BackpressureHelper.a(this.d, j2);
        }
    }
}
