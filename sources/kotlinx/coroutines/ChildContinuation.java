package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ChildContinuation extends JobNode {
    public final CancellableContinuationImpl g;

    public ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl) {
        this.g = cancellableContinuationImpl;
    }

    public final boolean k() {
        return true;
    }

    public final void l(Throwable th) {
        JobSupport j = j();
        CancellableContinuationImpl cancellableContinuationImpl = this.g;
        Throwable o = cancellableContinuationImpl.o(j);
        if (cancellableContinuationImpl.v()) {
            Continuation continuation = cancellableContinuationImpl.f;
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            loop0:
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.k;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = DispatchedContinuationKt.b;
                if (!Intrinsics.a(obj, symbol)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, (Object) null)) {
                            if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, o)) {
                    if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                    }
                }
                return;
            }
        }
        cancellableContinuationImpl.u(o);
        if (!cancellableContinuationImpl.v()) {
            cancellableContinuationImpl.m();
        }
    }
}
