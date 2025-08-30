package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
final class ResumeAwaitOnCompletion<T> extends JobNode {
    public final CancellableContinuationImpl g;

    public ResumeAwaitOnCompletion(CancellableContinuationImpl cancellableContinuationImpl) {
        this.g = cancellableContinuationImpl;
    }

    public final boolean k() {
        return false;
    }

    public final void l(Throwable th) {
        Object obj = JobSupport.c.get(j());
        boolean z = obj instanceof CompletedExceptionally;
        CancellableContinuationImpl cancellableContinuationImpl = this.g;
        if (z) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(((CompletedExceptionally) obj).f764a)));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(JobSupportKt.a(obj)));
    }
}
