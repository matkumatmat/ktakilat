package kotlinx.coroutines.sync;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001R\u0011\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004R\u000b\u0010\u0006\u001a\u00020\u00058\u0002X\u0004R\u0011\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004R\u000b\u0010\b\u001a\u00020\u00058\u0002X\u0004R\u000b\u0010\n\u001a\u00020\t8\u0002X\u0004¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "tail", "enqIdx", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreAndMutexImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,396:1\n200#1,10:410\n200#1,10:420\n1#2:397\n369#3,12:398\n68#4,3:430\n42#4,8:433\n68#4,3:444\n42#4,8:447\n374#5:441\n374#5:442\n366#5:443\n377#5:455\n366#5:456\n374#5:457\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreAndMutexImpl\n*L\n192#1:410,10\n216#1:420,10\n182#1:398,12\n284#1:430,3\n284#1:433,8\n317#1:444,3\n317#1:447,8\n288#1:441\n294#1:442\n308#1:443\n323#1:455\n329#1:456\n332#1:457\n*E\n"})
public class SemaphoreAndMutexImpl {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ AtomicLongFieldUpdater d;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e;
    public static final /* synthetic */ AtomicLongFieldUpdater f;
    public static final /* synthetic */ AtomicIntegerFieldUpdater g;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a  reason: collision with root package name */
    public final int f822a;
    public final l1 b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        Class<SemaphoreAndMutexImpl> cls = SemaphoreAndMutexImpl.class;
        Class<Object> cls2 = Object.class;
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head$volatile");
        d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail$volatile");
        f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits$volatile");
    }

    public SemaphoreAndMutexImpl(int i, int i2) {
        this.f822a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(ba.k(i, "Semaphore should have at least 1 permit, but had ").toString());
        } else if (i2 < 0 || i2 > i) {
            throw new IllegalArgumentException(ba.k(i, "The number of acquired permits should be in 0..").toString());
        } else {
            SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, (SemaphoreSegment) null, 2);
            this.head$volatile = semaphoreSegment;
            this.tail$volatile = semaphoreSegment;
            this._availablePermits$volatile = i - i2;
            this.b = new l1(this, 2);
        }
    }

    public final Object e(ContinuationImpl continuationImpl) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int andDecrement;
        int i;
        do {
            atomicIntegerFieldUpdater = g;
            andDecrement = atomicIntegerFieldUpdater.getAndDecrement(this);
            i = this.f822a;
        } while (andDecrement > i);
        if (andDecrement > 0) {
            return Unit.f696a;
        }
        CancellableContinuationImpl b2 = CancellableContinuationKt.b(IntrinsicsKt.b(continuationImpl));
        try {
            if (!f(b2)) {
                while (true) {
                    int andDecrement2 = atomicIntegerFieldUpdater.getAndDecrement(this);
                    if (andDecrement2 <= i) {
                        if (andDecrement2 > 0) {
                            b2.l(Unit.f696a, this.b);
                            break;
                        } else if (f(b2)) {
                            break;
                        }
                    }
                }
            }
            Object p = b2.p();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (p == coroutineSingletons) {
                Intrinsics.checkNotNullParameter(continuationImpl, TypedValues.AttributesType.S_FRAME);
            }
            if (p != coroutineSingletons) {
                p = Unit.f696a;
            }
            if (p == coroutineSingletons) {
                return p;
            }
            return Unit.f696a;
        } catch (Throwable th) {
            b2.y();
            throw th;
        }
    }

    public final boolean f(Waiter waiter) {
        Object a2;
        Waiter waiter2 = waiter;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.c;
        long j = andIncrement / ((long) SemaphoreKt.f);
        loop0:
        while (true) {
            a2 = ConcurrentLinkedListKt.a(semaphoreSegment, j, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (SegmentOrClosed.b(a2)) {
                break;
            }
            Segment a3 = SegmentOrClosed.a(a2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.e >= a3.e) {
                    break loop0;
                } else if (a3.j()) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, a3)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (a3.f()) {
                                a3.e();
                            }
                        }
                    }
                    if (segment.f()) {
                        segment.e();
                    }
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.a(a2);
        int i = (int) (andIncrement % ((long) SemaphoreKt.f));
        AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.g;
        while (!atomicReferenceArray.compareAndSet(i, (Object) null, waiter2)) {
            if (atomicReferenceArray.get(i) != null) {
                Symbol symbol = SemaphoreKt.b;
                Symbol symbol2 = SemaphoreKt.c;
                while (!atomicReferenceArray.compareAndSet(i, symbol, symbol2)) {
                    if (atomicReferenceArray.get(i) != symbol) {
                        return false;
                    }
                }
                if (waiter2 instanceof CancellableContinuation) {
                    ((CancellableContinuation) waiter2).l(Unit.f696a, this.b);
                } else if (waiter2 instanceof SelectInstance) {
                    ((SelectInstance) waiter2).e(Unit.f696a);
                } else {
                    throw new IllegalStateException(("unexpected: " + waiter2).toString());
                }
                return true;
            }
        }
        waiter2.b(semaphoreSegment2, i);
        return true;
    }

    public final void release() {
        int i;
        Object a2;
        boolean z;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i2 = this.f822a;
            if (andIncrement >= i2) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i2 || atomicIntegerFieldUpdater.compareAndSet(this, i, i2)) {
                    }
                    i = atomicIntegerFieldUpdater.get(this);
                    break;
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i2).toString());
            } else if (andIncrement < 0) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
                SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
                long andIncrement2 = d.getAndIncrement(this);
                long j = andIncrement2 / ((long) SemaphoreKt.f);
                SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.c;
                while (true) {
                    a2 = ConcurrentLinkedListKt.a(semaphoreSegment, j, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
                    if (SegmentOrClosed.b(a2)) {
                        break;
                    }
                    Segment a3 = SegmentOrClosed.a(a2);
                    while (true) {
                        Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                        if (segment.e >= a3.e) {
                            break;
                        } else if (a3.j()) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, a3)) {
                                if (atomicReferenceFieldUpdater.get(this) != segment) {
                                    if (a3.f()) {
                                        a3.e();
                                    }
                                }
                            }
                            if (segment.f()) {
                                segment.e();
                            }
                        }
                    }
                }
                SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.a(a2);
                semaphoreSegment2.a();
                z = false;
                if (semaphoreSegment2.e <= j) {
                    int i3 = (int) (andIncrement2 % ((long) SemaphoreKt.f));
                    Symbol symbol = SemaphoreKt.b;
                    AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.g;
                    Object andSet = atomicReferenceArray.getAndSet(i3, symbol);
                    if (andSet == null) {
                        int i4 = SemaphoreKt.f823a;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= i4) {
                                Symbol symbol2 = SemaphoreKt.b;
                                Symbol symbol3 = SemaphoreKt.d;
                                while (true) {
                                    if (!atomicReferenceArray.compareAndSet(i3, symbol2, symbol3)) {
                                        if (atomicReferenceArray.get(i3) != symbol2) {
                                            break;
                                        }
                                    } else {
                                        z = true;
                                        break;
                                    }
                                }
                                z = !z;
                                continue;
                            } else if (atomicReferenceArray.get(i3) == SemaphoreKt.c) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    } else if (andSet == SemaphoreKt.e) {
                        continue;
                    } else if (andSet instanceof CancellableContinuation) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                        Symbol i6 = cancellableContinuation.i(Unit.f696a, this.b);
                        if (i6 != null) {
                            cancellableContinuation.F(i6);
                        } else {
                            continue;
                        }
                    } else if (andSet instanceof SelectInstance) {
                        z = ((SelectInstance) andSet).c(this, Unit.f696a);
                        continue;
                    } else {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    z = true;
                    continue;
                }
            } else {
                return;
            }
        } while (!z);
    }
}
