package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        public boolean d;

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                this.d = true;
                dispose();
                throw null;
            }
        }
    }

    public static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        public Subscription k;
        public final AtomicReference l = new AtomicReference();
        public Collection m;

        public BufferBoundarySupplierSubscriber(SerializedSubscriber serializedSubscriber) {
            super(serializedSubscriber, new MpscLinkedQueue());
        }

        public final boolean a(SerializedSubscriber serializedSubscriber, Object obj) {
            this.e.onNext((Collection) obj);
            return true;
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                this.k.cancel();
                DisposableHelper.dispose(this.l);
                if (b()) {
                    this.f.clear();
                }
            }
        }

        public final void dispose() {
            this.k.cancel();
            DisposableHelper.dispose(this.l);
        }

        public final void i() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                this.e.onError(th);
            }
        }

        public final boolean isDisposed() {
            if (this.l.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
            r2.f.offer(r0);
            r2.i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (b() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            io.reactivex.internal.util.QueueDrainHelper.c(r2.f, r2.e, r2, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r2 = this;
                monitor-enter(r2)
                java.util.Collection r0 = r2.m     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r0 = move-exception
                goto L_0x0023
            L_0x0009:
                r1 = 0
                r2.m = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                io.reactivex.internal.queue.MpscLinkedQueue r1 = r2.f
                r1.offer(r0)
                r0 = 1
                r2.i = r0
                boolean r0 = r2.b()
                if (r0 == 0) goto L_0x0022
                io.reactivex.internal.queue.MpscLinkedQueue r0 = r2.f
                io.reactivex.subscribers.SerializedSubscriber r1 = r2.e
                io.reactivex.internal.util.QueueDrainHelper.c(r0, r1, r2, r2)
            L_0x0022:
                return
            L_0x0023:
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber.onComplete():void");
        }

        public final void onError(Throwable th) {
            cancel();
            this.e.onError(th);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.m;
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
                SerializedSubscriber serializedSubscriber = this.e;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.g = true;
                    subscription.cancel();
                    EmptySubscription.error(th, serializedSubscriber);
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(flowableSubscriber)));
    }
}
