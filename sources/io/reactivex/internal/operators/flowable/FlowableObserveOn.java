package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        public Subscription c;
        public SimpleQueue d;
        public volatile boolean e;
        public volatile boolean f;
        public Throwable g;
        public int i;
        public long j;
        public boolean k;

        public final void cancel() {
            if (!this.e) {
                this.e = true;
                this.c.cancel();
                throw null;
            }
        }

        public final void clear() {
            this.d.clear();
        }

        public final boolean e(boolean z, boolean z2, Subscriber subscriber) {
            if (this.e) {
                clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.g;
                if (th != null) {
                    clear();
                    subscriber.onError(th);
                    throw null;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    throw null;
                }
            }
        }

        public abstract void f();

        public abstract void g();

        public abstract void h();

        public final void i() {
            if (getAndIncrement() == 0) {
                throw null;
            }
        }

        public final boolean isEmpty() {
            return this.d.isEmpty();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                i();
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.g = th;
            this.f = true;
            i();
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.i == 2) {
                    i();
                    return;
                }
                if (!this.d.offer(obj)) {
                    this.c.cancel();
                    this.g = new MissingBackpressureException("Queue is full?!");
                    this.f = true;
                }
                i();
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a((AtomicLong) null, j2);
                i();
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        public final void run() {
            if (this.k) {
                g();
            } else if (this.i == 1) {
                h();
            } else {
                f();
            }
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        public long l;

        public final void f() {
            throw null;
        }

        public final void g() {
            if (!this.e) {
                throw null;
            }
        }

        public final void h() {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.i = 1;
                        this.d = queueSubscription;
                        this.f = true;
                        throw null;
                    } else if (requestFusion == 2) {
                        this.i = 2;
                        this.d = queueSubscription;
                        throw null;
                    }
                }
                this.d = new SpscArrayQueue(0);
                throw null;
            }
        }

        public final Object poll() {
            Object poll = this.d.poll();
            if (!(poll == null || this.i == 1)) {
                long j = this.l + 1;
                if (j == ((long) 0)) {
                    this.l = 0;
                    this.c.request(j);
                } else {
                    this.l = j;
                }
            }
            return poll;
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;

        public final void f() {
            throw null;
        }

        public final void g() {
            if (!this.e) {
                throw null;
            }
        }

        public final void h() {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.i = 1;
                        this.d = queueSubscription;
                        this.f = true;
                        throw null;
                    } else if (requestFusion == 2) {
                        this.i = 2;
                        this.d = queueSubscription;
                        throw null;
                    }
                }
                this.d = new SpscArrayQueue(0);
                throw null;
            }
        }

        public final Object poll() {
            Object poll = this.d.poll();
            if (!(poll == null || this.i == 1)) {
                long j = this.j + 1;
                if (j == ((long) 0)) {
                    this.j = 0;
                    this.c.request(j);
                } else {
                    this.j = j;
                }
            }
            return poll;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
