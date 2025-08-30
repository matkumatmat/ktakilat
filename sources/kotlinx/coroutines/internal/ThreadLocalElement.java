package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {
    public final Object E(CoroutineContext coroutineContext) {
        throw null;
    }

    public final Object fold(Object obj, Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return function2.invoke(obj, this);
    }

    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        if (Intrinsics.a((Object) null, key)) {
            return this;
        }
        return null;
    }

    public final CoroutineContext.Key getKey() {
        return null;
    }

    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        if (Intrinsics.a((Object) null, key)) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return this;
    }

    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.c(coroutineContext, this);
    }

    public final String toString() {
        return "ThreadLocal(value=null, threadLocal = null)";
    }

    public final void v(Object obj) {
        throw null;
    }
}
