package io.reactivex.internal.operators.mixed;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {

    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final SwitchMapMaybeObserver l = new SwitchMapMaybeObserver((SwitchMapMaybeSubscriber) null);
        private static final long serialVersionUID = -5402190102429853762L;
        public final FlowableSubscriber c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference f = new AtomicReference();
        public Subscription g;
        public volatile boolean i;
        public volatile boolean j;
        public long k;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public final SwitchMapMaybeSubscriber c;
            public volatile Object d;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber switchMapMaybeSubscriber) {
                this.c = switchMapMaybeSubscriber;
            }

            public final void onComplete() {
                SwitchMapMaybeSubscriber switchMapMaybeSubscriber = this.c;
                AtomicReference atomicReference = switchMapMaybeSubscriber.f;
                while (!atomicReference.compareAndSet(this, (Object) null)) {
                    if (atomicReference.get() != this) {
                        return;
                    }
                }
                switchMapMaybeSubscriber.b();
            }

            public final void onError(Throwable th) {
                SwitchMapMaybeSubscriber switchMapMaybeSubscriber = this.c;
                AtomicReference atomicReference = switchMapMaybeSubscriber.f;
                while (true) {
                    if (!atomicReference.compareAndSet(this, (Object) null)) {
                        if (atomicReference.get() != this) {
                            break;
                        }
                    } else if (switchMapMaybeSubscriber.d.addThrowable(th)) {
                        switchMapMaybeSubscriber.g.cancel();
                        switchMapMaybeSubscriber.a();
                        switchMapMaybeSubscriber.b();
                        return;
                    }
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                this.d = obj;
                this.c.b();
            }
        }

        public SwitchMapMaybeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            AtomicReference atomicReference = this.f;
            SwitchMapMaybeObserver switchMapMaybeObserver = l;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 != null && switchMapMaybeObserver2 != switchMapMaybeObserver) {
                DisposableHelper.dispose(switchMapMaybeObserver2);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0054 A[LOOP:1: B:26:0x0054->B:29:0x0060, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r12 = this;
                int r0 = r12.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.FlowableSubscriber r0 = r12.c
                io.reactivex.internal.util.AtomicThrowable r1 = r12.d
                java.util.concurrent.atomic.AtomicReference r2 = r12.f
                java.util.concurrent.atomic.AtomicLong r3 = r12.e
                long r4 = r12.k
                r6 = 1
                r7 = 1
            L_0x0013:
                boolean r8 = r12.j
                if (r8 == 0) goto L_0x0018
                return
            L_0x0018:
                java.lang.Object r8 = r1.get()
                if (r8 == 0) goto L_0x0026
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x0026:
                boolean r8 = r12.i
                java.lang.Object r9 = r2.get()
                io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver r9 = (io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber.SwitchMapMaybeObserver) r9
                if (r9 != 0) goto L_0x0032
                r10 = 1
                goto L_0x0033
            L_0x0032:
                r10 = 0
            L_0x0033:
                if (r8 == 0) goto L_0x0045
                if (r10 == 0) goto L_0x0045
                java.lang.Throwable r1 = r1.terminate()
                if (r1 == 0) goto L_0x0041
                r0.onError(r1)
                goto L_0x0044
            L_0x0041:
                r0.onComplete()
            L_0x0044:
                return
            L_0x0045:
                if (r10 != 0) goto L_0x006b
                java.lang.Object r8 = r9.d
                if (r8 == 0) goto L_0x006b
                long r10 = r3.get()
                int r8 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r8 != 0) goto L_0x0054
                goto L_0x006b
            L_0x0054:
                r8 = 0
                boolean r8 = r2.compareAndSet(r9, r8)
                if (r8 == 0) goto L_0x005c
                goto L_0x0062
            L_0x005c:
                java.lang.Object r8 = r2.get()
                if (r8 == r9) goto L_0x0054
            L_0x0062:
                java.lang.Object r8 = r9.d
                r0.onNext(r8)
                r8 = 1
                long r4 = r4 + r8
                goto L_0x0013
            L_0x006b:
                r12.k = r4
                int r7 = -r7
                int r7 = r12.addAndGet(r7)
                if (r7 != 0) goto L_0x0013
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber.b():void");
        }

        public final void cancel() {
            this.j = true;
            this.g.cancel();
            a();
        }

        public final void onComplete() {
            this.i = true;
            b();
        }

        public final void onError(Throwable th) {
            if (this.d.addThrowable(th)) {
                a();
                this.i = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            AtomicReference atomicReference = this.f;
            SwitchMapMaybeObserver switchMapMaybeObserver = (SwitchMapMaybeObserver) atomicReference.get();
            if (switchMapMaybeObserver != null) {
                DisposableHelper.dispose(switchMapMaybeObserver);
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.g.cancel();
                atomicReference.getAndSet(l);
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.e, j2);
            b();
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new SwitchMapMaybeSubscriber(flowableSubscriber);
        throw null;
    }
}
