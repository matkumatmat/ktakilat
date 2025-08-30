package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<LazyActorCoroutine<?>, SelectInstance<?>, Object, Unit> {
    static {
        new LazyActorCoroutine$onSend$1();
    }

    public LazyActorCoroutine$onSend$1() {
        super(3, LazyActorCoroutine.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LazyActorCoroutine lazyActorCoroutine = (LazyActorCoroutine) obj;
        int i = LazyActorCoroutine.g;
        lazyActorCoroutine.getClass();
        CancellableKt.a((Continuation) null, lazyActorCoroutine);
        BufferedChannel bufferedChannel = lazyActorCoroutine.f;
        bufferedChannel.getClass();
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.c;
        Intrinsics.d(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        TypeIntrinsics.c(3, bufferedChannel$onSend$1);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.c;
        Intrinsics.d(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        TypeIntrinsics.c(3, bufferedChannel$onSend$2);
        new SelectClause2Impl(bufferedChannel, bufferedChannel$onSend$1, bufferedChannel$onSend$2).a().invoke(lazyActorCoroutine, (SelectInstance) obj2, obj3);
        return Unit.f696a;
    }
}
