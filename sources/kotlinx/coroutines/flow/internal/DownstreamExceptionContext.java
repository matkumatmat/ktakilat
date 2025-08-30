package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DownstreamExceptionContext implements CoroutineContext {
    public final /* synthetic */ CoroutineContext c;
    public final Throwable d;

    public DownstreamExceptionContext(CoroutineContext coroutineContext, Throwable th) {
        this.c = coroutineContext;
        this.d = th;
    }

    public final Object fold(Object obj, Function2 function2) {
        return this.c.fold(obj, function2);
    }

    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.c.get(key);
    }

    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.c.minusKey(key);
    }

    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.c.plus(coroutineContext);
    }
}
