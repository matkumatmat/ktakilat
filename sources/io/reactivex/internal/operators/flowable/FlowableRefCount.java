package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {
    public RefConnection d;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        public final FlowableRefCount c;
        public long d;
        public boolean e;

        public RefConnection(FlowableRefCount flowableRefCount) {
            this.c = flowableRefCount;
        }

        public final void accept(Object obj) {
            DisposableHelper.replace(this, (Disposable) obj);
        }

        public final void run() {
            this.c.e(this);
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        public final FlowableSubscriber c;
        public final FlowableRefCount d;
        public final RefConnection e;
        public Subscription f;

        public RefCountSubscriber(FlowableSubscriber flowableSubscriber, FlowableRefCount flowableRefCount, RefConnection refConnection) {
            this.c = flowableSubscriber;
            this.d = flowableRefCount;
            this.e = refConnection;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cancel() {
            /*
                r7 = this;
                org.reactivestreams.Subscription r0 = r7.f
                r0.cancel()
                r0 = 0
                r1 = 1
                boolean r0 = r7.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0035
                io.reactivex.internal.operators.flowable.FlowableRefCount r0 = r7.d
                io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection r1 = r7.e
                monitor-enter(r0)
                io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection r2 = r0.d     // Catch:{ all -> 0x0018 }
                if (r2 != 0) goto L_0x001a
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0018:
                r1 = move-exception
                goto L_0x0033
            L_0x001a:
                long r2 = r1.d     // Catch:{ all -> 0x0018 }
                r4 = 1
                long r2 = r2 - r4
                r1.d = r2     // Catch:{ all -> 0x0018 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0031
                boolean r2 = r1.e     // Catch:{ all -> 0x0018 }
                if (r2 != 0) goto L_0x002c
                goto L_0x0031
            L_0x002c:
                r0.e(r1)     // Catch:{ all -> 0x0018 }
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0031:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                throw r1
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRefCount.RefCountSubscriber.cancel():void");
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                FlowableRefCount flowableRefCount = this.d;
                RefConnection refConnection = this.e;
                synchronized (flowableRefCount) {
                    try {
                        if (flowableRefCount.d != null) {
                            flowableRefCount.d = null;
                            refConnection.getClass();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                FlowableRefCount flowableRefCount = this.d;
                RefConnection refConnection = this.e;
                synchronized (flowableRefCount) {
                    try {
                        if (flowableRefCount.d != null) {
                            flowableRefCount.d = null;
                            refConnection.getClass();
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            throw th2;
                        }
                    }
                }
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            this.f.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        RefConnection refConnection;
        synchronized (this) {
            try {
                refConnection = this.d;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.d = refConnection;
                }
                long j = refConnection.d + 1;
                refConnection.d = j;
                if (!refConnection.e && j == ((long) 0)) {
                    refConnection.e = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        new RefCountSubscriber(flowableSubscriber, this, refConnection);
        throw null;
    }

    public final void e(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.d == 0 && refConnection == this.d) {
                    this.d = null;
                    DisposableHelper.dispose(refConnection);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
