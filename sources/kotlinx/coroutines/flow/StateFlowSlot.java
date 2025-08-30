package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 Concurrent.common.kt\nkotlinx/coroutines/internal/Concurrent_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,433:1\n37#2,2:434\n1#3:436\n351#4,11:437\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n280#1:434,2\n303#1:437,11\n*E\n"})
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f789a = new AtomicReference((Object) null);

    public final boolean a(AbstractSharedFlow abstractSharedFlow) {
        StateFlowImpl stateFlowImpl = (StateFlowImpl) abstractSharedFlow;
        AtomicReference atomicReference = this.f789a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(StateFlowKt.f788a);
        return true;
    }

    public final Continuation[] b(AbstractSharedFlow abstractSharedFlow) {
        StateFlowImpl stateFlowImpl = (StateFlowImpl) abstractSharedFlow;
        this.f789a.set((Object) null);
        return AbstractSharedFlowKt.f790a;
    }

    public final Object c(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        AtomicReference atomicReference = this.f789a;
        Symbol symbol = StateFlowKt.f788a;
        while (true) {
            if (!atomicReference.compareAndSet(symbol, cancellableContinuationImpl)) {
                if (atomicReference.get() != symbol) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(Unit.f696a));
                    break;
                }
            } else {
                break;
            }
        }
        Object p = cancellableContinuationImpl.p();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (p == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        if (p == coroutineSingletons) {
            return p;
        }
        return Unit.f696a;
    }
}
