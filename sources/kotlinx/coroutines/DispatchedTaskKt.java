package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,208:1\n186#1,17:226\n1#2:209\n236#3:210\n237#3,2:221\n239#3:225\n103#4,10:211\n114#4,2:223\n57#5,2:243\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n176#1:226,17\n164#1:210\n164#1:221,2\n164#1:225\n164#1:211,10\n164#1:223,2\n206#1:243,2\n*E\n"})
public final class DispatchedTaskKt {
    public static final boolean a(int i) {
        return i == 1 || i == 2;
    }

    public static final void b(CancellableContinuationImpl cancellableContinuationImpl, Continuation continuation, boolean z) {
        Object e;
        UndispatchedCoroutine undispatchedCoroutine;
        Object obj = CancellableContinuationImpl.j.get(cancellableContinuationImpl);
        Throwable d = cancellableContinuationImpl.d(obj);
        if (d != null) {
            Result.Companion companion = Result.Companion;
            e = ResultKt.a(d);
        } else {
            Result.Companion companion2 = Result.Companion;
            e = cancellableContinuationImpl.e(obj);
        }
        Object r2 = Result.m16constructorimpl(e);
        if (z) {
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation continuation2 = dispatchedContinuation.g;
            CoroutineContext context = continuation2.getContext();
            Object c = ThreadContextKt.c(context, dispatchedContinuation.j);
            if (c != ThreadContextKt.f807a) {
                undispatchedCoroutine = CoroutineContextKt.c(continuation2, context, c);
            } else {
                undispatchedCoroutine = null;
            }
            try {
                continuation2.resumeWith(r2);
                Unit unit = Unit.f696a;
            } finally {
                if (undispatchedCoroutine == null || undispatchedCoroutine.r0()) {
                    ThreadContextKt.a(context, c);
                }
            }
        } else {
            continuation.resumeWith(r2);
        }
    }
}
