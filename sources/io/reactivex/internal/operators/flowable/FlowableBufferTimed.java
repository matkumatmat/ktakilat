package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    public static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        public Collection k;
        public Subscription l;
        public long m;

        public final boolean a(SerializedSubscriber serializedSubscriber, Object obj) {
            serializedSubscriber.onNext((Collection) obj);
            return true;
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                dispose();
                throw null;
            }
        }

        public final void dispose() {
            synchronized (this) {
                this.k = null;
            }
            this.l.cancel();
            throw null;
        }

        public final boolean isDisposed() {
            throw null;
        }

        public final void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.k;
                this.k = null;
            }
            this.f.offer(collection);
            this.i = true;
            if (b()) {
                QueueDrainHelper.c(this.f, this.e, this, this);
            }
            throw null;
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.k = null;
            }
            this.e.onError(th);
            throw null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            e(r0, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            throw null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            io.reactivex.exceptions.Exceptions.a(r6);
            cancel();
            r5.e.onError(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                java.util.Collection r0 = r5.k     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r6 = move-exception
                goto L_0x0030
            L_0x0009:
                r0.add(r6)     // Catch:{ all -> 0x0007 }
                int r6 = r0.size()     // Catch:{ all -> 0x0007 }
                if (r6 >= 0) goto L_0x0014
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                return
            L_0x0014:
                r6 = 0
                r5.k = r6     // Catch:{ all -> 0x0007 }
                long r1 = r5.m     // Catch:{ all -> 0x0007 }
                r3 = 1
                long r1 = r1 + r3
                r5.m = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                r5.e(r0, r5)
                throw r6     // Catch:{ all -> 0x0023 }
            L_0x0023:
                r6 = move-exception
                io.reactivex.exceptions.Exceptions.a(r6)
                r5.cancel()
                io.reactivex.subscribers.SerializedSubscriber r0 = r5.e
                r0.onError(r6)
                return
            L_0x0030:
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void run() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                this.e.onError(th);
            }
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        public Subscription k;
        public Collection l;

        public final boolean a(SerializedSubscriber serializedSubscriber, Object obj) {
            this.e.onNext((Collection) obj);
            return true;
        }

        public final void cancel() {
            this.g = true;
            this.k.cancel();
            DisposableHelper.dispose((AtomicReference<Disposable>) null);
        }

        public final void dispose() {
            cancel();
        }

        public final boolean isDisposed() {
            throw null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r3.f.offer(r1);
            r3.i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            if (b() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            io.reactivex.internal.util.QueueDrainHelper.c(r3.f, r3.e, (io.reactivex.disposables.Disposable) null, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r3 = this;
                r0 = 0
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r3)
                java.util.Collection r1 = r3.l     // Catch:{ all -> 0x000b }
                if (r1 != 0) goto L_0x000d
                monitor-exit(r3)     // Catch:{ all -> 0x000b }
                return
            L_0x000b:
                r0 = move-exception
                goto L_0x0026
            L_0x000d:
                r3.l = r0     // Catch:{ all -> 0x000b }
                monitor-exit(r3)     // Catch:{ all -> 0x000b }
                io.reactivex.internal.queue.MpscLinkedQueue r2 = r3.f
                r2.offer(r1)
                r1 = 1
                r3.i = r1
                boolean r1 = r3.b()
                if (r1 == 0) goto L_0x0025
                io.reactivex.internal.queue.MpscLinkedQueue r1 = r3.f
                io.reactivex.subscribers.SerializedSubscriber r2 = r3.e
                io.reactivex.internal.util.QueueDrainHelper.c(r1, r2, r0, r3)
            L_0x0025:
                return
            L_0x0026:
                monitor-exit(r3)     // Catch:{ all -> 0x000b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose((AtomicReference<Disposable>) null);
            synchronized (this) {
                this.l = null;
            }
            this.e.onError(th);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.l;
                    if (collection != null) {
                        collection.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    EmptySubscription.error(th, this.e);
                }
            }
        }

        public final void run() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                this.e.onError(th);
            }
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        public Subscription k;

        public final class RemoveFromBuffer implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public final boolean a(SerializedSubscriber serializedSubscriber, Object obj) {
            serializedSubscriber.onNext((Collection) obj);
            return true;
        }

        public final void cancel() {
            this.g = true;
            this.k.cancel();
            throw null;
        }

        public final void onComplete() {
            synchronized (this) {
                new ArrayList((Collection) null);
                throw null;
            }
        }

        public final void onError(Throwable th) {
            this.i = true;
            throw null;
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void run() {
            if (!this.g) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    throw null;
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
