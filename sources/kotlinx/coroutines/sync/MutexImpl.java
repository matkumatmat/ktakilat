package kotlinx.coroutines.sync;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstanceInternal;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006\u0007R\u0013\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/atomicfu/AtomicRef;", "", "owner", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n369#2,12:315\n1#3:327\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n171#1:315,12\n*E\n"})
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n1#2:315\n*E\n"})
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J=\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000b\u0010\u0019\u001a\u00020\u00188\u0016X\u0005R\u000b\u0010\u001b\u001a\u00020\u001a8\u0016X\u0005R\u000b\u0010\u001c\u001a\u00020\u001a8\u0016X\u0005R\u000b\u0010\u001d\u001a\u00020\u001a8\u0016X\u0005¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "value", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "resume", "(VLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;V)V", "Lkotlin/Result;", "result", "resumeWith", "(Lkotlin/Result;)V", "", "idempotent", "tryResume", "(VLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isActive", "isCancelled", "isCompleted", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {
        public final CancellableContinuationImpl c;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl) {
            this.c = cancellableContinuationImpl;
        }

        public final void F(Object obj) {
            this.c.F(obj);
        }

        public final void b(Segment segment, int i) {
            this.c.b(segment, i);
        }

        public final CoroutineContext getContext() {
            return this.c.g;
        }

        public final Symbol i(Object obj, Function3 function3) {
            MutexImpl mutexImpl = MutexImpl.this;
            a aVar = new a(mutexImpl, this);
            Symbol C = this.c.C((Unit) obj, aVar);
            if (C != null) {
                MutexImpl.h.set(mutexImpl, (Object) null);
            }
            return C;
        }

        public final void l(Object obj, Function3 function3) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.h;
            MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, (Object) null);
            b bVar = new b(mutexImpl, this);
            CancellableContinuationImpl cancellableContinuationImpl = this.c;
            cancellableContinuationImpl.z((Unit) obj, cancellableContinuationImpl.e, new l1(bVar, 1));
        }

        public final void resumeWith(Object obj) {
            this.c.resumeWith(obj);
        }

        public final boolean u(Throwable th) {
            return this.c.u(th);
        }
    }

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n1#2:315\n*E\n"})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u000b\u0010\u0004\u001a\u00020\u00038\u0016X\u0005¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Lkotlin/coroutines/CoroutineContext;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class SelectInstanceWithOwner<Q> implements SelectInstanceInternal<Q> {
        public final SelectInstanceInternal c;
        public final Object d;

        public SelectInstanceWithOwner(SelectInstanceInternal selectInstanceInternal, Object obj) {
            this.c = selectInstanceInternal;
            this.d = obj;
        }

        public final void a(DisposableHandle disposableHandle) {
            this.c.a(disposableHandle);
        }

        public final void b(Segment segment, int i) {
            this.c.b(segment, i);
        }

        public final boolean c(Object obj, Object obj2) {
            boolean c2 = this.c.c(obj, obj2);
            if (c2) {
                MutexImpl.h.set(MutexImpl.this, this.d);
            }
            return c2;
        }

        public final void e(Object obj) {
            MutexImpl.h.set(MutexImpl.this, this.d);
            this.c.e(obj);
        }

        public final CoroutineContext getContext() {
            return this.c.getContext();
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        Symbol symbol;
        if (z) {
            symbol = null;
        } else {
            symbol = MutexKt.f821a;
        }
        this.owner$volatile = symbol;
    }

    public final boolean a(Object obj) {
        char c;
        char c2;
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = SemaphoreAndMutexImpl.g;
            int i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = this.f822a;
            if (i2 > i3) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i3) {
                        break;
                    }
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i, i3));
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                if (i2 <= 0) {
                    if (obj != null) {
                        while (true) {
                            if (!b()) {
                                c2 = 0;
                                break;
                            }
                            Object obj2 = atomicReferenceFieldUpdater.get(this);
                            if (obj2 != MutexKt.f821a) {
                                if (obj2 == obj) {
                                    c2 = 1;
                                } else {
                                    c2 = 2;
                                }
                            }
                        }
                        if (c2 != 1) {
                            if (c2 == 2) {
                                break;
                            }
                        } else {
                            c = 2;
                            break;
                        }
                    } else {
                        break;
                    }
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    c = 0;
                    break;
                }
            }
        }
        c = 1;
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public final boolean b() {
        if (Math.max(SemaphoreAndMutexImpl.g.get(this), 0) == 0) {
            return true;
        }
        return false;
    }

    public final void c(Object obj) {
        while (b()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = MutexKt.f821a;
            if (obj2 != symbol) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        }
                    }
                    release();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final Object d(ContinuationImpl continuationImpl) {
        Object obj;
        if (a((Object) null)) {
            return Unit.f696a;
        }
        CancellableContinuationImpl b = CancellableContinuationKt.b(IntrinsicsKt.b(continuationImpl));
        try {
            CancellableContinuationWithOwner cancellableContinuationWithOwner = new CancellableContinuationWithOwner(b);
            while (true) {
                int andDecrement = SemaphoreAndMutexImpl.g.getAndDecrement(this);
                if (andDecrement <= this.f822a) {
                    if (andDecrement > 0) {
                        cancellableContinuationWithOwner.l(Unit.f696a, this.b);
                        break;
                    } else if (f(cancellableContinuationWithOwner)) {
                        break;
                    }
                }
            }
            Object p = b.p();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (p == coroutineSingletons) {
                Intrinsics.checkNotNullParameter(continuationImpl, TypedValues.AttributesType.S_FRAME);
            }
            if (p == coroutineSingletons) {
                obj = p;
            } else {
                obj = Unit.f696a;
            }
            if (obj == coroutineSingletons) {
                return obj;
            }
            return Unit.f696a;
        } catch (Throwable th) {
            b.y();
            throw th;
        }
    }

    public final String toString() {
        return "Mutex@" + DebugStringsKt.a(this) + "[isLocked=" + b() + ",owner=" + h.get(this) + ']';
    }
}
