package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InterruptibleKt {
    public static Object a(Function0 function0, ContinuationImpl continuationImpl) {
        return BuildersKt.d(new InterruptibleKt$runInterruptible$2(function0, (Continuation) null), EmptyCoroutineContext.INSTANCE, continuationImpl);
    }
}
