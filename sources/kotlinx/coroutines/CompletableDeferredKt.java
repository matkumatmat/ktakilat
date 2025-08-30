package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class CompletableDeferredKt {
    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.CompletableDeferred, kotlinx.coroutines.JobSupport] */
    public static CompletableDeferred a() {
        ? jobSupport = new JobSupport(true);
        jobSupport.X((Job) null);
        return jobSupport;
    }
}
