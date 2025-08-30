package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        public void onCompleted() {
            this.state.onCompleted();
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        public boolean isUnsubscribed() {
            return this.once.get();
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(e.j(j, "n >= 0 required but it was "));
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }

        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            this.subscribers = EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException(ba.k(i, "prefetch > 0 required but it was "));
    }

    public boolean add(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr == publishProducerArr2) {
            return false;
        }
        synchronized (this) {
            try {
                PublishProducer<T>[] publishProducerArr3 = this.subscribers;
                if (publishProducerArr3 == publishProducerArr2) {
                    return false;
                }
                int length = publishProducerArr3.length;
                PublishProducer<T>[] publishProducerArr4 = new PublishProducer[(length + 1)];
                System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, length);
                publishProducerArr4[length] = publishProducer;
                this.subscribers = publishProducerArr4;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        int i;
        boolean z;
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i2 = 0;
            do {
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                long j = LocationRequestCompat.PASSIVE_INTERVAL;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        T poll = queue2.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!checkTerminated(z2, z)) {
                            if (z) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j2);
                        }
                        for (PublishProducer<T> produced : publishProducerArr) {
                            BackpressureUtils.produced(produced, j2);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    public void onCompleted() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.internal.operators.OnSubscribePublishMulticast.PublishProducer<T> r6) {
        /*
            r5 = this;
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r5.subscribers
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED
            if (r0 == r1) goto L_0x0044
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r2 = EMPTY
            if (r0 != r2) goto L_0x000b
            goto L_0x0044
        L_0x000b:
            monitor-enter(r5)
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r5.subscribers     // Catch:{ all -> 0x0020 }
            if (r0 == r1) goto L_0x0040
            if (r0 != r2) goto L_0x0013
            goto L_0x0040
        L_0x0013:
            int r1 = r0.length     // Catch:{ all -> 0x0020 }
            r2 = 0
            r3 = 0
        L_0x0016:
            if (r3 >= r1) goto L_0x0022
            r4 = r0[r3]     // Catch:{ all -> 0x0020 }
            if (r4 != r6) goto L_0x001d
            goto L_0x0023
        L_0x001d:
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0020:
            r6 = move-exception
            goto L_0x0042
        L_0x0022:
            r3 = -1
        L_0x0023:
            if (r3 >= 0) goto L_0x0027
            monitor-exit(r5)     // Catch:{ all -> 0x0020 }
            return
        L_0x0027:
            r6 = 1
            if (r1 != r6) goto L_0x002d
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r6 = EMPTY     // Catch:{ all -> 0x0020 }
            goto L_0x003c
        L_0x002d:
            int r4 = r1 + -1
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer[] r4 = new rx.internal.operators.OnSubscribePublishMulticast.PublishProducer[r4]     // Catch:{ all -> 0x0020 }
            java.lang.System.arraycopy(r0, r2, r4, r2, r3)     // Catch:{ all -> 0x0020 }
            int r2 = r3 + 1
            int r1 = r1 - r3
            int r1 = r1 - r6
            java.lang.System.arraycopy(r0, r2, r4, r3, r1)     // Catch:{ all -> 0x0020 }
            r6 = r4
        L_0x003c:
            r5.subscribers = r6     // Catch:{ all -> 0x0020 }
            monitor-exit(r5)     // Catch:{ all -> 0x0020 }
            return
        L_0x0040:
            monitor-exit(r5)     // Catch:{ all -> 0x0020 }
            return
        L_0x0042:
            monitor-exit(r5)     // Catch:{ all -> 0x0020 }
            throw r6
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribePublishMulticast.remove(rx.internal.operators.OnSubscribePublishMulticast$PublishProducer):void");
    }

    public void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr != publishProducerArr2) {
            synchronized (this) {
                try {
                    publishProducerArr = this.subscribers;
                    if (publishProducerArr != publishProducerArr2) {
                        this.subscribers = publishProducerArr2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return publishProducerArr;
    }

    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(Subscriber<? super T> subscriber) {
        PublishProducer publishProducer = new PublishProducer(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }
}
