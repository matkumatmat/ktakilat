package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ResumeOnCompletion extends JobNode {
    public final CancellableContinuationImpl g;

    public ResumeOnCompletion(CancellableContinuationImpl cancellableContinuationImpl) {
        this.g = cancellableContinuationImpl;
    }

    public final boolean k() {
        return false;
    }

    public final void l(Throwable th) {
        Result.Companion companion = Result.Companion;
        this.g.resumeWith(Result.m16constructorimpl(Unit.f696a));
    }
}
