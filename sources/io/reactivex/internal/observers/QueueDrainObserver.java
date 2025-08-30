package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    public final SerializedObserver d;
    public final MpscLinkedQueue e;
    public volatile boolean f;
    public volatile boolean g;
    public Throwable i;

    public QueueDrainObserver(SerializedObserver serializedObserver, MpscLinkedQueue mpscLinkedQueue) {
        this.d = serializedObserver;
        this.e = mpscLinkedQueue;
    }

    public final boolean b() {
        if (this.c.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    public final void d(Object obj, Disposable disposable) {
        AtomicInteger atomicInteger = this.c;
        int i2 = atomicInteger.get();
        SerializedObserver serializedObserver = this.d;
        MpscLinkedQueue mpscLinkedQueue = this.e;
        if (i2 != 0 || !atomicInteger.compareAndSet(0, 1)) {
            mpscLinkedQueue.offer(obj);
            if (!b()) {
                return;
            }
        } else {
            a(serializedObserver, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        }
        QueueDrainHelper.b(mpscLinkedQueue, serializedObserver, disposable, this);
    }

    public final void e(Object obj, Disposable disposable) {
        AtomicInteger atomicInteger = this.c;
        int i2 = atomicInteger.get();
        SerializedObserver serializedObserver = this.d;
        MpscLinkedQueue mpscLinkedQueue = this.e;
        if (i2 != 0 || !atomicInteger.compareAndSet(0, 1)) {
            mpscLinkedQueue.offer(obj);
            if (!b()) {
                return;
            }
        } else if (mpscLinkedQueue.isEmpty()) {
            a(serializedObserver, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        } else {
            mpscLinkedQueue.offer(obj);
        }
        QueueDrainHelper.b(mpscLinkedQueue, serializedObserver, disposable, this);
    }

    public final int f(int i2) {
        return this.c.addAndGet(i2);
    }

    public void a(SerializedObserver serializedObserver, Object obj) {
    }
}
