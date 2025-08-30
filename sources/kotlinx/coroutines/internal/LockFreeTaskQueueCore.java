package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,304:1\n295#2,3:305\n295#2,3:308\n295#2,3:311\n295#2,3:314\n295#2,3:317\n295#2,3:321\n295#2,3:324\n1#3:320\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n87#1:305,3\n88#1:308,3\n103#1:311,3\n163#1:314,3\n196#1:317,3\n227#1:321,3\n243#1:324,3\n*E\n"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\t\nR\u0019\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00000\u00038\u0002X\u0004R\u000b\u0010\u0006\u001a\u00020\u00058\u0002X\u0004R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0002X\u0004¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "Lkotlinx/atomicfu/AtomicRef;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "array", "Placeholder", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LockFreeTaskQueueCore<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e;
    public static final /* synthetic */ AtomicLongFieldUpdater f;
    public static final Symbol g = new Symbol("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a  reason: collision with root package name */
    public final int f799a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "", "INITIAL_CAPACITY", "I", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "", "HEAD_MASK", "J", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Placeholder {

        /* renamed from: a  reason: collision with root package name */
        public final int f800a;

        public Placeholder(int i) {
            this.f800a = i;
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next$volatile");
        f = AtomicLongFieldUpdater.newUpdater(cls, "_state$volatile");
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.f799a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        } else if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) == 0) {
                int i = (int) (1073741823 & j);
                int i2 = (int) ((1152921503533105152L & j) >> 30);
                int i3 = this.c;
                if (((i2 + 2) & i3) == (i & i3)) {
                    return 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.d;
                if (this.b || atomicReferenceArray.get(i2 & i3) == null) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j, (-1152921503533105153L & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                        atomicReferenceArray.set(i2 & i3, runnable);
                        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                        while ((atomicLongFieldUpdater.get(lockFreeTaskQueueCore) & 1152921504606846976L) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.c();
                            AtomicReferenceArray atomicReferenceArray2 = lockFreeTaskQueueCore.d;
                            int i4 = lockFreeTaskQueueCore.c & i2;
                            Object obj = atomicReferenceArray2.get(i4);
                            if (!(obj instanceof Placeholder) || ((Placeholder) obj).f800a != i2) {
                                lockFreeTaskQueueCore = null;
                                continue;
                            } else {
                                atomicReferenceArray2.set(i4, runnable);
                                continue;
                            }
                            if (lockFreeTaskQueueCore == null) {
                                return 0;
                            }
                        }
                        return 0;
                    }
                } else {
                    int i5 = this.f799a;
                    if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                        return 1;
                    }
                }
            } else if ((2305843009213693952L & j) != 0) {
                return 2;
            } else {
                return 1;
            }
        }
        return 1;
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[LOOP:3: B:16:0x006a->B:19:0x0076, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeTaskQueueCore c() {
        /*
            r10 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = f
            long r2 = r6.get(r10)
            r0 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r0
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0011
            goto L_0x001d
        L_0x0011:
            long r7 = r2 | r0
            r0 = r6
            r1 = r10
            r4 = r7
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            r2 = r7
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = e
            java.lang.Object r1 = r0.get(r10)
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r1 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r1
            if (r1 == 0) goto L_0x0028
            return r1
        L_0x0028:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r1 = new kotlinx.coroutines.internal.LockFreeTaskQueueCore
            int r4 = r10.f799a
            int r4 = r4 * 2
            boolean r5 = r10.b
            r1.<init>(r4, r5)
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            int r5 = (int) r4
            r7 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r7 = r7 & r2
            r4 = 30
            long r7 = r7 >> r4
            int r4 = (int) r7
        L_0x0042:
            int r7 = r10.c
            r8 = r5 & r7
            r7 = r7 & r4
            if (r8 == r7) goto L_0x0061
            java.util.concurrent.atomic.AtomicReferenceArray r7 = r10.d
            java.lang.Object r7 = r7.get(r8)
            if (r7 != 0) goto L_0x0056
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Placeholder r7 = new kotlinx.coroutines.internal.LockFreeTaskQueueCore$Placeholder
            r7.<init>(r5)
        L_0x0056:
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r1.d
            int r9 = r1.c
            r9 = r9 & r5
            r8.set(r9, r7)
            int r5 = r5 + 1
            goto L_0x0042
        L_0x0061:
            r4 = -1152921504606846977(0xefffffffffffffff, double:-3.1050361846014175E231)
            long r4 = r4 & r2
            r6.set(r1, r4)
        L_0x006a:
            r4 = 0
            boolean r4 = r0.compareAndSet(r10, r4, r1)
            if (r4 == 0) goto L_0x0072
            goto L_0x001d
        L_0x0072:
            java.lang.Object r4 = r0.get(r10)
            if (r4 == 0) goto L_0x006a
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.c():kotlinx.coroutines.internal.LockFreeTaskQueueCore");
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return g;
            }
            int i = (int) (j & 1073741823);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            int i4 = i & i3;
            if ((i2 & i3) == i4) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.d;
            Object obj = atomicReferenceArray.get(i4);
            boolean z = this.b;
            if (obj == null) {
                if (z) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                long j2 = (long) ((i + 1) & 1073741823);
                Object obj2 = obj;
                boolean z2 = z;
                if (atomicLongFieldUpdater.compareAndSet(this, j, (j & -1073741824) | j2)) {
                    atomicReferenceArray.set(i4, (Object) null);
                    return obj2;
                } else if (z2) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f;
                        long j3 = atomicLongFieldUpdater2.get(lockFreeTaskQueueCore);
                        int i5 = (int) (j3 & 1073741823);
                        if ((j3 & 1152921504606846976L) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(lockFreeTaskQueueCore, j3, (j3 & -1073741824) | j2)) {
                                lockFreeTaskQueueCore.d.set(lockFreeTaskQueueCore.c & i5, (Object) null);
                                lockFreeTaskQueueCore = null;
                            } else {
                                continue;
                            }
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return obj2;
                        }
                    }
                }
            }
        }
    }
}
