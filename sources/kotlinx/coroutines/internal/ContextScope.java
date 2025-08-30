package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextScope implements CoroutineScope {
    public final CoroutineContext c;

    public ContextScope(CoroutineContext coroutineContext) {
        this.c = coroutineContext;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.c;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.c + ')';
    }
}
