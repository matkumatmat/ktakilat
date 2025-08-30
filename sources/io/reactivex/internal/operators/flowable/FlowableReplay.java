package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, Disposable {
    public static final Callable d = null;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public Node c;
        public int d;
        public long e;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            if (r14.isDisposed() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            r2 = r14.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r2 != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r14.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            if (r5 != null) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            r5 = c();
            r14.e = r5;
            io.reactivex.internal.util.BackpressureHelper.a(r14.f, r5.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
            if (r2 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            r10 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
            if (r10 == null) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
            r5 = d(r10.c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r5, r14.d) == false) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            r14.e = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
            r8 = r8 + 1;
            r2 = r2 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
            if (r14.isDisposed() == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
            r5 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
            io.reactivex.exceptions.Exceptions.a(r0);
            r14.e = null;
            r14.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r5) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007e, code lost:
            r14.d.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
            if (r8 == 0) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
            r14.e = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
            if (r4 != false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
            io.reactivex.internal.util.BackpressureHelper.f(r14, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008f, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0092, code lost:
            if (r14.i != false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0094, code lost:
            r14.g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0096, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0097, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0098, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x009a, code lost:
            r14.i = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x009c, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription r14) {
            /*
                r13 = this;
                monitor-enter(r14)
                boolean r0 = r14.g     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r14.i = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x00a1
            L_0x000d:
                r14.g = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
            L_0x0010:
                boolean r0 = r14.isDisposed()
                if (r0 == 0) goto L_0x0017
                return
            L_0x0017:
                long r2 = r14.get()
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0027
                r4 = 1
                goto L_0x0028
            L_0x0027:
                r4 = 0
            L_0x0028:
                java.io.Serializable r5 = r14.e
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
                if (r5 != 0) goto L_0x003d
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r5 = r13.c()
                r14.e = r5
                java.util.concurrent.atomic.AtomicLong r8 = r14.f
                long r9 = r5.d
                io.reactivex.internal.util.BackpressureHelper.a(r8, r9)
            L_0x003d:
                r8 = r6
            L_0x003e:
                int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r10 == 0) goto L_0x0084
                java.lang.Object r10 = r5.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r10 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r10
                if (r10 == 0) goto L_0x0084
                java.lang.Object r5 = r10.c
                java.lang.Object r5 = r13.d(r5)
                r11 = 0
                org.reactivestreams.Subscriber r12 = r14.d     // Catch:{ all -> 0x0069 }
                boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r5, r12)     // Catch:{ all -> 0x0069 }
                if (r12 == 0) goto L_0x005c
                r14.e = r11     // Catch:{ all -> 0x0069 }
                return
            L_0x005c:
                r11 = 1
                long r8 = r8 + r11
                long r2 = r2 - r11
                boolean r5 = r14.isDisposed()
                if (r5 == 0) goto L_0x0067
                return
            L_0x0067:
                r5 = r10
                goto L_0x003e
            L_0x0069:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.a(r0)
                r14.e = r11
                r14.dispose()
                boolean r1 = io.reactivex.internal.util.NotificationLite.isError(r5)
                if (r1 != 0) goto L_0x0083
                boolean r1 = io.reactivex.internal.util.NotificationLite.isComplete(r5)
                if (r1 != 0) goto L_0x0083
                org.reactivestreams.Subscriber r14 = r14.d
                r14.onError(r0)
            L_0x0083:
                return
            L_0x0084:
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x008f
                r14.e = r5
                if (r4 != 0) goto L_0x008f
                io.reactivex.internal.util.BackpressureHelper.f(r14, r8)
            L_0x008f:
                monitor-enter(r14)
                boolean r2 = r14.i     // Catch:{ all -> 0x0098 }
                if (r2 != 0) goto L_0x009a
                r14.g = r0     // Catch:{ all -> 0x0098 }
                monitor-exit(r14)     // Catch:{ all -> 0x0098 }
                return
            L_0x0098:
                r0 = move-exception
                goto L_0x009f
            L_0x009a:
                r14.i = r0     // Catch:{ all -> 0x0098 }
                monitor-exit(r14)     // Catch:{ all -> 0x0098 }
                goto L_0x0010
            L_0x009f:
                monitor-exit(r14)     // Catch:{ all -> 0x0098 }
                throw r0
            L_0x00a1:
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.a(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        public Object b(Object obj) {
            return obj;
        }

        public Node c() {
            return (Node) get();
        }

        public final void complete() {
            Object b = b(NotificationLite.complete());
            long j = this.e + 1;
            this.e = j;
            Node node = new Node(b, j);
            this.c.set(node);
            this.c = node;
            this.d++;
            f();
        }

        public Object d(Object obj) {
            return obj;
        }

        public void e() {
        }

        public final void error(Throwable th) {
            Object b = b(NotificationLite.error(th));
            long j = this.e + 1;
            this.e = j;
            Node node = new Node(b, j);
            this.c.set(node);
            this.c = node;
            this.d++;
            f();
        }

        public void f() {
            Node node = (Node) get();
            if (node.c != null) {
                Node node2 = new Node((Object) null, 0);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public final void next(Object obj) {
            Object b = b(NotificationLite.next(obj));
            long j = this.e + 1;
            this.e = j;
            Node node = new Node(b, j);
            this.c.set(node);
            this.c = node;
            this.d++;
            e();
        }
    }

    public static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        public final void b(FlowableSubscriber flowableSubscriber) {
            throw null;
        }
    }

    public static final class DefaultUnboundedFactory implements Callable<Object> {
        public final Object call() {
            return new ArrayList(16);
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;
        public final ReplaySubscriber c;
        public final Subscriber d;
        public Serializable e;
        public final AtomicLong f = new AtomicLong();
        public boolean g;
        public boolean i;

        public InnerSubscription(ReplaySubscriber replaySubscriber, Subscriber subscriber) {
            this.c = replaySubscriber;
            this.d = subscriber;
        }

        public final void cancel() {
            dispose();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dispose() {
            /*
                r8 = this;
                r0 = -9223372036854775808
                long r2 = r8.getAndSet(r0)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 == 0) goto L_0x0052
                io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = r8.c
            L_0x000c:
                java.util.concurrent.atomic.AtomicReference r1 = r0.e
                java.lang.Object r2 = r1.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription[] r2 = (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[]) r2
                int r3 = r2.length
                if (r3 != 0) goto L_0x0018
                goto L_0x0047
            L_0x0018:
                r4 = 0
                r5 = 0
            L_0x001a:
                if (r5 >= r3) goto L_0x0028
                r6 = r2[r5]
                boolean r6 = r6.equals(r8)
                if (r6 == 0) goto L_0x0025
                goto L_0x0029
            L_0x0025:
                int r5 = r5 + 1
                goto L_0x001a
            L_0x0028:
                r5 = -1
            L_0x0029:
                if (r5 >= 0) goto L_0x002c
                goto L_0x0047
            L_0x002c:
                r6 = 1
                if (r3 != r6) goto L_0x0032
                io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription[] r3 = io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber.j
                goto L_0x0041
            L_0x0032:
                int r7 = r3 + -1
                io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription[] r7 = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[r7]
                java.lang.System.arraycopy(r2, r4, r7, r4, r5)
                int r4 = r5 + 1
                int r3 = r3 - r5
                int r3 = r3 - r6
                java.lang.System.arraycopy(r2, r4, r7, r5, r3)
                r3 = r7
            L_0x0041:
                boolean r4 = r1.compareAndSet(r2, r3)
                if (r4 == 0) goto L_0x004b
            L_0x0047:
                r0.a()
                goto L_0x0052
            L_0x004b:
                java.lang.Object r4 = r1.get()
                if (r4 == r2) goto L_0x0041
                goto L_0x000c
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription.dispose():void");
        }

        public final boolean isDisposed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.b(this, j) != Long.MIN_VALUE) {
                BackpressureHelper.a(this.f, j);
                ReplaySubscriber replaySubscriber = this.c;
                replaySubscriber.a();
                replaySubscriber.c.a(this);
            }
        }
    }

    public static final class MulticastFlowable<R, U> extends Flowable<R> {

        public final class DisposableConsumer implements Consumer<Disposable> {
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                throw null;
            }
        }

        public final void b(FlowableSubscriber flowableSubscriber) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptySubscription.error(th, flowableSubscriber);
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object c;
        public final long d;

        public Node(Object obj, long j) {
            this.c = obj;
            this.d = j;
        }
    }

    public interface ReplayBuffer<T> {
        void a(InnerSubscription innerSubscription);

        void complete();

        void error(Throwable th);

        void next(Object obj);
    }

    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class ReplayPublisher<T> implements Publisher<T> {
        public final void d(Subscriber subscriber) {
            throw null;
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        public static final InnerSubscription[] j = new InnerSubscription[0];
        public static final InnerSubscription[] k = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        public final ReplayBuffer c;
        public boolean d;
        public final AtomicReference e = new AtomicReference(j);
        public final AtomicInteger f = new AtomicInteger();
        public long g;
        public long i;

        public ReplaySubscriber(ReplayBuffer replayBuffer) {
            this.c = replayBuffer;
            new AtomicBoolean();
        }

        public final void a() {
            AtomicInteger atomicInteger = this.f;
            if (atomicInteger.getAndIncrement() == 0) {
                int i2 = 1;
                while (!isDisposed()) {
                    InnerSubscription[] innerSubscriptionArr = (InnerSubscription[]) this.e.get();
                    long j2 = this.g;
                    long j3 = j2;
                    for (InnerSubscription innerSubscription : innerSubscriptionArr) {
                        j3 = Math.max(j3, innerSubscription.f.get());
                    }
                    long j4 = this.i;
                    Subscription subscription = (Subscription) get();
                    long j5 = j3 - j2;
                    if (j5 != 0) {
                        this.g = j3;
                        if (subscription == null) {
                            long j6 = j4 + j5;
                            if (j6 < 0) {
                                j6 = LocationRequestCompat.PASSIVE_INTERVAL;
                            }
                            this.i = j6;
                        } else if (j4 != 0) {
                            this.i = 0;
                            subscription.request(j4 + j5);
                        } else {
                            subscription.request(j5);
                        }
                    } else if (!(j4 == 0 || subscription == null)) {
                        this.i = 0;
                        subscription.request(j4);
                    }
                    i2 = atomicInteger.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public final void dispose() {
            this.e.set(k);
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            if (this.e.get() == k) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.complete();
                for (InnerSubscription a2 : (InnerSubscription[]) this.e.getAndSet(k)) {
                    replayBuffer.a(a2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.d) {
                this.d = true;
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.error(th);
                for (InnerSubscription a2 : (InnerSubscription[]) this.e.getAndSet(k)) {
                    replayBuffer.a(a2);
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.next(obj);
                for (InnerSubscription a2 : (InnerSubscription[]) this.e.get()) {
                    replayBuffer.a(a2);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                a();
                for (InnerSubscription a2 : (InnerSubscription[]) this.e.get()) {
                    this.c.a(a2);
                }
            }
        }
    }

    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        public final Object b(Object obj) {
            throw null;
        }

        public final Node c() {
            throw null;
        }

        public final Object d(Object obj) {
            return ((Timed) obj).f689a;
        }

        public final void e() {
            throw null;
        }

        public final void f() {
            throw null;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        public final void e() {
            if (this.d > 0) {
                Node node = (Node) ((Node) get()).get();
                if (node != null) {
                    this.d--;
                    set(node);
                    return;
                }
                throw new IllegalStateException("Empty list!");
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int c;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r0 = r15.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            if (r15.isDisposed() == false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
            r1 = r14.c;
            r2 = (java.lang.Integer) r15.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r2 == null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
            r2 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
            r4 = r15.get();
            r8 = r4;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
            if (r8 == 0) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
            if (r2 >= r1) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0045, code lost:
            if (r15.isDisposed() == false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0047, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
            r2 = r2 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
            io.reactivex.exceptions.Exceptions.a(r1);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r12) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
            r0.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0068, code lost:
            if (r10 == 0) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x006a, code lost:
            r15.e = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
            if (r4 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0079, code lost:
            io.reactivex.internal.util.BackpressureHelper.f(r15, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007c, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x007f, code lost:
            if (r15.i != false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0081, code lost:
            r15.g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0083, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0084, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0085, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0087, code lost:
            r15.i = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0089, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x008c, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.g     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r15.i = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x008d
            L_0x000d:
                r15.g = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                org.reactivestreams.Subscriber r0 = r15.d
            L_0x0012:
                boolean r1 = r15.isDisposed()
                if (r1 == 0) goto L_0x0019
                return
            L_0x0019:
                int r1 = r14.c
                java.io.Serializable r2 = r15.e
                java.lang.Integer r2 = (java.lang.Integer) r2
                r3 = 0
                if (r2 == 0) goto L_0x0027
                int r2 = r2.intValue()
                goto L_0x0028
            L_0x0027:
                r2 = 0
            L_0x0028:
                long r4 = r15.get()
                r6 = 0
                r8 = r4
                r10 = r6
            L_0x0030:
                int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0066
                if (r2 >= r1) goto L_0x0066
                java.lang.Object r12 = r14.get(r2)
                boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r12, r0)     // Catch:{ all -> 0x004f }
                if (r12 == 0) goto L_0x0041
                return
            L_0x0041:
                boolean r12 = r15.isDisposed()
                if (r12 == 0) goto L_0x0048
                return
            L_0x0048:
                int r2 = r2 + 1
                r12 = 1
                long r8 = r8 - r12
                long r10 = r10 + r12
                goto L_0x0030
            L_0x004f:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.a(r1)
                r15.dispose()
                boolean r15 = io.reactivex.internal.util.NotificationLite.isError(r12)
                if (r15 != 0) goto L_0x0065
                boolean r15 = io.reactivex.internal.util.NotificationLite.isComplete(r12)
                if (r15 != 0) goto L_0x0065
                r0.onError(r1)
            L_0x0065:
                return
            L_0x0066:
                int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x007c
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r15.e = r1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r6 == 0) goto L_0x007c
                io.reactivex.internal.util.BackpressureHelper.f(r15, r10)
            L_0x007c:
                monitor-enter(r15)
                boolean r1 = r15.i     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0087
                r15.g = r3     // Catch:{ all -> 0x0085 }
                monitor-exit(r15)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r0 = move-exception
                goto L_0x008b
            L_0x0087:
                r15.i = r3     // Catch:{ all -> 0x0085 }
                monitor-exit(r15)     // Catch:{ all -> 0x0085 }
                goto L_0x0012
            L_0x008b:
                monitor-exit(r15)     // Catch:{ all -> 0x0085 }
                throw r0
            L_0x008d:
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.a(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        public final void complete() {
            add(NotificationLite.complete());
            this.c++;
        }

        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.c++;
        }

        public final void next(Object obj) {
            add(NotificationLite.next(obj));
            this.c++;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }

    public final void dispose() {
        throw null;
    }

    public final boolean isDisposed() {
        throw null;
    }
}
