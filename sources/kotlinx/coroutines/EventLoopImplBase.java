package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004\n\u000b\f\rR\u0013\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0004R\u0013\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00038\u0002X\u0004R\u000b\u0010\t\u001a\u00020\b8\u0002X\u0004¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/atomicfu/AtomicRef;", "", "_queue", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "DelayedTask", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 3 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n53#2:548\n51#3:549\n52#3,7:552\n27#4:550\n16#5:551\n1#6:559\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n263#1:548\n336#1:549\n336#1:552,7\n336#1:550\n336#1:551\n*E\n"})
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g;
    public static final /* synthetic */ AtomicReferenceFieldUpdater i;
    public static final /* synthetic */ AtomicIntegerFieldUpdater j;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n1#2:548\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuationImpl e;

        public DelayedResumeTask(long j, CancellableContinuationImpl cancellableContinuationImpl) {
            super(j);
            this.e = cancellableContinuationImpl;
        }

        public final void run() {
            this.e.A(EventLoopImplBase.this, Unit.f696a);
        }

        public final String toString() {
            return super.toString() + this.e;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DelayedRunnableTask extends DelayedTask {
        public final Runnable e;

        public DelayedRunnableTask(Runnable runnable, long j) {
            super(j);
            this.e = runnable;
        }

        public final void run() {
            this.e.run();
        }

        public final String toString() {
            return super.toString() + this.e;
        }
    }

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,547:1\n27#2:548\n27#2:551\n27#2:560\n16#3:549\n16#3:552\n16#3:561\n63#4:550\n64#4,7:553\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n441#1:548\n443#1:551\n483#1:560\n441#1:549\n443#1:552\n483#1:561\n443#1:550\n443#1:553,7\n*E\n"})
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "_heap", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        @Nullable
        private volatile Object _heap;
        public long c;
        public int d = -1;

        public DelayedTask(long j) {
            this.c = j;
        }

        public final void c(DelayedTaskQueue delayedTaskQueue) {
            if (this._heap != EventLoop_commonKt.f768a) {
                this._heap = delayedTaskQueue;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        public final int compareTo(Object obj) {
            int i = ((this.c - ((DelayedTask) obj).c) > 0 ? 1 : ((this.c - ((DelayedTask) obj).c) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            return 0;
        }

        public final void d(int i) {
            this.d = i;
        }

        public final void dispose() {
            DelayedTaskQueue delayedTaskQueue;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    Symbol symbol = EventLoop_commonKt.f768a;
                    if (obj != symbol) {
                        if (obj instanceof DelayedTaskQueue) {
                            delayedTaskQueue = (DelayedTaskQueue) obj;
                        } else {
                            delayedTaskQueue = null;
                        }
                        if (delayedTaskQueue != null) {
                            delayedTaskQueue.b(this);
                        }
                        this._heap = symbol;
                        Unit unit = Unit.f696a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final ThreadSafeHeap e() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public final int f(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            DelayedTask delayedTask;
            boolean z;
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.f768a) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue.f808a;
                        if (threadSafeHeapNodeArr != null) {
                            delayedTask = threadSafeHeapNodeArr[0];
                        } else {
                            delayedTask = null;
                        }
                        DelayedTask delayedTask2 = delayedTask;
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = EventLoopImplBase.g;
                        eventLoopImplBase.getClass();
                        if (EventLoopImplBase.j.get(eventLoopImplBase) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return 1;
                        }
                        if (delayedTask2 == null) {
                            delayedTaskQueue.c = j;
                        } else {
                            long j2 = delayedTask2.c;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - delayedTaskQueue.c > 0) {
                                delayedTaskQueue.c = j;
                            }
                        }
                        long j3 = this.c;
                        long j4 = delayedTaskQueue.c;
                        if (j3 - j4 < 0) {
                            this.c = j4;
                        }
                        delayedTaskQueue.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.c + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long c;
    }

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        Class<Object> cls2 = Object.class;
        g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue$volatile");
        i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed$volatile");
        j = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted$volatile");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[LOOP:1: B:13:0x002f->B:16:0x003a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long A() {
        /*
            r10 = this;
            boolean r0 = r10.C()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            r10.I()
        L_0x000c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = g
            java.lang.Object r3 = r0.get(r10)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.EventLoop_commonKt.b
            r5 = 0
            if (r3 != 0) goto L_0x0019
        L_0x0017:
            r7 = r5
            goto L_0x0049
        L_0x0019:
            boolean r6 = r3 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r6 == 0) goto L_0x003d
            r6 = r3
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r6
            java.lang.Object r7 = r6.d()
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.g
            if (r7 == r8) goto L_0x002b
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L_0x0049
        L_0x002b:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = r6.c()
        L_0x002f:
            boolean r4 = r0.compareAndSet(r10, r3, r6)
            if (r4 == 0) goto L_0x0036
            goto L_0x000c
        L_0x0036:
            java.lang.Object r4 = r0.get(r10)
            if (r4 == r3) goto L_0x002f
            goto L_0x000c
        L_0x003d:
            if (r3 != r4) goto L_0x0040
            goto L_0x0017
        L_0x0040:
            boolean r6 = r0.compareAndSet(r10, r3, r5)
            if (r6 == 0) goto L_0x00b9
            r7 = r3
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L_0x0049:
            if (r7 == 0) goto L_0x004f
            r7.run()
            return r1
        L_0x004f:
            kotlin.collections.ArrayDeque r3 = r10.e
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 != 0) goto L_0x005a
        L_0x0058:
            r8 = r6
            goto L_0x0062
        L_0x005a:
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0061
            goto L_0x0058
        L_0x0061:
            r8 = r1
        L_0x0062:
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0067
            goto L_0x00b8
        L_0x0067:
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L_0x008f
            boolean r3 = r0 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r3 == 0) goto L_0x008b
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f
            long r3 = r3.get(r0)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r3
            int r0 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r8
            r8 = 30
            long r3 = r3 >> r8
            int r4 = (int) r3
            if (r0 != r4) goto L_0x00b8
            goto L_0x008f
        L_0x008b:
            if (r0 != r4) goto L_0x00b8
        L_0x008d:
            r1 = r6
            goto L_0x00b8
        L_0x008f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x008d
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r3 = r0.f808a     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x00a1
            r4 = 0
            r5 = r3[r4]     // Catch:{ all -> 0x00b5 }
        L_0x00a1:
            monitor-exit(r0)
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5
            if (r5 != 0) goto L_0x00a7
            goto L_0x008d
        L_0x00a7:
            long r3 = r5.c
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b3
            goto L_0x00b8
        L_0x00b3:
            r1 = r3
            goto L_0x00b8
        L_0x00b5:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x00b8:
            return r1
        L_0x00b9:
            java.lang.Object r6 = r0.get(r10)
            if (r6 == r3) goto L_0x0040
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.A():long");
    }

    public void H(Runnable runnable) {
        I();
        if (J(runnable)) {
            Thread F = F();
            if (Thread.currentThread() != F) {
                LockSupport.unpark(F);
                return;
            }
            return;
        }
        DefaultExecutor.k.H(runnable);
    }

    public final void I() {
        ThreadSafeHeapNode threadSafeHeapNode;
        DelayedTask delayedTask;
        boolean z;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) i.get(this);
        if (delayedTaskQueue != null && ThreadSafeHeap.b.get(delayedTaskQueue) != 0) {
            long nanoTime = System.nanoTime();
            do {
                synchronized (delayedTaskQueue) {
                    try {
                        ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue.f808a;
                        threadSafeHeapNode = null;
                        if (threadSafeHeapNodeArr != null) {
                            delayedTask = threadSafeHeapNodeArr[0];
                        } else {
                            delayedTask = null;
                        }
                        if (delayedTask != null) {
                            DelayedTask delayedTask2 = delayedTask;
                            if (nanoTime - delayedTask2.c >= 0) {
                                z = J(delayedTask2);
                            } else {
                                z = false;
                            }
                            if (z) {
                                threadSafeHeapNode = delayedTaskQueue.c(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((DelayedTask) threadSafeHeapNode) != null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[LOOP:2: B:21:0x003f->B:24:0x004a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean J(java.lang.Runnable r7) {
        /*
            r6 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = g
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = j
            int r2 = r2.get(r6)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0016
            return r3
        L_0x0016:
            if (r1 != 0) goto L_0x0027
        L_0x0018:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L_0x0020
            return r4
        L_0x0020:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L_0x0018
            goto L_0x0000
        L_0x0027:
            boolean r2 = r1 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r2 == 0) goto L_0x004e
            r2 = r1
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r2
            int r5 = r2.a(r7)
            if (r5 == 0) goto L_0x004d
            if (r5 == r4) goto L_0x003b
            r0 = 2
            if (r5 == r0) goto L_0x003a
            goto L_0x0000
        L_0x003a:
            return r3
        L_0x003b:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = r2.c()
        L_0x003f:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L_0x0046
            goto L_0x0000
        L_0x0046:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L_0x003f
            goto L_0x0000
        L_0x004d:
            return r4
        L_0x004e:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.EventLoop_commonKt.b
            if (r1 != r2) goto L_0x0053
            return r3
        L_0x0053:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = new kotlinx.coroutines.internal.LockFreeTaskQueueCore
            r3 = 8
            r2.<init>(r3, r4)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r7)
        L_0x0063:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L_0x006a
            return r4
        L_0x006a:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L_0x0063
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.J(java.lang.Runnable):boolean");
    }

    public final boolean K() {
        boolean z;
        ArrayDeque arrayDeque = this.e;
        if (arrayDeque != null) {
            z = arrayDeque.isEmpty();
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) i.get(this);
        if (delayedTaskQueue != null && ThreadSafeHeap.b.get(delayedTaskQueue) != 0) {
            return false;
        }
        Object obj = g.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeTaskQueueCore) {
            long j2 = LockFreeTaskQueueCore.f.get((LockFreeTaskQueueCore) obj);
            if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == EventLoop_commonKt.b) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023 A[LOOP:0: B:10:0x0023->B:13:0x002e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(long r7, kotlinx.coroutines.EventLoopImplBase.DelayedTask r9) {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = j
            int r0 = r0.get(r6)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = i
            r4 = 0
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x003d
        L_0x0014:
            java.lang.Object r0 = r3.get(r6)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 != 0) goto L_0x0039
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r5 = new kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue
            r5.<init>()
            r5.c = r7
        L_0x0023:
            boolean r0 = r3.compareAndSet(r6, r4, r5)
            if (r0 == 0) goto L_0x002a
            goto L_0x0030
        L_0x002a:
            java.lang.Object r0 = r3.get(r6)
            if (r0 == 0) goto L_0x0023
        L_0x0030:
            java.lang.Object r0 = r3.get(r6)
            kotlin.jvm.internal.Intrinsics.c(r0)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
        L_0x0039:
            int r0 = r9.f(r7, r0, r6)
        L_0x003d:
            if (r0 == 0) goto L_0x0051
            if (r0 == r2) goto L_0x004d
            r7 = 2
            if (r0 != r7) goto L_0x0045
            goto L_0x0076
        L_0x0045:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "unexpected result"
            r7.<init>(r8)
            throw r7
        L_0x004d:
            r6.G(r7, r9)
            goto L_0x0076
        L_0x0051:
            java.lang.Object r7 = r3.get(r6)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r7 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r7
            if (r7 == 0) goto L_0x0067
            monitor-enter(r7)
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r8 = r7.f808a     // Catch:{ all -> 0x0064 }
            if (r8 == 0) goto L_0x0060
            r4 = r8[r1]     // Catch:{ all -> 0x0064 }
        L_0x0060:
            monitor-exit(r7)
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r4 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r4
            goto L_0x0067
        L_0x0064:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0067:
            if (r4 != r9) goto L_0x0076
            java.lang.Thread r7 = r6.F()
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            if (r8 == r7) goto L_0x0076
            java.util.concurrent.locks.LockSupport.unpark(r7)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.L(long, kotlinx.coroutines.EventLoopImplBase$DelayedTask):void");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        H(runnable);
    }

    public final void h(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        long a2 = EventLoop_commonKt.a(j2);
        if (a2 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(a2 + nanoTime, cancellableContinuationImpl);
            L(nanoTime, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuationImpl, delayedResumeTask);
        }
    }

    public DisposableHandle m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(j2, runnable, coroutineContext);
    }

    public void shutdown() {
        ThreadSafeHeapNode threadSafeHeapNode;
        ThreadLocalEventLoop.f771a.set((Object) null);
        j.set(this, 1);
        loop0:
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = EventLoop_commonKt.b;
            if (obj != null) {
                if (!(obj instanceof LockFreeTaskQueueCore)) {
                    if (obj != symbol) {
                        LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                        lockFreeTaskQueueCore.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((LockFreeTaskQueueCore) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                }
            }
            break loop0;
        }
        do {
        } while (A() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) i.get(this);
            if (delayedTaskQueue != null) {
                synchronized (delayedTaskQueue) {
                    if (ThreadSafeHeap.b.get(delayedTaskQueue) > 0) {
                        threadSafeHeapNode = delayedTaskQueue.c(0);
                    } else {
                        threadSafeHeapNode = null;
                    }
                }
                DelayedTask delayedTask = (DelayedTask) threadSafeHeapNode;
                if (delayedTask != null) {
                    G(nanoTime, delayedTask);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
