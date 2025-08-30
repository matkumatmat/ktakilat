package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<MutexImpl, SelectInstance<?>, Object, Unit> {
    static {
        new MutexImpl$onLock$1();
    }

    public MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int andDecrement;
        MutexImpl mutexImpl = (MutexImpl) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        if (obj3 != null) {
            while (true) {
                if (!mutexImpl.b()) {
                    break;
                }
                Object obj4 = MutexImpl.h.get(mutexImpl);
                if (obj4 != MutexKt.f821a) {
                    if (obj4 == obj3) {
                        selectInstance.e(MutexKt.b);
                    }
                }
            }
        } else {
            mutexImpl.getClass();
        }
        Intrinsics.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        MutexImpl.SelectInstanceWithOwner selectInstanceWithOwner = new MutexImpl.SelectInstanceWithOwner((SelectInstanceInternal) selectInstance, obj3);
        while (true) {
            mutexImpl.getClass();
            do {
                andDecrement = SemaphoreAndMutexImpl.g.getAndDecrement(mutexImpl);
            } while (andDecrement > mutexImpl.f822a);
            if (andDecrement <= 0) {
                if (mutexImpl.f(selectInstanceWithOwner)) {
                    break;
                }
            } else {
                selectInstanceWithOwner.e(Unit.f696a);
                break;
            }
        }
        return Unit.f696a;
    }
}
