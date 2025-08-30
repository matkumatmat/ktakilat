package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n27#2:160\n27#2:162\n27#2:164\n27#2:166\n27#2:168\n27#2:170\n27#2:172\n16#3:161\n16#3:163\n16#3:165\n16#3:167\n16#3:169\n16#3:171\n16#3:173\n1#4:174\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n33#1:160\n41#1:162\n43#1:164\n51#1:166\n60#1:168\n63#1:170\n72#1:172\n33#1:161\n41#1:163\n43#1:165\n51#1:167\n60#1:169\n63#1:171\n72#1:173\n*E\n"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005R\u000b\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a  reason: collision with root package name */
    public ThreadSafeHeapNode[] f808a;

    public final void a(EventLoopImplBase.DelayedTask delayedTask) {
        delayedTask.c((EventLoopImplBase.DelayedTaskQueue) this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f808a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (threadSafeHeapNodeArr == null) {
            threadSafeHeapNodeArr = new ThreadSafeHeapNode[4];
            this.f808a = threadSafeHeapNodeArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= threadSafeHeapNodeArr.length) {
            Object[] copyOf = Arrays.copyOf(threadSafeHeapNodeArr, atomicIntegerFieldUpdater.get(this) * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            threadSafeHeapNodeArr = (ThreadSafeHeapNode[]) copyOf;
            this.f808a = threadSafeHeapNodeArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        threadSafeHeapNodeArr[i] = delayedTask;
        delayedTask.d = i;
        d(i);
    }

    public final void b(EventLoopImplBase.DelayedTask delayedTask) {
        synchronized (this) {
            if (delayedTask.e() != null) {
                c(delayedTask.d);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (((java.lang.Comparable) r6).compareTo(r7) < 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.ThreadSafeHeapNode c(int r9) {
        /*
            r8 = this;
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r0 = r8.f808a
            kotlin.jvm.internal.Intrinsics.c(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L_0x0080
            int r2 = r1.get(r8)
            r8.e(r9, r2)
            int r2 = r9 + -1
            int r2 = r2 / 2
            if (r9 <= 0) goto L_0x003c
            r4 = r0[r9]
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r0[r2]
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L_0x003c
            r8.e(r9, r2)
            r8.d(r2)
            goto L_0x0080
        L_0x003c:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L_0x0047
            goto L_0x0080
        L_0x0047:
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r5 = r8.f808a
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L_0x0067
            r6 = r5[r2]
            kotlin.jvm.internal.Intrinsics.c(r6)
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            r7 = r5[r4]
            kotlin.jvm.internal.Intrinsics.c(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r2 = r4
        L_0x0068:
            r4 = r5[r9]
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r5[r2]
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L_0x007b
            goto L_0x0080
        L_0x007b:
            r8.e(r9, r2)
            r9 = r2
            goto L_0x003c
        L_0x0080:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.Intrinsics.c(r9)
            r2 = 0
            r9.c(r2)
            r9.d(r3)
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.c(int):kotlinx.coroutines.internal.ThreadSafeHeapNode");
    }

    public final void d(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f808a;
            Intrinsics.c(threadSafeHeapNodeArr);
            int i2 = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
            Intrinsics.c(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
            Intrinsics.c(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) > 0) {
                e(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void e(int i, int i2) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f808a;
        Intrinsics.c(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
        Intrinsics.c(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
        Intrinsics.c(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode2;
        threadSafeHeapNode.d(i);
        threadSafeHeapNode2.d(i2);
    }
}
