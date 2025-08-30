package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    public static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final Scheduler.Worker k = null;
        public long l;
        public long m;
        public Subscription n;
        public UnicastProcessor o;
        public volatile boolean p;
        public final SequentialDisposable q = new SequentialDisposable();

        public static final class ConsumerIndexHolder implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public WindowExactBoundedSubscriber(SerializedSubscriber serializedSubscriber) {
            super(serializedSubscriber, new MpscLinkedQueue());
        }

        public final void cancel() {
            this.g = true;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.q);
            Scheduler.Worker worker = this.k;
            if (worker != null) {
                worker.dispose();
            }
        }

        public final void i() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = this.f;
            SerializedSubscriber serializedSubscriber = this.e;
            UnicastProcessor unicastProcessor = this.o;
            int i = 1;
            while (!this.p) {
                boolean z2 = this.i;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z2 && (z || z3)) {
                    this.o = null;
                    mpscLinkedQueue.clear();
                    Throwable th = this.j;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    dispose();
                    return;
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    long j = this.m;
                    ((ConsumerIndexHolder) poll).getClass();
                    if (j == 0) {
                        unicastProcessor.onComplete();
                        this.l = 0;
                        unicastProcessor = new UnicastProcessor((Runnable) null, 0);
                        this.o = unicastProcessor;
                        long h = h();
                        if (h != 0) {
                            serializedSubscriber.onNext(unicastProcessor);
                            if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                                g();
                            }
                        } else {
                            this.o = null;
                            this.f.clear();
                            this.n.cancel();
                            serializedSubscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                            dispose();
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    unicastProcessor.onNext(NotificationLite.getValue(poll));
                    long j2 = this.l + 1;
                    if (j2 >= 0) {
                        this.m++;
                        this.l = 0;
                        unicastProcessor.onComplete();
                        long h2 = h();
                        if (h2 != 0) {
                            unicastProcessor = new UnicastProcessor((Runnable) null, 0);
                            this.o = unicastProcessor;
                            this.e.onNext(unicastProcessor);
                            if (h2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                                g();
                            }
                        } else {
                            this.o = null;
                            this.n.cancel();
                            this.e.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                    } else {
                        this.l = j2;
                    }
                }
            }
            this.n.cancel();
            mpscLinkedQueue.clear();
            dispose();
        }

        public final void onComplete() {
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onComplete();
            dispose();
        }

        public final void onError(Throwable th) {
            this.j = th;
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onError(th);
            dispose();
        }

        public final void onNext(Object obj) {
            if (!this.p) {
                if (d()) {
                    UnicastProcessor unicastProcessor = this.o;
                    unicastProcessor.onNext(obj);
                    long j = this.l + 1;
                    if (j >= 0) {
                        this.m++;
                        this.l = 0;
                        unicastProcessor.onComplete();
                        long h = h();
                        if (h != 0) {
                            UnicastProcessor unicastProcessor2 = new UnicastProcessor((Runnable) null, 0);
                            this.o = unicastProcessor2;
                            this.e.onNext(unicastProcessor2);
                            if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                                g();
                            }
                        } else {
                            this.o = null;
                            this.n.cancel();
                            this.e.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                    } else {
                        this.l = j;
                    }
                    if (f(-1) == 0) {
                        return;
                    }
                } else {
                    this.f.offer(NotificationLite.next(obj));
                    if (!b()) {
                        return;
                    }
                }
                i();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.n, subscription)) {
                this.n = subscription;
                SerializedSubscriber serializedSubscriber = this.e;
                serializedSubscriber.onSubscribe(this);
                if (!this.g) {
                    UnicastProcessor unicastProcessor = new UnicastProcessor((Runnable) null, 0);
                    this.o = unicastProcessor;
                    long h = h();
                    if (h != 0) {
                        serializedSubscriber.onNext(unicastProcessor);
                        if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                            g();
                        }
                        throw null;
                    }
                    this.g = true;
                    subscription.cancel();
                    serializedSubscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                }
            }
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object n = new Object();
        public Subscription k;
        public UnicastProcessor l;
        public volatile boolean m;

        public final void cancel() {
            this.g = true;
        }

        public final void i() {
            MpscLinkedQueue mpscLinkedQueue = this.f;
            SerializedSubscriber serializedSubscriber = this.e;
            UnicastProcessor unicastProcessor = this.l;
            int i = 1;
            while (true) {
                boolean z = this.m;
                boolean z2 = this.i;
                Object poll = mpscLinkedQueue.poll();
                Object obj = n;
                if (!z2 || !(poll == null || poll == obj)) {
                    if (poll == null) {
                        i = f(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == obj) {
                        unicastProcessor.onComplete();
                        if (!z) {
                            unicastProcessor = new UnicastProcessor((Runnable) null, 0);
                            this.l = unicastProcessor;
                            long h = h();
                            if (h != 0) {
                                serializedSubscriber.onNext(unicastProcessor);
                                if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                                    g();
                                }
                            } else {
                                this.l = null;
                                this.f.clear();
                                this.k.cancel();
                                DisposableHelper.dispose((AtomicReference<Disposable>) null);
                                serializedSubscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                        } else {
                            this.k.cancel();
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.l = null;
            mpscLinkedQueue.clear();
            DisposableHelper.dispose((AtomicReference<Disposable>) null);
            Throwable th = this.j;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
        }

        public final void onComplete() {
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onComplete();
            DisposableHelper.dispose((AtomicReference<Disposable>) null);
        }

        public final void onError(Throwable th) {
            this.j = th;
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onError(th);
            DisposableHelper.dispose((AtomicReference<Disposable>) null);
        }

        public final void onNext(Object obj) {
            if (!this.m) {
                if (d()) {
                    this.l.onNext(obj);
                    if (f(-1) == 0) {
                        return;
                    }
                } else {
                    this.f.offer(NotificationLite.next(obj));
                    if (!b()) {
                        return;
                    }
                }
                i();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                this.l = new UnicastProcessor((Runnable) null, 0);
                SerializedSubscriber serializedSubscriber = this.e;
                serializedSubscriber.onSubscribe(this);
                long h = h();
                if (h != 0) {
                    serializedSubscriber.onNext(this.l);
                    if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                        g();
                    }
                    if (!this.g) {
                        throw null;
                    }
                    return;
                }
                this.g = true;
                subscription.cancel();
                serializedSubscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        public final void run() {
            if (this.g) {
                this.m = true;
                DisposableHelper.dispose((AtomicReference<Disposable>) null);
            }
            this.f.offer(n);
            if (b()) {
                i();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        public Subscription k;
        public volatile boolean l;

        public final class Completion implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            public final UnicastProcessor f671a;
            public final boolean b;

            public SubjectWork(UnicastProcessor unicastProcessor, boolean z) {
                this.f671a = unicastProcessor;
                this.b = z;
            }
        }

        public final void cancel() {
            this.g = true;
        }

        public final void i() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = this.f;
            SerializedSubscriber serializedSubscriber = this.e;
            int i = 1;
            while (!this.l) {
                boolean z2 = this.i;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof SubjectWork;
                if (z2 && (z || z3)) {
                    mpscLinkedQueue.clear();
                    this.j.getClass();
                    throw null;
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (!z3) {
                    throw null;
                } else if (!((SubjectWork) poll).b) {
                    throw null;
                } else if (this.g) {
                    continue;
                } else if (h() == 0) {
                    serializedSubscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                } else {
                    new UnicastProcessor((Runnable) null, 0);
                    throw null;
                }
            }
            this.k.cancel();
            throw null;
        }

        public final void onComplete() {
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onComplete();
            throw null;
        }

        public final void onError(Throwable th) {
            this.j = th;
            this.i = true;
            if (b()) {
                i();
            }
            this.e.onError(th);
            throw null;
        }

        public final void onNext(Object obj) {
            if (!d()) {
                this.f.offer(obj);
                if (b()) {
                    i();
                    return;
                }
                return;
            }
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                this.e.onSubscribe(this);
                if (!this.g) {
                    if (h() == 0) {
                        subscription.cancel();
                        this.e.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                        return;
                    }
                    new UnicastProcessor((Runnable) null, 0);
                    throw null;
                }
            }
        }

        public final void run() {
            SubjectWork subjectWork = new SubjectWork(new UnicastProcessor((Runnable) null, 0), true);
            if (!this.g) {
                this.f.offer(subjectWork);
            }
            if (b()) {
                i();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new WindowExactBoundedSubscriber(new SerializedSubscriber(flowableSubscriber)));
    }
}
