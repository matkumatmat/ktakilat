package coil3.network.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/network/internal/SingleParameterLazy;", "P", "T", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SingleParameterLazy<P, T> {

    /* renamed from: a  reason: collision with root package name */
    public Function1 f132a;
    public Object b;

    public final Object a(Object obj) {
        Object obj2;
        Object obj3 = this.b;
        UNINITIALIZED uninitialized = UNINITIALIZED.f133a;
        if (obj3 != uninitialized) {
            return obj3;
        }
        synchronized (this) {
            obj2 = this.b;
            if (obj2 == uninitialized) {
                Function1 function1 = this.f132a;
                Intrinsics.c(function1);
                obj2 = function1.invoke(obj);
                this.b = obj2;
                this.f132a = null;
            }
        }
        return obj2;
    }
}
