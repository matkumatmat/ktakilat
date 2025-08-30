package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyActorCoroutine<E> extends ActorCoroutine<E> {
    public static final /* synthetic */ int g = 0;

    public final Object A(Object obj, Continuation continuation) {
        start();
        Object A = super.A(obj, continuation);
        if (A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return A;
        }
        return Unit.f696a;
    }

    public final void h0() {
        CancellableKt.a((Continuation) null, this);
    }

    public final boolean o(Throwable th) {
        boolean o = super.o(th);
        start();
        return o;
    }

    public final Object z(Object obj) {
        start();
        return super.z(obj);
    }
}
