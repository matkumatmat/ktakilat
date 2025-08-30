package coil3.network.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SingleParameterLazyKt {
    /* JADX WARNING: type inference failed for: r0v0, types: [coil3.network.internal.SingleParameterLazy, java.lang.Object] */
    public static final SingleParameterLazy a(Function1 function1) {
        ? obj = new Object();
        obj.f132a = function1;
        obj.b = UNINITIALIZED.f133a;
        return obj;
    }
}
