package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1#2:131\n*E\n"})
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        u();
        throw null;
    }

    public final void h(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        u();
        throw null;
    }

    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        u();
        throw null;
    }

    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        u();
        throw null;
    }

    public final DisposableHandle m(long j, Runnable runnable, CoroutineContext coroutineContext) {
        u();
        throw null;
    }

    public final MainCoroutineDispatcher t() {
        return this;
    }

    public final String toString() {
        return "Dispatchers.Main[missing" + "" + ']';
    }

    public final void u() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
