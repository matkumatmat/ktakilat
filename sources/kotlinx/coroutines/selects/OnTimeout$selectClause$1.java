package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<OnTimeout, SelectInstance<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 c = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        OnTimeout onTimeout = (OnTimeout) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        long j = onTimeout.f815a;
        if (j <= 0) {
            selectInstance.e(Unit.f696a);
        } else {
            OnTimeout$register$$inlined$Runnable$1 onTimeout$register$$inlined$Runnable$1 = new OnTimeout$register$$inlined$Runnable$1(selectInstance, onTimeout);
            Intrinsics.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            SelectImplementation selectImplementation = (SelectImplementation) selectInstance;
            CoroutineContext coroutineContext = selectImplementation.c;
            selectImplementation.e = DelayKt.c(coroutineContext).m(j, onTimeout$register$$inlined$Runnable$1, coroutineContext);
        }
        return Unit.f696a;
    }
}
