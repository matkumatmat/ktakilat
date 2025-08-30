package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class BufferedChannel$bindCancellationFunResult$1 extends FunctionReferenceImpl implements Function3<Throwable, ChannelResult<Object>, CoroutineContext, Unit> {
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Throwable th = (Throwable) obj;
        Object obj4 = ((ChannelResult) obj2).f775a;
        CoroutineContext coroutineContext = (CoroutineContext) obj3;
        Function1 function1 = ((BufferedChannel) this.receiver).d;
        Intrinsics.c(function1);
        if (obj4 instanceof ChannelResult.Failed) {
            obj4 = null;
        }
        Intrinsics.c(obj4);
        OnUndeliveredElementKt.a(function1, obj4, coroutineContext);
        return Unit.f696a;
    }
}
